using System.Net;

static class Server
{
    public static void Run()
    {
        var shop = Shop.Open("store.xml");
        var server = new HttpListener();
        server.Prefixes.Add("http://localhost:8010/shopping/");
        server.Start();
        for(;;)
        {
            var client = server.GetContext();
            using var writer = new StreamWriter(client.Response.OutputStream);
            string item = client.Request.Url.Segments[2];
            string info = shop.GetItemInfo(item);
            if(info != null)
            {
                client.Response.ContentType = "text/plain";
                writer.WriteLine(info);
            }
            else
            {
                client.Response.StatusCode = 404;
            }
        }
    }
}