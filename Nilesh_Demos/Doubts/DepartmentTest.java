import java.util.*;
import hr.*;

class DepartmentTest{
	public static void main(String[] args){
		List<Employee> le = new ArrayList<>();
		le.add(new Employee(200, 200));
		le.add(new Employee(210, 210));
		le.add(new Employee(245, 220));
		le.add(new Employee(220, 230));
		le.add(new Employee(200, 250));
        Department ds = new Department(10, "Account", le);
		ds.printAllEmployees();

	}




}
