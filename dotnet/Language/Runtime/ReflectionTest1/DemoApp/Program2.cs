class Program
{
    private static void PrintAsXml(object info)
    {
        Type t = info.GetType();
        Console.WriteLine("<{0}>", t.Name);
        foreach(var pi in t.GetProperties())
            Console.WriteLine("  <{0}>{1}</{0}>", pi.Name, pi.GetValue(info));
        Console.WriteLine("</{0}>", t.Name);
        Console.WriteLine();
    }



    public static void Main()
    {
        PrintAsXml(new Item("Printer", "Canon"));
        PrintAsXml(new Item("WebCam", "Philips"));
        PrintAsXml(new Customer("Jack", 32000, 2));
    }
}