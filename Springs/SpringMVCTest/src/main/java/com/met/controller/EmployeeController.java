package com.met.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;
import com.met.service.EmployeeService;

//@Component
@Controller
@RequestMapping("/employee")
public class EmployeeController {

	//private EmployeeService employeeService = new EmployeeService();
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public ModelAndView initializeEmployee() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Employee defEmp = new Employee();
		
		modelAndView.addObject("emp", defEmp);
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		modelAndView.addObject("listEmp", allEmployees);
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
		
	}
	
	@PostMapping
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(emp);
		
		employeeService.save(emp);
		
		Collection<Employee> allEmployees = employeeService.getAllEmployees();
		modelAndView.addObject("listEmp", allEmployees);
		
		
		modelAndView.setViewName("emp");							//redirect:/emp
		
		 Employee defEmp = new Employee();
		  
		 //modelAndView.addObject("emp", emp);
		 
		 modelAndView.addObject("emp", defEmp);
		 
		
		return modelAndView;
	}
	
	
	@ExceptionHandler
	public ModelAndView handleException(Exception e, HttpServletRequest request) {
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("error");
		mv.addObject("exMsg", e.getMessage());
		
		mv.addObject("url", request.getRequestURI());
		
		return mv;
		
	}
	
	
}







