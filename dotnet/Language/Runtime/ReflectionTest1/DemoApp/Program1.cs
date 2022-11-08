class Program
{
    private static void PrintAsXml(Item info)
    {
        Console.WriteLine("<Item>");
        Console.WriteLine("  <Name>{0}</Name>", info.Name);
        Console.WriteLine("  <Brand>{0}</Brand>", info.Brand);
        Console.WriteLine("</Item>");
        Console.WriteLine();
    }

    private static void PrintAsXml(Customer info)
    {
        Console.WriteLine("<Customer>");
        Console.WriteLine("  <Id>{0}</Id>", info.Id);
        Console.WriteLine("  <Payment>{0}</Payment>", info.Payment);
        Console.WriteLine("  <Rating>{0}</Rating>", info.Rating);
        Console.WriteLine("</Customer>");
        Console.WriteLine();
    }

    public static void Main()
    {
        PrintAsXml(new Item("Printer", "Canon"));
        PrintAsXml(new Item("WebCam", "Philips"));
        PrintAsXml(new Customer("Jack", 32000, 2));
    }
}