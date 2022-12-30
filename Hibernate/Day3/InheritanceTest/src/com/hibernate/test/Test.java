package com.hibernate.test;

import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.met.model.CardPayment;
import com.met.model.ChequePayment;
import com.met.model.Payment;

public class Test {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		Payment payment = new Payment();
		payment.setAmount(5000);
		payment.setTransDate(new Date(System.currentTimeMillis()));
		
		ChequePayment chequePayment = new ChequePayment();
		chequePayment.setAmount(10000);
		chequePayment.setTransDate(new Date(System.currentTimeMillis()));
		chequePayment.setChequeNo("1234****");
		chequePayment.setBankName("ICICI");
		
		
		CardPayment cardPayment = new CardPayment();
		cardPayment.setAmount(15000);
		cardPayment.setTransDate(new Date(System.currentTimeMillis()));
		cardPayment.setAgencyType("VISA");
		cardPayment.setCardNo("********1234");
		
		
		try(Session session = sessionFactory.openSession()){
			
			tx = session.beginTransaction();
			
			session.save(payment);
			session.save(chequePayment);
			session.save(cardPayment);
			
			tx.commit();
			
		}catch (HibernateException e) {
			e.printStackTrace();
		}
		
	}
	
}
