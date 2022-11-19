using Sales;
using Grpc.Core;
using Grpc.Net.Client;

using var channel = GrpcChannel.ForAddress("http://localhost:4000");
var client = new OrderManager.OrderManagerClient(channel);
if(args.Length > 2)
{
    var request = new OrderInput 
    {
        CustomerName = args[0].ToUpper(),
        ItemCode = int.Parse(args[1]),
        ItemCount = int.Parse(args[2])
    };
    try
    {
        var reply = client.PlaceOrder(request);
        Console.WriteLine("New Order Number: {0}", reply.ConfirmationCode);
    }
    catch(RpcException ex)
    {
        Console.WriteLine(ex.Status.Detail);
    }
}
else
{
    var request = new CustomerInput 
    {
        CustomerName = args[0].ToUpper()
    };
    using var reply = client.FetchInvoice(request);
    while(await reply.ResponseStream.MoveNext())
    {
        var order = reply.ResponseStream.Current;
        Console.WriteLine("{0}\t{1}\t{2}", order.ItemCode, order.ItemCount, order.DateOfOrder);
    }
}
