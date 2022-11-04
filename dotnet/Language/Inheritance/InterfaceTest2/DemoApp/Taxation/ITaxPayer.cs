namespace Taxation;

interface ITaxPayer
{
    double AnnualIncome();

    double IncomeTax()
    {
        double i = AnnualIncome();
        return i > 120000 ? 0.15 * (i - 120000) : 0;
    }
}