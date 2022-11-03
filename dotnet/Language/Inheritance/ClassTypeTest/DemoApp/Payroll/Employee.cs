namespace Payroll
{
    class Employee
    {
        private int hours;
        private float rate;
        private static int count;

        //parameterized constructor
        public Employee(int h, float r)
        {
            hours = h;
            rate = r;
            ++count;
        }

        //parameter-less constructor
        public Employee() : this(0, 40)
        {
        }

        //property - accessor methods which can be called
        //using field-access syntax
        public int Hours
        {
            get
            {
                return hours;
            }

            set
            {
                hours = value;
            }
        }

        public float Rate
        {
            get { return rate; }
            set { rate = value; }
        }

        //overridable method
        public virtual double Income()
        {
            double income = hours * rate;
            int ot = hours - 180;
            if(ot > 0)
                income += 50 * ot;
            return income;
        }

        public static int CountInstances()
        {
            return count;
        }
    }
}
