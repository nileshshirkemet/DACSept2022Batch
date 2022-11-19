var builder = WebApplication.CreateBuilder(args);
builder.Services.AddGrpc(); //enable gRPC
var app = builder.Build();
app.MapGrpcService<ServerApp.Shopping.OrderManagerService>();
//gRPC requires HTTP/2 endpoint, see Kestrel setting in appsettings.json
app.Run("http://localhost:4000");
