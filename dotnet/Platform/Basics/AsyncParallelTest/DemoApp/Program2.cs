class Program
{
    private static Task DoComputation(int limit)
    {
        Console.Write("Computing...");
        var c = new Computation();
        var w = new System.Diagnostics.Stopwatch();
        w.Start();
        return c.ComputeAsync(1, limit)
                .ContinueWith(previous => 
                {
                    long r = previous.Result;
                    w.Stop();
                    Console.WriteLine("Done!");
                    Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, w.Elapsed.TotalSeconds);
                });
    }

    static void Main(string[] args)
    {
        int n = int.Parse(args[0]);
        var job = DoComputation(n);
        while(!job.IsCompleted)
        {
            Console.Write(".");
            Thread.Sleep(500);
        }
    }

    class Computation
    {
        public long Compute(int first, int last)
        {
            return Enumerable.Range(first, last - first + 1)
                        .Select(Worker.DoWork)
                        .Sum();
        }

        public Task<long> ComputeAsync(int first, int last)
        {
            //the operation passed to Run is invoked by a pooled
            //thread allowing the caller thread to resume and obtain
            //the result of invocation from the retuned Task once the
            //pooled thread completes that invocation
            return Task<long>.Run(() => Compute(first, last));
        }
    }
}