Console.Write("Yearly Payment : ");
double p = double.Parse(Console.ReadLine());
Console.Write("Number of Years: ");
int y = int.Parse(Console.ReadLine());
var inv = new Investment(p, y);
Console.WriteLine("Future value for riskless investment: {0:0.00}",
    inv.FutureValue(SafeScheme)); //passing method
Console.WriteLine("Future value for riskful investment : {0:0.00}",
    inv.FutureValue(n => 9 + 0.25f * n)); //passing lamda expression
if(args.Length > 0)
{
    Action<string> greet = s => Console.WriteLine("Hi {0}", s);
    greet += s => Console.WriteLine("Bye {0}", s);
    greet(args[0]); //implicitly calling Invoke
}

float SafeScheme(int n)
{
    return n < 3 ? 6 : 8;
}