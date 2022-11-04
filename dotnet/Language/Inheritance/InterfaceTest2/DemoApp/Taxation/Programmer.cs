namespace Taxation;

struct Programmer : ITaxPayer
{
    private int lines;

    public Programmer(int count)
    {
        lines = count;
    }

    public double AnnualIncome()
    {
        return 300000 + 0.25 * lines;
    }
}
