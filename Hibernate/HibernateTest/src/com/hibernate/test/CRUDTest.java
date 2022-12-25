package com.hibernate.test;

import java.io.Serializable;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.Account;

public class CRUDTest {

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
			
			//account  			->   Transient state
			
			
			Serializable accId = session.save(account);
			
			// account          -> Persistent State
			
			System.out.println("Acc ID: " + accId);
			
			tx.commit();                  //
			//session.flush();
			
			//tx.commit()   -> session.flush() + commit the tx
			
			
		}catch (HibernateException e) {
			if(tx != null) tx.rollback();
			
			e.printStackTrace();
		}
		
		//account -> dettached state
		
		System.out.println("HERE!!!");
		
		System.out.println("Account saved successfully using hibernate.........");
		
	}
	
	
	private static void getAccount() {
		
		try(Session session = sessionFactory.openSession()){
			
			Account account = session.get(Account.class, 2);
					//2nd argument to function is primary key column value 
					//Serializable
			
			System.out.println(account);
			
			System.out.println("Object in persistence Context: " + session.contains(account));
			
			
			Account account2 =   session.get(Account.class, 2);
			
			if(account == account2) {
				System.out.println("Accounts are identical");
			}else {
				System.out.println("Accounts are not identical");
			}
			
			
		}
		
	}
	
	
	private static void updateAccount() {							// this is example of
						//update with Persistence state where dirty checking would be 
						//performed and based on update query would be fired.
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account = session.get(Account.class, 3);
			
			account.setActive(true);
			account.setName("Suresh");
			
			
			//session.update(account);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void updateAccountWithDettachedState() {
		
		Transaction tx = null;
		Account account = null;
		
		try(Session session = sessionFactory.openSession()){
		
			account = session.get(Account.class, 2);
			
			//account is in persistent state
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		//account is in -> dettached
		
		account.setName("Suresh");
		account.setActive(false);
		
		System.out.println("Before updating dettached object");

		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			Account account1 = session.get(Account.class, 2);
			
			
			session.update(account);
						//First fire select query and get object with id=2 in PC
						//Copy all data from dettached object to Persistent Object
			
			
			tx.commit();
			
			
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
	}
	
	private static void updateAccountWithTransient() {
		
		Account account = new Account();		 
		account.setName("Jerry");
		account.setBalance(350000);
		account.setInterest(700);
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			//account is transient
			session.update(account);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
	}
	
	//saveOrUpdate
	
	private static void saveOrUpdateAccountWithTransient() {
		
		Account account = new Account();		 
		account.setName("Jerry");
		account.setBalance(350000);
		account.setInterest(700);
		
		Transaction tx = null;
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			//account is transient
			session.saveOrUpdate(account);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		/*
		 * Account account = new Account(); //account.setId(10); account.setName("Tim");
		 * account.setBalance(350000); account.setInterest(700);
		 * //account.setActive(true);
		 * 
		 * saveUsingHibernate(account);
		 */
		
		//getAccount();\
		
		//updateAccount();
		
		//updateAccountWithDettachedState();
		
		//updateAccountWithTransient();
		
		saveOrUpdateAccountWithTransient();
		
		sessionFactory.close();
	}
	
}







