using System.Runtime.CompilerServices;

var acc = new JointAccount();
acc.Deposit(5000);
Console.WriteLine("Account opened for Jack and Jill.");
Console.WriteLine("Initial Balance = {0}", acc.Balance);
Thread child = new Thread(() => 
{
    Console.WriteLine("Jack is withdrawing 3000...");
    if(acc.Withdraw(3000) == false)
        Console.WriteLine("Jack's withdraw operation failed!");
});
child.Start();
Console.WriteLine("Jill is withdrawing 4000...");
if(acc.Withdraw(4000) == false)
    Console.WriteLine("Jill's withdraw operation failed!");
child.Join(); //wait for child to exit
Console.WriteLine("Final Balance   = {0}", acc.Balance);


class JointAccount
{
    public int Balance { get; set; }

    public void Deposit(int amount)
    {
        lock(this)
        {
            Balance = Worker.DoWork(amount, Balance, 1);
            //Pulse (signal) the monitor associated with the specified object
            Monitor.Pulse(this);
        }
    }

    public bool Withdraw(int amount)
    {
        bool success = false;
        //Lock the (reentrant) monitor associated with the specified (this)
        //object before proceeding. Only one thread can lock a given monitor
        //at a time while other threads must wait for this thread to unlock
        //that monitor
        Monitor.Enter(this);
        try
        {
            if(Balance >= amount)
            {
                Balance = Worker.DoWork(amount, Balance, -1);
                success = true;
            }
        }
        finally
        {
            //unlock the monitor associated with the specified (this) object
            Monitor.Exit(this);
        }
        return success;
    }

    [MethodImpl(MethodImplOptions.Synchronized)]
    public bool WithdrawAfterDeposit(int amount)
    {
        //Unlock the monitor assocaied with the specified object, 
        //wait for another thread to pulse this monitor, 
        //re-lock the monitor and resume
        Monitor.Wait(this);
        return Withdraw(amount);
    }
}
