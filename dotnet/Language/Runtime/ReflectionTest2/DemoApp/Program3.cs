using Finance;
using System.Reflection;

using Interest = System.Func<double, int, float>;

class Program
{
    static void Main(string[] args)
    {
        double p = double.Parse(args[0]);
        Type t = Type.GetType(args[1]);
        MethodInfo scheme = t.GetMethod(args[2]);
        object policy = Activator.CreateInstance(t);
        Interest rate = scheme.CreateDelegate<Interest>(policy);
        MaxDurationAttribute md = scheme.GetCustomAttribute<MaxDurationAttribute>();
        int m = md?.Limit ?? 10; //md != null ? md.Limit : 10;
        for(int n = 1; n <= m; ++n)
        {
            float i = rate(p, n) / 1200; 
            double emi = p * i / (1 - Math.Pow(1 + i, -12 * n));
            Console.WriteLine("{0, -6}{1, 12:0.00}", n, emi);
        }
    }
}