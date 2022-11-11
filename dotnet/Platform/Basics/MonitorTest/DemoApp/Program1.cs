var acc = new JointAccount();
acc.Deposit(5000);
Console.WriteLine("Account opened for Jack and Jill.");
Console.WriteLine("Initial Balance = {0}", acc.Balance);
Console.WriteLine("Jack is withdrawing 3000...");
if(acc.Withdraw(3000) == false)
    Console.WriteLine("Jack's withdraw operation failed!");
Console.WriteLine("Jill is withdrawing 4000...");
if(acc.Withdraw(4000) == false)
    Console.WriteLine("Jill's withdraw operation failed!");
Console.WriteLine("Final Balance   = {0}", acc.Balance);


class JointAccount
{
    public int Balance { get; set; }

    public void Deposit(int amount)
    {
        Balance = Worker.DoWork(amount, Balance, 1);
    }

    public bool Withdraw(int amount)
    {
        bool success = false;
        if(Balance >= amount)
        {
            Balance = Worker.DoWork(amount, Balance, -1);
            success = true;
        }
        return success;
    }
}
