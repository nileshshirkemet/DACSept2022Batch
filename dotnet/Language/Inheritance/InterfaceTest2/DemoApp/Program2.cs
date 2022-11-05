using Taxation;

class Program
{
    //nested class - can only refer to static members of outer class
    class Auditor : IDisposable
    {
        internal Auditor()
        {
            Console.WriteLine("Acquiring resources.");
        }

        public void Audit(string id, ITaxPayer person)
        {
            if(id.Length < 4)
                throw new ArgumentException("Invalid ID");
            double payment = person.IncomeTax() + 500;
            Console.WriteLine("Total Payment: {0:0.00}", payment);
        }

        public void Dispose()
        {
            Console.WriteLine("Releasing resources.");
        }
    }

    private static void Process(string name, int count)
    {
        ITaxPayer t = name == "jack" ? new Engineer(count) : new Programmer(count);
        using(Auditor a = new Auditor())
        {
            a.Audit(name, t);
        }
    }

    public static void Main(string[] args)
    {
        try
        {
            string m = args[0].ToLower();
            int n = int.Parse(args[1]);
            Process(m, n);
        }
        catch(Exception ex)
        {
            Console.WriteLine($"Error: {ex.Message}");
        }
    }
}