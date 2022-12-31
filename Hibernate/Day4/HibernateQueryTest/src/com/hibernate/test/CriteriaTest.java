package com.hibernate.test;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.met.model.Account;
import com.met.model.Employee;

public class CriteriaTest {

	private static SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		try(Session session = sessionFactory.openSession()){
			
			Criteria createCriteria = session.createCriteria(Account.class);
			List list = createCriteria.list();
			
			list.forEach(a -> System.out.println(a));
			
			
			System.out.println("Ordering records....");
			
			Criteria createCriteria1 = session.createCriteria(Account.class);
			createCriteria1.addOrder(Order.desc("balance"));
			createCriteria1.setMaxResults(2);
			List list2 = createCriteria1.list();
			list2.forEach(a -> System.out.println(a));
			
			
			Criteria createCriteria2 = session.createCriteria(Account.class);
			createCriteria2.add(Restrictions.eq("name", "Jack"));
			Object uniqueResult = createCriteria2.uniqueResult();
			
			System.out.println(uniqueResult);
			
			System.out.println("********************Aggregation function**************");
			
			Criteria createCriteria3 = session.createCriteria(Account.class);
			createCriteria3.setProjection(Projections.sum("balance"));
			Object uniqueResult2 = createCriteria3.uniqueResult();
			
			
			System.out.println(uniqueResult2);
			
			
			System.out.println("JPA Criteria Query");
			
			
			
//			  CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//			  CriteriaQuery<Account> createQuery =
//			  criteriaBuilder.createQuery(Account.class); 
//			  Root<Account> from = createQuery.from(Account.class);
//			  
//			  
//			  CriteriaQuery<Account> accountQuery = createQuery.select(from);
//			  
//			  accountQuery.orderBy(criteriaBuilder.asc(from.get("name")));
//			  
//			  TypedQuery<Account> createQuery2 = session.createQuery(accountQuery);
//			  List<Account> list4 = createQuery2.getResultList();
//			  System.out.println(list4);
			 
			
			System.out.println("printing employee details");
			
//			Criteria createCriteria4 = session.createCriteria(Employee.class);
//			List<Employee> list3 = createCriteria4.list();
//			
//			for(int i = 0; i< list3.size(); i++) {
//				
//				System.out.println("Printing information for employee srno " + i);
//				
//				Employee e = list3.get(i);
//				
//				System.out.println("Employee: " + e);
//				System.out.println("Address: " + e.getListAddress());
//				
//				System.out.println();
//				
//			}
			
			
			Criteria createCriteria4 = session.createCriteria(Employee.class);
			createCriteria4.setFetchMode("listAddress", FetchMode.EAGER);			
			List<Employee> list3 = createCriteria4.list();
			
			for(int i = 0; i< list3.size(); i++) {
				
				System.out.println("Printing information for employee srno " + i);
				
				Employee e = list3.get(i);
				
				System.out.println("Employee: " + e);
				System.out.println("Address: " + e.getListAddress());
				
				System.out.println();
				
			}
			
			
			
			
		}
		
		
		
	}
	
}
