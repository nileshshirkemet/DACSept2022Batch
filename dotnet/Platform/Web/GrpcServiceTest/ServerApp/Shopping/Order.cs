namespace ServerApp.Shopping;

public class Order
{
    public int Id { get; set; }

    public DateTime OrderDate { get; set; }

    public string CustomerId { get; set; }

    public int ProductNo { get; set; }

    public int Quantity { get; set; }
}
