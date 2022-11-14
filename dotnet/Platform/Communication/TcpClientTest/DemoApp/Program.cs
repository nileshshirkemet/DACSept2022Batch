using System.Net.Sockets;

string item = args[0].ToLower();
int quantity = int.Parse(args[1]);
string host = args[2];
using TcpClient client = new TcpClient(host, 4010);
using Stream channel = client.GetStream();
using StreamReader reader = new StreamReader(channel);
using StreamWriter writer = new StreamWriter(channel);
Console.WriteLine(reader.ReadLine());
writer.WriteLine(item);
writer.Flush();
string response = reader.ReadLine();
if(response is not null)
{
    ItemInfo info = ItemInfo.Parse(response);
    if(quantity <= info.Stock)
        Console.WriteLine("Total Payment: {0:0.00}", quantity * info.Price);
    else
        Console.WriteLine("Item out of stock!");
}
else
{
    Console.WriteLine("Item not sold!");
}
