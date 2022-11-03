using System;

struct Investment
{
    private double payment;
    private int count;
    private bool risk;

    public Investment(double amount, int years)
    {
        payment = amount;
        count = years;
        risk = false;
    }

    public void AllowRisk(bool yes)
    {
        risk = yes;
    }

    public double TotalAmount()
    {
        return payment * count;       
    }

    public double FutureValue()
    {
        float i = risk ? 0.08f : 0.06f;
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }
}
