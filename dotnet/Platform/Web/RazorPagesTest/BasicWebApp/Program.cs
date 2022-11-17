using BasicWebApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages();
builder.Services.AddSingleton<ICounter, NamedCounter>();
var app = builder.Build();
app.MapRazorPages();
app.Run();
