using BasicWebApp.Services;
using Tourism;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();
builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddTransient<ISiteStore, XmlSiteStore>();
var app = builder.Build();
app.MapDefaultControllerRoute();
app.Run();
