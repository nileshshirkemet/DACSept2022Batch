namespace Finance;

public class HomeLoan
{
    public float Common(double amount, int period) => amount < 1000000 ? 8.5f : 8.0f;

    [MaxDuration(Limit=12)]
    public float Woman(double amount, int period) => Common(amount, period) - 1;

    public float Soldier(double amount, int period) => 4.0f;
}
