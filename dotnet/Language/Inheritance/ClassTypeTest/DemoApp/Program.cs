using Payroll;

//C# supports top-level statements which are copied by the
//compiler into the Main method of the auto-generated Program class

Employee jack = new Employee();
jack.Hours = 186;
jack.Rate = 52;
Console.WriteLine("Jack's Income is {0:0.00}, Tax is {1:0.00} and Bonus is {2:0.00}", jack.Income(), Tax(jack), Bonus(jack));
SalesPerson jill = new SalesPerson(186, 52, 48000);
Console.WriteLine("Jill's Income is {0:0.00}, Tax is {1:0.00} and Bonus is {2:0.00}", jill.Income(), Tax(jill), Bonus(jill));
Console.WriteLine("Number of Employees = {0}", Employee.CountInstances());
//Bonus(null);

//local function (method defined in another method)
//does not support overloading
double Tax(Employee emp)
{
    double i = emp.Income();
    return i > 10000 ? 0.15 * (i - 10000) : 0;
}

double Bonus(Employee emp)
{
    if(emp is SalesPerson)
        return 0;
    return 0.12 * emp.Income();
}
