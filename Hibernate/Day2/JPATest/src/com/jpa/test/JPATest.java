package com.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.met.model.Account;

public class JPATest {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpaTest");
	
	private static void saveUsingJPA(Account acc) {
		
		EntityManager entityManager = null;
		EntityTransaction entityTransaction = null;
		
		try {
			
			entityManager = emf.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			
			entityTransaction.begin();
			
			entityManager.persist(acc);
			
			entityTransaction.commit();
			
			
		}finally {
			
			if(entityManager != null) entityManager.close();
			
		}
		
		System.out.println("Account saved successfully");
		
	}
	
	
	public static void main(String[] args) {
		
		Account account = new Account();
		account.setId(3);
		account.setName("Jack");
		account.setBalance(50000);

		saveUsingJPA(account);
		
		
		
	}
	
}
