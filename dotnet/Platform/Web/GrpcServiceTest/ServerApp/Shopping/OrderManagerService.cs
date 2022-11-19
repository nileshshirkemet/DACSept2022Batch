using Sales;
using Grpc.Core;

namespace ServerApp.Shopping;

public class OrderManagerService : OrderManager.OrderManagerBase
{
    public override async Task<OrderStatus> PlaceOrder(OrderInput request, ServerCallContext context)
    //public override Task<OrderStatus> PlaceOrder(OrderInput request, ServerCallContext context)
    {
        var reply = new OrderStatus();
        var db = new ShopDbContext();
        try
        {
            var ctr = db.Counters.Find("order");
            var order = new Order
            {
                Id = ++ctr.CurrentValue + ctr.SeedValue,
                OrderDate = DateTime.Today,
                CustomerId = request.CustomerName,
                ProductNo = request.ItemCode,
                Quantity = request.ItemCount
            };
            db.Orders.Add(order);
            await db.SaveChangesAsync();
            //db.SaveChanges();
            reply.ConfirmationCode = order.Id;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            context.Status = new Status(StatusCode.Internal, "Order Failed");
        }
        return reply;
        //return Task.FromResult(reply);
    }

    public override async Task FetchInvoice(CustomerInput request, IServerStreamWriter<CustomerOrder> responseStream, ServerCallContext context)
    {
        var db = new ShopDbContext();
        var selection = from e in db.Orders
                        where e.CustomerId == request.CustomerName
                        select new CustomerOrder
                        {
                            ItemCode = e.ProductNo,
                            ItemCount = e.Quantity,
                            DateOfOrder = e.OrderDate.ToString("yyyy-mm-dd")
                        };
        foreach(var entry in selection)
            await responseStream.WriteAsync(entry);
    }
}