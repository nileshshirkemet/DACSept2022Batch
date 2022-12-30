package com.hibernate.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.met.model.Account;

public class HQLTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			Query<Account> createQuery = session.createQuery("from com.met.model.Account order by balance desc", Account.class);
			List<Account> list = createQuery.list();
			
			//list.forEach(a -> System.out.println(a));
			
			for(Account acc : list) {
				System.out.println(acc);
			}
			
			
			System.out.println("Limiting records to 2 rows");
			
			Query<Account> createQuery2 = session.createQuery("from com.met.model.Account order by balance desc", Account.class);
			createQuery2 = createQuery2.setMaxResults(2);
			List<Account> list2 = createQuery2.list();
			
			list2.forEach(a -> System.out.println(a));
			
			System.out.println("Query parameters");
			
			Query<Account> createQuery3 = session.createQuery("from com.met.model.Account where name=:nameVal", Account.class);
			
			createQuery3.setParameter("nameVal", "Jack");
			Account singleResult = createQuery3.getSingleResult();
				
			
			System.out.println(singleResult);
			
			
			System.out.println("selective select query");
			Query<Object[]> createQuery4 = session.createQuery("select name, balance from com.met.model.Account ", Object[].class);
			List<Object[]> list3 = createQuery4.list();
			
			list3.forEach(a -> System.out.println(a [0] + ", " + a[1]));
			
			
			
			System.out.println("Aggregation query");
			Query<Double> createQuery5 = session.createQuery("select sum(balance) from com.met.model.Account ", Double.class);
			Double singleResult2 = createQuery5.getSingleResult();
			
			System.out.println(singleResult2);
				
			
			
			
			
			
			
			
		}
		
	}
	
}
