package com.met.model;

public class Employee {

	private static int counter;
	
	private int id;
	private String name;
	private int age;
	private String designation;
	private double salary;
	
	private Address address;
	
	
	public Employee() {
		
		id = ++counter;
		System.out.println("Default Employee Object created with Id: " + id);
	}
	
	public Employee(String name, int age) {
		this();
		this.name = name;
		this.age = age;
		this.designation = "FRESHER";
		this.salary = 50000;
		
		System.out.println("Parameterized Employee Object created with Id: " + id);
	}
	
	public Employee(String name, int age, String designation, double salary, Address address) {
		this();
		this.name = name;
		this.age = age;
		this.designation = designation;
		this.salary = salary;
		this.address = address;
		System.out.println("Parameterized Employee Object created with Id: " + id);
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", designation=" + designation + ", salary="
				+ salary + ", address=" + address + "]";
	}

	public double calculateAnnualIncome() {
		
		return 12 * salary;
		
	}
	
}
