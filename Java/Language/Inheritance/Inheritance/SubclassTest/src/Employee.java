package payroll; //any type define in this source file belongs to payroll package

public class Employee {

	private int hours;
	private float rate;
	private static int count; //value is shared by all instances

	public Employee(int h, float r) {
		hours = h;
		rate = r;
		++count;
	}

	public Employee() {
		this(180, 40); //calling above constructor
	}


	//accessor methods to support hours as a property
	public int getHours() {
		return hours;
	}

	public void setHours(int value) {
		hours = value;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float value) {
		rate = value;
	}

	//an instance method is overridable by default and its call is
	//indirected (dynamic binding) to the class assigned to the
	//target instance at the time of its construction by new operator
	public double income() {
		double payment = hours * rate;
		int ot = hours - 180;
		if(ot > 0)
			payment += 50 * ot;
		return payment;
	}

	public static int countInstances() {
		return count;
	}
}

