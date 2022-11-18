using System.ComponentModel.DataAnnotations.Schema;

namespace ClassicWebApp.Data;

[Table("OrderDetail")]
public class Order
{
    [Column("OrderNo")]
    public int Id { get; set; }

    public DateTime OrderDate { get; set; }

    public string CustomerId { get; set; }

    [Column("ProductNo")]
    public int ProductId { get; set; }

    public int Quantity { get; set; }
}
