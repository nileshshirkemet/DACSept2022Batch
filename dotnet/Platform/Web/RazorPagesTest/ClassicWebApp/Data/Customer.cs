using System.ComponentModel.DataAnnotations.Schema;

namespace ClassicWebApp.Data;

[Table("CustomerInfo")]
public class Customer
{
    [Column("UserName")]
    public string Id { get; set; }

    public string Password { get; set; }

    public ICollection<Order> Orders { get; set; }
}
