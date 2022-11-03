class Program
{
    private static void Print(string label, object info)
    {
        Console.WriteLine("{0} = {1}", label, info.ToString());
    }

    public static void Main(string[] args)
    {
        Interval a = new Interval(6, 5);
        Interval b = new Interval(4, 30);
        Interval c = new Interval(5, 65);
        Interval d = b;
        Interval t = a + b + c + d;
        Print("Interval a", a);
        Print("Interval b", b);
        Print("Interval c", c);
        Print("Interval d", d);
        Print("Total", t);
        Console.WriteLine("---------------------------------");
        Console.WriteLine("a is identical to b: {0}", ReferenceEquals(a, b));
        Console.WriteLine("a is identical to c: {0}", ReferenceEquals(a, c));
        Console.WriteLine("d is identical to b: {0}", ReferenceEquals(d, b));
        Console.WriteLine("---------------------------------");
        Console.WriteLine("a is equal to b: {0}", a.GetHashCode() == b.GetHashCode() && a.Equals(b));
        Console.WriteLine("a is equal to c: {0}", a.GetHashCode() == c.GetHashCode() && a.Equals(c));
        Console.WriteLine("d is equal to b: {0}", d.GetHashCode() == b.GetHashCode() && d.Equals(b));
        Rectangle r = new Rectangle(12, 9);
        Print("Rectangle r", r); //auto-boxing in conversion of value-type to reference type
    }
}
