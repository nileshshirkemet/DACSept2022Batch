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

public class OneToManyUniTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		Employee employee = new Employee();
		employee.setName("Rakesh");
		employee.setEmailId("rakesh@met.edu");
		
		Address address = new Address();
		address.setCity("Pune");
		address.setCountry("India");
		
		Address address2 = new Address();
		address2.setCity("Paris");
		address2.setCountry("France");
		
		List<Address> listAddresses = new ArrayList<>();
		listAddresses.add(address);
		listAddresses.add(address2);
		
		
		employee.setListAddress(listAddresses);
		
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
			
			if(tx!=null) tx.rollback();
		}
		
	}
	
}
