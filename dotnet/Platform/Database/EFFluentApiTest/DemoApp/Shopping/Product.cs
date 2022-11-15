namespace DemoApp.Shopping;

public class Product
{
    public int Id { get; set; }

    public decimal Price { get; set; }

    public int Stock { get; set; }

    //navigation property
    public List<Order> Orders { get; set; }
}