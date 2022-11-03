using System;

class Program 
{
	public static void Main(string[] args)
	{
		Console.WriteLine("Welcome Investor!");
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		Console.WriteLine("Future value of safe investment: {0:0.00}", 
			Investment.FutureValue(p, n));
		Console.WriteLine("Future value of riskful investment: {0:0.00}", 
			Investment.FutureValue(p, n, true));
	}
}
