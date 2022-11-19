using Sales;
using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace ModernWebApp.Controllers;

using Resources;

[ApiController]
[Route("/api/orders")]
public class OrdersController : ControllerBase
{
    private OrderManager.OrderManagerClient client;

    public OrdersController(OrderManager.OrderManagerClient client)
    {
        this.client = client;
    }

    [HttpGet]
    [Route("{id}")]
    public async Task<ActionResult<List<OrderResource>>> ReadOrders(string id)
    {
        try
        {
            var request = new CustomerInput { CustomerName = id };
            using var reply = client.FetchInvoice(request);
            var orders = new List<OrderResource>();
            await foreach(var entry in reply.ResponseStream.ReadAllAsync())
            {
                orders.Add(new OrderResource 
                {
                    ProductNo = entry.ItemCode,
                    Quantity = entry.ItemCount,
                    OrderDate = entry.DateOfOrder
                });
            }
            if(orders.Count == 0)
                return NotFound();
            return orders;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            return StatusCode(500);
        }
    }

    [HttpPost]
    public async Task<ActionResult<OrderResource>> CreateOrder(OrderResource resource)
    {
        try
        {
            var request = new OrderInput 
            {
                CustomerName = resource.CustomerId,
                ItemCode = resource.ProductNo,
                ItemCount = resource.Quantity
            };
            var reply = await client.PlaceOrderAsync(request);
            resource.OrderNo = reply.ConfirmationCode;
            return resource;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            return StatusCode(500);
        }
    }
}
