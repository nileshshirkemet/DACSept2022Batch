class Program
{
    private static double Average(double first, double second, params double[] other)
    {
        double total = first + second;
        foreach(double value in other)
            total += value;
        return total / (2 + other.Length);
    }

    //an 'out' parameter is same as a 'ref' parameter but it accepts uninitialized
    //argument which must be initialized by the its declaring method before it returns
    private static double AverageWithDeviation(double first, double second, out double dev)
    {
        dev = first > second ? (first - second) / 2 : (second - first) / 2;
        return Average(first, second);
    }

    public static void Main(string[] args)
    {
        Console.WriteLine("Average of two values = {0}", 
            Average(23.4, 29.1));
        Console.WriteLine("Average of three values = {0}", 
            Average(23.4, 29.1, 18.6));
        Console.WriteLine("Average of five values = {0}", 
            Average(23.4, 29.1, 18.6, 31.5, 24.7));
        if(args.Length > 1)
        {
            double x = double.Parse(args[0]);
            double y = double.Parse(args[1]);
            double a = AverageWithDeviation(x, y, out double d);
            Console.WriteLine("Average is {0:0.000} with a deviation of {1:0.00}", a, d);           
        }
    }
}