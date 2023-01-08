package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.model.Employee;

@Component
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping
	public ModelAndView initializeEmployee() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		Employee defEmp = new Employee();
		
		modelAndView.addObject("emp", defEmp);
		
		modelAndView.setViewName("emp");
		
		return modelAndView;
		
	}
	
	@PostMapping
	public ModelAndView saveEmployee(@ModelAttribute Employee emp) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		System.out.println(emp);
		
		modelAndView.setViewName("emp");
		
		 Employee defEmp = new Employee();
		  
		 //modelAndView.addObject("emp", emp);
		 
		 modelAndView.addObject("emp", defEmp);
		 
		
		return modelAndView;
	}
	
	
}
