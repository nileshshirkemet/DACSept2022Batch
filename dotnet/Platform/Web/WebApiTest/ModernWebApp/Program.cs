var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllers();
builder.Services.AddGrpcClient<Sales.OrderManager.OrderManagerClient>(
    options => options.Address = new Uri("http://localhost:4000")
);
var app = builder.Build();
app.UseStaticFiles();
app.MapControllers();
app.Run();

/*
Invoke-RestMethod -Uri http://localhost:5000/api/orders/CU204
Invoke-RestMethod -Method Post -ContentType 'application/json' -Body '{"customerId":"CU204", "productNo":202, "quantity":12}' -Uri http://localhost:5000/api/orders
*/