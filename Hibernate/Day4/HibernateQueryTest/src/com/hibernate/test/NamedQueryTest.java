package com.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.met.model.Account;

public class NamedQueryTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	//http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=2963451
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			Query<Account> createNamedQuery = session.createNamedQuery("getAllAccounts", Account.class);
			List<Account> list = createNamedQuery.list();
			
			list.forEach(a -> System.out.println(a));
			
			System.out.println("Named Queries with filter");
			
			Query<Account> createNamedQuery2 = session.createNamedQuery("filterAccounts", Account.class);
			createNamedQuery2.setParameter("nameVal", "Jack");
			List<Account> list1 = createNamedQuery2.list();
			
			list1.forEach(a -> System.out.println(a));
			
		}
		
	}
	
}
