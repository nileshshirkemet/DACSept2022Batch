using System.ComponentModel.DataAnnotations.Schema;

namespace DemoApp.Shopping;

[Table("ProductInfo")]
public class Product
{
    [Column("ProductNo")]
    public int Id { get; set; }

    public decimal Price { get; set; }

    public int Stock { get; set; }

    public List<Order> Orders { get; set; }
}
