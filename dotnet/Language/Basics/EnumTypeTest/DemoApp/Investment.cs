using System;

enum RiskLevel {None, Low, High}

struct Investment
{
    private double payment;
    private int count;
    private RiskLevel risk;

    public Investment(double amount, int years)
    {
        payment = amount;
        count = years;
        risk = RiskLevel.None;
    }

    public void AllowRisk(bool yes)
    {
        risk = yes ? RiskLevel.Low : RiskLevel.None;
    }

    //method overloading - defining a method whose name matches
    //with another method defined in its type but with different
    //list of parameter types
    public void AllowRisk(RiskLevel level)
    {
        risk = level;
    }

    public double TotalAmount()
    {
        return payment * count;       
    }

    public double FutureValue()
    {
        float i;
        switch(risk)
        {
            case RiskLevel.Low:
                i = 0.08f;
                break;
            case RiskLevel.High:
                i = 0.11f;
                break;
            default:
                i = 0.06f;
                break;
        }
        return (payment / i) * (Math.Pow(1 + i, count) - 1);
    }
}
