package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		
		ApplicationContext context  = new ClassPathXmlApplicationContext("test.xml");
		
		
		/*
		 * Employee emp1 = context.getBean(Employee.class); System.out.println(emp1);
		 * 
		 * Object emp1NonGeneric = context.getBean("emp1");
		 * System.out.println(emp1NonGeneric);
		 */
		
		
		System.out.println("*******************Initialization***************************");
		
		Employee emp1Generic = context.getBean("emp1", Employee.class);
		System.out.println(emp1Generic);
		System.out.println("Annual Income: " + emp1Generic.calculateAnnualIncome());
		
		Employee emp2 = context.getBean("emp2", Employee.class);
		System.out.println(emp2);
		
		Employee emp2Singleton = context.getBean("emp2", Employee.class);
		System.out.println(emp2Singleton);
		
		System.out.println("*******************Prototype***************************");
		
		System.out.println();
		
		Employee emp3 = context.getBean("emp3", Employee.class);
		System.out.println(emp3);
		
		Employee emp3Prototype = context.getBean("emp3", Employee.class);
		System.out.println(emp3Prototype);
		
		
		System.out.println("*******************Constructor-args***************************");
		
		System.out.println();
		Employee emp4 = context.getBean("emp4", Employee.class);
		System.out.println(emp4);
		System.out.println(emp4.calculateAnnualIncome());
		
		
		Employee emp5 = context.getBean("emp5", Employee.class);
		System.out.println(emp5);
		System.out.println(emp5.calculateAnnualIncome());
	
		System.out.println("*******************Property-Setters***************************");
		
		Employee emp6 = context.getBean("emp6", Employee.class);
		System.out.println(emp6);
		System.out.println(emp6.calculateAnnualIncome());
		
		
		Employee emp7 = context.getBean("emp7", Employee.class);
		System.out.println(emp7);
		System.out.println(emp7.calculateAnnualIncome());
		
		
		System.out.println("*******************Lazy initialization***************************");
		
		Employee emp8 = context.getBean("emp8", Employee.class);
		System.out.println(emp8);
		System.out.println(emp8.calculateAnnualIncome());
		
		Employee emp8Singleton = context.getBean("emp8", Employee.class);
		System.out.println(emp8Singleton);
		System.out.println(emp8Singleton.calculateAnnualIncome());
		
		
		
		Employee emp9 = context.getBean("emp9", Employee.class);
		System.out.println(emp9);
		System.out.println(emp9.calculateAnnualIncome());
		
		
	}
	
}



