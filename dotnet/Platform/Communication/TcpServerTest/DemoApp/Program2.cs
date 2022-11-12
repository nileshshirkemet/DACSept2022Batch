using System.Net;
using System.Net.Sockets;

class Program
{
    static void Main()
    {
        var listener = new TcpListener(IPAddress.Any, 4010);
        listener.Start();
        for(int i = 0; i < 3; ++i)
        {
            Thread child = new Thread(() => Service(listener));
            child.Start();
        }
    }

    private static void Service(TcpListener listener)
    {
        Shop shop = Shop.Open("store.xml");
        for(;;)
        {
            TcpClient client = listener.AcceptTcpClient();
            client.ReceiveTimeout = 60000;
            Stream channel = client.GetStream();
            StreamReader reader = new StreamReader(channel);
            StreamWriter writer = new StreamWriter(channel) { AutoFlush = true };
            try
            {
                writer.WriteLine("Welcome to CitiTek");
                string item = reader.ReadLine();
                string info = shop.GetItemInfo(item);
                if(info != null)
                    writer.WriteLine(info);
            }
            catch {}
            writer.Close();
            reader.Close();
            client.Close();
        }
    }
}