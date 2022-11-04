namespace Met.Banking;

//a class defined with abstract modifier cannot be
//activated, it can only be used as a base class
public abstract class Account
{
    public long Id { get; internal set; }

    public double Balance { get; protected set; }

    //an instance method defined with abstract modifier
    //is pure and it must be overridden in a non-abstract
    //derived class
    public abstract void Deposit(double amount);

    public abstract void Withdraw(double amount);

    public bool Transfer(double amount, Account that)
    {
        if(ReferenceEquals(this, that))
            return false;
        this.Withdraw(amount);
        that.Deposit(amount);
        return true;
    }
}
