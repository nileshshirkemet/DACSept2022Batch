package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class JPACRUDTest {

	private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

	private static void persistUsingJPA(Account account) {
		Transaction tx = null;

		try (Session session = sessionFactory.openSession()) {

			tx = session.beginTransaction();

			session.persist(account);

			tx.commit(); //

		} catch (HibernateException e) {

			e.printStackTrace();
		}

		// account -> dettached state

		System.out.println("HERE!!!");

		System.out.println("Account saved successfully using hibernate.........");

	}

	private static void mergeAccountWithDettachedState() {
		
		Transaction tx = null;
		Account account = null;
		
		try(Session session = sessionFactory.openSession()){
		
			account = session.get(Account.class, 1);
			
			//account is in persistent state
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//account is in -> dettached
		
		account.setBalance(521214);
		account.setActive(true);
		
		System.out.println("Before merging dettached object");

		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account1 = session.get(Account.class, 1);
			
			
			session.merge(account);
					
			
			tx.commit();
			
			
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	
	private static void mergeAccountWithTransient() {
		
		Account account = new Account();		 
		account.setName("Ram");
		account.setBalance(350000);
		account.setInterest(700);
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			//account is transient
			session.merge(account);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private static void removeAccount() {
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, 4);
			
			session.remove(account);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {

		
		  Account account = new Account();  
		  account.setName("Jill");
		  account.setBalance(350000); 
		  
		  account.setActive(true);
		  
		  //persistUsingJPA(account);
		  
		  //mergeAccountWithDettachedState();
		  
		  //removeAccount();
		  
		  mergeAccountWithTransient();

	}

}
