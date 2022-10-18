package hr;

import java.util.*;

public class Department{
	private int no;
	private String name;
	//Department will be having Employees
	private List<Employee> empList = new ArrayList<Employee>();

	public Department(){

	}

    public Department(int no, String name, List<Employee> el){
		this.no = no;
		this.name = name;
		this.empList = el;
	}
	public void addEmp(Employee emp){
		empList.add(emp);
	}
    public void removeEmp(Employee emp){
		empList.remove(emp);
	}

	public void printAllEmployees(){
		for (Employee e : empList)
			 System.out.println(e.toString());
	}
}
