package com.met.iit.cdac.springbootweb.contoller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.met.iit.cdac.springbootweb.model.Employee;
import com.met.iit.cdac.springbootweb.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeRESTController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value = "allEmps", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Employee>> getAllEmps(){
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		
		return new ResponseEntity<Collection<Employee>>(allEmployees, HttpStatus.OK);
		
		
	}
	
	//http://localhost:8080/SpringRESTTest/rest/emp/getEmp/1.xml
	//http://localhost:8080/SpringRESTTest/rest/emp/getEmp/1.json
	
	@RequestMapping(value = "getEmp/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> getEmp(@PathVariable int id){
		
		Employee employee = employeeService.getEmployee(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
	@PutMapping(value = "updateEmp", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee){
		
		return null;
	}
	
	@DeleteMapping(value = "deleteEmp/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Employee> deleteEmp(@PathVariable int id){
		
		
		return null;
		
	}
	
	
	@PostMapping
	@RequestMapping(value = "saveEmployee", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee){
		
		employeeService.save(employee);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
		
	}
	
	
}



