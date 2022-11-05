class Program
{
    //a generic method declaration with type-parameter T
    private static T Select<T>(int index, T first, T second)
    {
        if((index % 2) == 1)
            return first;
        return second;
    }

    private static T Select<T>(T first, T second) where T: IComparable<T>
    {
        //if(first.GetHashCode() > second.GetHashCode())
        if(first.CompareTo(second) > 0)
            return first;
        return second;
            
    }
    
    public static void Main(string[] args)
    {
        if(args.Length > 0)
        {
            int s = int.Parse(args[0]);
            string ss = Select(s, "Monday", "Tuesday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = Select(s, 45.6, 34.5);
            Console.WriteLine($"Selected double = {sd}");
            //double ssd = Select(s, "Monday", 34.5);
        }
        else
        {
            string ss = Select("Monday", "Tuesday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = Select(45.6, 34.5);
            Console.WriteLine($"Selected double = {sd}");   
            Interval si = Select(new Interval(3, 45), new Interval(4, 30));       
            Console.WriteLine($"Selected Interval = {si}");
        }
    }
}