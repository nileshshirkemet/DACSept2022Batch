using BasicWebApp.Middlewares;
using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
//builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddSingleton<ICounter, NamedCounter>();
var app = builder.Build();
app.UseStaticFiles();
app.UseMiddleware<Pausing>(1);
app.MapGet("/Welcome", DoGreeting);
app.MapPost("/Count", DoCounting);
app.Run();

async Task DoGreeting(HttpResponse response, string guest = "Visitor")
{
    await response.WriteAsync(@$"
        <html>
            <head>
                <title>BasicWebApp</title>
            </head>
            <body>
                <h1>Welcome {guest}</h1>
                <b>Current Time: </b>{DateTime.Now}
            </body>
        </html>
    ");
}

async Task DoCounting(HttpRequest request, HttpResponse response, ICounter counter)
{
    string user = request.Form["guest"];
    if(user.Length == 0)
    {
        response.Redirect("/formpost.html?noname=true");
    }
    else
    {
        await response.WriteAsync(@$"
            <html>
                <head>
                    <title>BasicWebApp</title>
                </head>
                <body>
                    <h1>Hello {user}</h1>
                    <b>Number of Greetings: </b>{counter.CountNext(user)}
                </body>
            </html>
        ");
    }
}

