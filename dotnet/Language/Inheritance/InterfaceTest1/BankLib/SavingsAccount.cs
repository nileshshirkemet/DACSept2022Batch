namespace Met.Banking;

sealed class SavingsAccount : Account, IProfitable
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

    public double AddInterest(int months)
    {
        float rate = Balance < 20000 ? 4.0f : 4.5f;
        double interest = Balance * rate * months / 1200;
        Balance += interest;
        return interest;
    }
}
