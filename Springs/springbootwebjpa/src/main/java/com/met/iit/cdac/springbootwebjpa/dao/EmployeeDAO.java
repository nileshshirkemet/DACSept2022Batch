package com.met.iit.cdac.springbootwebjpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.springbootwebjpa.model.Employee;

//@Component

@Repository
public class EmployeeDAO {
	
	/*
	 * @Autowired private SessionFactory sessionFactory;
	 */
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Employee employee) {
		
		entityManager.persist(employee);
		
	}
	
	public Employee getEmployee(int id) {
		
		return entityManager.find(Employee.class, id);
				
	}

	public  Collection<Employee> getAllEmployees(){
		
		return entityManager.createQuery
				("from com.met.iit.cdac.springbootwebjpa.model.Employee", Employee.class).getResultList();
		
	}
	
	
		
}








