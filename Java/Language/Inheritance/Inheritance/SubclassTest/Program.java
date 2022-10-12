//importing Employee name from payroll package so compiler can
//expand that name to payroll.Employee
import payroll.Employee;

class Program {

	private static double tax(Employee emp) {
		double i = emp.income();
		return i > 10000 ? 0.15 * (i - 10000) : 0;
	}

	private static double bonus(Employee emp) {
		//instanceof operator yields true only if the type of object on left
		//matches with or supports implicit conversion to type on right
		if(emp instanceof payroll.SalesPerson)
			return 0;
		return 0.1 * emp.income();
	}
	
	public static void main(String[] args) {
		Employee jack = new Employee();
		jack.setHours(186);
		jack.setRate(52);
		//type inference for a local variable from its initializer
		var jill = new payroll.SalesPerson(186, 52, 64000);
		System.out.printf("Jack's Income is %.2f, Tax is %.2f and Bonus is %.2f%n", jack.income(), tax(jack), bonus(jack));
		System.out.printf("Jill's Income is %.2f, Tax is %.2f and Bonus is %.2f%n", jill.income(), tax(jill), bonus(jill));
		System.out.printf("Number of Employees = %d%n", Employee.countInstances());
	}
}

