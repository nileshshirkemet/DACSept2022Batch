package com.hibernate.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Address;
import com.met.model.Employee;

public class ManyToOneUniTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		/*
		 * Transaction tx = null;
		 * 
		 * Employee employee = new Employee(); employee.setName("ramesh");
		 * employee.setEmailId("ramesh@met.edu");
		 * 
		 * Address address = new Address(); address.setCity("Jaipur");
		 * address.setCountry("India");
		 * 
		 * Address address2 = new Address(); address2.setCity("Ooty");
		 * address2.setCountry("India");
		 * 
		 * 
		 * address.setEmployee(employee); address2.setEmployee(employee);
		 * 
		 * 
		 * try(Session session = sessionFactory.openSession()){
		 * 
		 * tx = session.beginTransaction();
		 * 
		 * session.save(address); session.save(address2);
		 * 
		 * tx.commit();
		 * 
		 * }catch (HibernateException e) { e.printStackTrace();
		 * 
		 * if(tx!=null) tx.rollback(); }
		 */
		
		
		// code to add new address to exiting employees in db
		
		Address address = new Address(); 
		address.setCity("NewYork");
		address.setCountry("USA");
		
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			  
			 tx = session.beginTransaction();
			 
			 //Employee employee = session.get(Employee.class, 2);
			 
			 Employee employee = session.load(Employee.class, 2);
			 
			 address.setEmployee(employee);
			 
			 session.save(address);
			 
			 tx.commit();
			 
		}catch (HibernateException e) { e.printStackTrace();
		 
		  if(tx!=null) tx.rollback(); 
		  
		}
	
		
		
		
		
	}
	
}
