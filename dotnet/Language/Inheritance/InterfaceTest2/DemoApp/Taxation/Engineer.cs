namespace Taxation;

struct Engineer : ITaxPayer
{
    private int projects;

    public Engineer(int count)
    {
        projects = count;
    }

    public double AnnualIncome()
    {
        return 500000 + 30000 * projects;
    }
}