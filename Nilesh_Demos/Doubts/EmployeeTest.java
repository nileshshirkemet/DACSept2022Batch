import hr.*;
class EmployeeTest{
	public static double Tax(Employee e){
		double income = e.income();
		if (income > 50000) 
				return (income - 50000) * 0.20;
		return 0;

	}
 
	public static void main(String[] args)
	{
		Employee e1 = new Employee(200, 200);
		Employee e2 = new Employee(210, 210);
		SalesPerson sp = new SalesPerson(210, 210, 50000);
	    System.out.printf("Employee %d has income %f and Tax is %f%n ", e1.getId(), e1.income(), Tax(e1));
	    System.out.printf("Employee %d has income %f and Tax is %f%n", e2.getId(), e2.income(), Tax(e2));
	    System.out.printf("Sales Employee %d has income %f and Tax is %f%n", sp.getId(), sp.income(), Tax(sp));
	}

}
