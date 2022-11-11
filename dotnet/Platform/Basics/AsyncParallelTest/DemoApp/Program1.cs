class Program
{
    private static void DoComputation(int limit)
    {
        Console.Write("Computing...");
        var c = new Computation();
        var w = new System.Diagnostics.Stopwatch();
        w.Start();
        long r = c.Compute(1, limit);
        w.Stop();
        Console.WriteLine("Done!");
        Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, w.Elapsed.TotalSeconds);
    }

    static void Main(string[] args)
    {
        int n = int.Parse(args[0]);
        DoComputation(n);
    }

    class Computation
    {
        public long Compute(int first, int last)
        {
            return Enumerable.Range(first, last - first + 1)
                        .Select(Worker.DoWork)
                        .Sum();
        }
    }
}