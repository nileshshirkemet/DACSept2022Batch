namespace Met.Banking;

sealed class SavingsAccount : Account
{
    const double MinBal = 5000;

    internal SavingsAccount()
    {
        Balance = MinBal;
    }

    public override void Deposit(double amount)
    {
        Balance += amount;
    }

    public override void Withdraw(double amount)
    {
        if(Balance - amount < MinBal)
            throw new InsufficientFundsException();
        Balance -= amount;
    }
}
