using System.Net;

if(args.Length == 0)
    Server.Run();

string item = args[0].ToLower();
int quantity = int.Parse(args[1]);
string host = args[2];
string uri = $"http://{host}:8010/shopping/{item}";
var client = new HttpClient();
try
{
    string response = await client.GetStringAsync(uri); 
    ItemInfo info = ItemInfo.Parse(response);
    if(quantity <= info.Stock)
        Console.WriteLine("Total Payment: {0:0.00}", quantity * info.Price);
    else
        Console.WriteLine("Item out of stock!");
}
catch(HttpRequestException ex) when (ex.StatusCode == HttpStatusCode.NotFound)
{
    Console.WriteLine("Item not sold!");
}