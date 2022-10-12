package payroll;

//defining a subclass (SalesPerson) which inherits members
//of its super-class (Employee)
public class SalesPerson extends Employee {

	private double sales;

	public SalesPerson(int h, float r, double s) {
		super(h, r); //calling super-class constructor
		sales = s;
	}

	//sales is a read-only property
	public double getSales() {
		return sales;
	}	

	/*
		overriding method - defining a method in a class whose declaration
		matches with declaration of the original method in the super-class
		while its
		(1) visibility may be higher than the visibility declared for
		    original method
		(2) return type may be a sub-type of return type declared by the
		    original method
		(3) throws clause may specify a subset of checked exceptions
		    declared to be thrown by the original method
	*/
	public double income() {
		double payment = super.income();
		if(sales >= 20000)
			payment += 0.05 * sales;
		return payment;
	}
}

