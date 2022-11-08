namespace Finance;


public class PersonalLoan
{
    [MaxDuration(6)]
    public float Common(double amount, int period) => 10 + 0.5f * period;

    public float Employee(double amount, int period) => Common(amount, period) / 2; 
}
