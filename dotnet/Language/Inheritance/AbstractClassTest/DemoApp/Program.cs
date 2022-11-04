using Met.Banking;

Account jack = Banker.OpenCurrentAccount();
jack.Deposit(20000);
Account jill = Banker.OpenSavingsAccount();
jill.Deposit(15000);
try
{
    double payment = double.Parse(args[0]);
    jill.Transfer(payment, jack);
    Console.WriteLine("Payment succeeded.");
}
catch(InsufficientFundsException)
{
    Console.WriteLine("Payment failed due to lack of funds!");
    Banker.FreezeAccount(jill);
}
catch(Exception ex)
{
    Console.WriteLine("Error: {0}", ex.Message);
}
Console.WriteLine($"Jack's Account ID is {jack.Id} and Balance is {jack.Balance}");
Console.WriteLine($"Jill's Account ID is {jill.Id} and Balance is {jill.Balance}");
