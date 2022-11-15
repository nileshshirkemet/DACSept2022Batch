using DemoApp.Shopping;

var db = new ShopDbContext();

if(args.Length == 0)
{
    foreach(var product in db.Products)
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", product.Id, product.Price, product.Stock);
}
else
{
    int pno = int.Parse(args[0]);
    var product = db.Products
                .Where(p => p.Id == pno)
                .Include(p => p.Orders)
                .FirstOrDefault();
    if(product != null)
    {
        foreach(var order in product.Orders)
            Console.WriteLine("{0}\t{1}\t{2:yyyy-MMM-dd}", order.CustomerId, order.Quantity, order.OrderDate);
    }
}
