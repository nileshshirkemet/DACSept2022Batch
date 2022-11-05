class Program
{
    public static void Main()
    {
        SimpleStack<string> a = new SimpleStack<string>();
        a.Push("Monday");
        a.Push("Tuesday");
        a.Push("Wednesday");
        a.Push("Thursday");
        a.Push("Friday");
        for(var i = a.GetEnumerator(); i.MoveNext(); )
            Console.WriteLine(i.Current);
        Console.WriteLine("--------------");
        while(!a.Empty())
            Console.WriteLine(a.Pop());
        Console.WriteLine("--------------");
        SimpleStack<double> b = new SimpleStack<double>();
        b.Push(23.51);
        b.Push(47.62);
        b.Push(58.73);
        b.Push(35.24);
        foreach(double d in b)
            Console.WriteLine(d);
    }
}