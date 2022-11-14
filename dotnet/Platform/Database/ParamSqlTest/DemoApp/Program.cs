string customerId = args[0].ToUpper();
int productNo = int.Parse(args[1]);
int quantity = int.Parse(args[2]);
using var con = new MySql.Data.MySqlClient.MySqlConnection();
con.ConnectionString = "Server=localhost;Database=shop;User ID=root;Password=root";
con.Open();
using var cmd = con.CreateCommand();
cmd.Transaction = con.BeginTransaction();
try
{
    cmd.CommandText = "UPDATE Counters SET CurrentValue=CurrentValue+1 WHERE Id='order'";
    cmd.ExecuteNonQuery();
    cmd.CommandText = "SELECT CurrentValue+SeedValue FROM Counters WHERE Id='order'";
    long orderNo = (long)cmd.ExecuteScalar();
    cmd.CommandText = "INSERT INTO OrderDetail VALUES(@OrderId, @OrderDate, @Customer, @Product, @Quantity)";
    cmd.Parameters.AddWithValue("@OrderId", orderNo);
    cmd.Parameters.AddWithValue("@OrderDate", DateTime.Today);
    cmd.Parameters.AddWithValue("@Customer", customerId);
    cmd.Parameters.AddWithValue("@Product", productNo);
    cmd.Parameters.AddWithValue("@Quantity", quantity);
    cmd.ExecuteNonQuery();
    cmd.Transaction.Commit();
    Console.WriteLine("New Order Number: {0}", orderNo);
}
catch(Exception)
{
    cmd.Transaction.Rollback();
    Console.WriteLine("Order Failed!");
}