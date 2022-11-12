using System.Net.Sockets;

static class Server
{
    public const string ServiceName = "encrypt.sock";

    public static void Run()
    {
        byte[] buffer = new byte[80];
        File.Delete(ServiceName);
        //Step 1
        Socket listener = new Socket(AddressFamily.Unix, SocketType.Stream, ProtocolType.Unspecified);
        listener.Bind(new UnixDomainSocketEndPoint(ServiceName));
        listener.Listen();
        for(;;)
        {
            //Step 2
            Socket client = listener.Accept();
            //Step 3
            int n = client.Receive(buffer);
            Transformer.Encode(buffer, n);
            client.Send(buffer[0..n]);
            //Step 4
            client.Close();
        }
    }
}