using System;

class Program 
{
	private static void Decide(ref Investment x)
	{
		x.AllowRisk(x.TotalAmount() < 500000);
	}

	public static void Main(string[] args)
	{
		Console.WriteLine("Welcome Visitor!");
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		Investment inv = new Investment(p, n);
		Console.WriteLine("Future value of safe investment: {0:0.00}", 
			inv.FutureValue());
		inv.AllowRisk(true);
		Console.WriteLine("Future value of riskful investment: {0:0.00}", 
			inv.FutureValue());
		Decide(ref inv);
		Console.WriteLine("Future value of smart investment: {0:0.00}", 
			inv.FutureValue());
	}
}
