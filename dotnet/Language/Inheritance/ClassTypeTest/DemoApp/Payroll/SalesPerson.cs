namespace Payroll
{
    //defining SalesPerson as a derived class of Employee (base class)
    class SalesPerson : Employee
    {
        //automatic property
        public double Sales { get; set; }

        public SalesPerson(int h, float r, double s) : base(h, r)
        {
            Sales = s;
        }

        //method overriding - defining an instance method in a class whose
        //declaration matches with the declaration of the original overridable
        //method in its base class while allowing it to return a type which
        //is derived from the return type of the original method.
        public override double Income()
        {
            double income = base.Income();
            if(Sales >= 10000)
                income += 0.05 * Sales;
            return income;
        }
    }
}