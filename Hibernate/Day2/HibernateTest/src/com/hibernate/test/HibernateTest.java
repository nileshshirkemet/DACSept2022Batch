package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class HibernateTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	/*
	 * { Configuration configuration = new Configuration(); configuration =
	 * configuration.configure(); sessionFactory =
	 * configuration.buildSessionFactory(); }
	 */
			
	//new Configuration().configure("abc.xml").buildSessionFactory();		
	
	private static void saveUsingHibernate(Account account) {
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			//session.persist(account);
			
			Serializable accId = session.save(account);
			
			System.out.println("Acc ID: " + accId);
			
			tx.commit();                  //
			//session.flush();
			
			//tx.commit()   -> session.flush() + commit the tx
			
			
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			
			e.printStackTrace();
		}
		
		System.out.println("HERE!!!");
		
		System.out.println("Account saved successfully using hibernate.........");
		
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		//account.setId(10);
		account.setName("Suresh");
		account.setBalance(950000);
		account.setInterest(1000);

		saveUsingHibernate(account);
		
		sessionFactory.close();
	}
	
}







