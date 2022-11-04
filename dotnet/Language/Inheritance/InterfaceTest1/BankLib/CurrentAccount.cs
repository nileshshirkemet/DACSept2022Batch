namespace Met.Banking;

//a class defined with sealed modifier cannot be
//used as a base class
sealed class CurrentAccount : Account, IFinable
{
    public override void Deposit(double amount)
    {
        Balance += amount;
    }

    public override void Withdraw(double amount)
    {
        Balance -= amount;
    }

    //explicit interface implementation
    bool IFinable.Withdraw(double fine)
    {
        if(Balance < 0)
        {
            Balance -= fine;
            return true;
        }
        return false;
    }
}