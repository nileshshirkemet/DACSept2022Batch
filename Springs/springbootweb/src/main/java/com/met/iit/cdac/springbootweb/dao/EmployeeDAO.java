package com.met.iit.cdac.springbootweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.met.iit.cdac.springbootweb.model.Employee;

//@Component

@Repository
public class EmployeeDAO {
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void save(Employee employee) {
		
		//saveUsingDataSource(employee);
		
		saveUsingJDBCTemplate(employee);
		
		//saveUsingHibernate(employee);
		
		System.out.println("Saving emp to database: " + employee);
		
	}
	
	public Employee getEmployee(int id) {
		
		return jdbcTemplate.queryForObject("select * from employeetbl where id=?", 
				new Object[] {id}, new BeanPropertyRowMapper<>(Employee.class));
		
		/*
		 * Session session = sessionFactory.getCurrentSession();
		 * session.get(Employee.class, id);
		 */
		
	}
	
	private void saveUsingDataSource(Employee employee) {
		
		try(Connection connection = dataSource.getConnection();
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








