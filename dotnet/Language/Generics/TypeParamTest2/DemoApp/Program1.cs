class Program
{
    private static void PrintStack(SimpleStack<string> store)
    {
        while(!store.Empty())
            Console.WriteLine(store.Pop());
    }

    private static void PrintStack(SimpleStack<Interval> store)
    {
        while(!store.Empty())
            Console.WriteLine(store.Pop());
    }

    public static void Main()
    {
        SimpleStack<string> a = new SimpleStack<string>();
        a.Push("Monday");
        a.Push("Tuesday");
        a.Push("Wednesday");
        a.Push("Thursday");
        a.Push("Friday");
        //a.Push(123.4);
        PrintStack(a);
        Console.WriteLine("---------------");
        SimpleStack<Interval> b = new();
        b.Push(new Interval(5, 31));
        b.Push(new Interval(7, 42));
        b.Push(new Interval(6, 53));
        b.Push(new Interval(4, 14));
        PrintStack(b);
    }
}