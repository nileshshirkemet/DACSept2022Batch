using System.Text;
using System.Net.Sockets;

static class Client
{
    public static void Run(string text)
    {
        var cs = Encoding.UTF8;
        //Step 1
        Socket server = new Socket(AddressFamily.Unix, SocketType.Stream, ProtocolType.Unspecified);
        server.Connect(new UnixDomainSocketEndPoint(Server.ServiceName));
        //Step 2
        server.Send(cs.GetBytes(text));
        byte[] buffer = new byte[80];
        int n = server.Receive(buffer);
        Console.WriteLine(cs.GetString(buffer[0..n]));
        //Step 3
        server.Close();
    }
}