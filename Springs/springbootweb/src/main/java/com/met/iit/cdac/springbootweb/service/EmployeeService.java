package com.met.iit.cdac.springbootweb.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.met.iit.cdac.springbootweb.dao.EmployeeDAO;
import com.met.iit.cdac.springbootweb.model.Employee;

//@Component
@Service
public class EmployeeService {

	//private EmployeeDAO employeeDAO = new EmployeeDAO();
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public void save(Employee employee) {
	
		//perform validations
		//if validated successfully call save method
		// if failed throw exception
		
		if(employee.getId() < 0) {
			throw new RuntimeException("EMployee ID cannot be < 1");
		}
		
		System.out.println("EmployeeService :: save");
		employeeDAO.save(employee);
		
		//updateEMployeeCOunt();
		
		System.out.println("Employee DAO class: " + employeeDAO.getClass());
		
	}
	
	/*
	 * @Transactional public void updateEMployeeCOunt() {
	 * 
	 * 
	 * }
	 */
	
	public  Collection<Employee> getAllEmployees(){
		
		return employeeDAO.getAllEmployees();
		
	}
	
	//@Transactional -> if using hibernate 
	
	public Employee getEmployee(int id) {
		return employeeDAO.getEmployee(id);
	}
	
}
