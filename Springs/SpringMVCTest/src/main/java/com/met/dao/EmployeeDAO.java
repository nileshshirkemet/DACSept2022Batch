package com.met.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.met.model.Employee;

//@Component

@Repository
public class EmployeeDAO {
	
	@Autowired
	@Qualifier("oracleDataSource")
	private DataSource oracleDataSource;
	
	@Autowired
	@Qualifier("mySQLDataSource")
	private DataSource mySQLDataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	public void save(Employee employee) {
		
		//saveUsingDataSource(employee);
		
		//saveUsingJDBCTemplate(employee);
		
		//saveUsingHibernate(employee);
		Session session = sessionFactory.getCurrentSession();
		session.save(employee);
		
		System.out.println("Saving emp to database: " + employee);
		
	}
	
	private void saveUsingHibernate(Employee employee) {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			
			session.save(employee);
			
			tx.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
			if(tx  != null) tx.rollback();
		}finally {
			if(session != null) session.close();
		}
		
	}
	
	private void saveUsingDataSource(Employee employee) {
		
		try(Connection connection = oracleDataSource.getConnection();
			PreparedStatement pstmt = connection.prepareStatement("insert into "
					+ " Employeetbl values(?, ?, ?, ?)");
				){
			
			pstmt.setInt(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setString(3, employee.getDesignation());
			pstmt.setString(4, employee.getEmailId());
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void saveUsingJDBCTemplate(Employee employee) {
		
		jdbcTemplate.update("insert into Employeetbl values(?, ?, ?, ?)", 
					new Object[] {employee.getId(), employee.getName(), employee.getDesignation(),
							employee.getEmailId()}
				);
		
	}

	public  Collection<Employee> getAllEmployees(){
		
		
		return jdbcTemplate.query("select * from employeetbl", 
				
					new BeanPropertyRowMapper<Employee>(Employee.class)
					//new EmployeeMapper()
				
				);
		
		
	}
	
	
	class EmployeeMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub
			
			Employee employee = new Employee();
			employee.setId(rs.getInt("id"));
			employee.setName(rs.getString("name"));
			employee.setDesignation(rs.getString("designation"));
			employee.setEmailId(rs.getString("emailId"));
			
			return employee;
		}
	}
	
}








