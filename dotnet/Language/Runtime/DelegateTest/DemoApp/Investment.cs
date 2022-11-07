delegate float InterestRate(int period);

//this class produces an instance which is an immutable object
class Investment
{
    public double Payment { get; }

    public int Years { get; }

    public Investment(double amount, int count)
    {
        Payment = amount;
        Years = count;
    }  

    public double FutureValue(InterestRate rate)
    {
        float i = rate.Invoke(Years) / 100;
        return (Payment / i) * (Math.Pow(1 + i, Years) - 1);
    }
}
