package com.met.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/hello")

//<bean id="helloController" class="com.met.controller.HelloController" />
public class HelloController {

	//http://localhost:8080/SpringMVCTest/mvc/hello	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView hello() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//setting model data
		modelAndView.addObject("welMsg", "Welcome to Spring MVC");			//request.setAttribute();
		modelAndView.addObject("balance", 50000);
		
		//setting view english name
		modelAndView.setViewName("welcome");
		
		
		return modelAndView;
	}
	
	//http://localhost:8080/SpringMVCTest/mvc/hello/reqParam?name=John&age=24
	//http://localhost:8080/SpringMVCTest/mvc/hello/reqParam?userName=John&age=24
	
	//http://localhost:8080/SpringMVCTest/mvc/hello/reqParam?age=24
	
	//@RequestMapping(value = "reqParam", method =  RequestMethod.GET)
	@GetMapping("reqParam")
	public ModelAndView reqParameters(@RequestParam(required = false, name = "userName") String name, @RequestParam(defaultValue = "24") int age) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//setting model data
		modelAndView.addObject("welMsg", "Welcome to Spring MVC user " + name + " and age: " + age);			//request.setAttribute();
		modelAndView.addObject("balance", 50000);
		
		//setting view english name
		modelAndView.setViewName("welcome");
		
		
		return modelAndView;
		
	}
	
	//http://localhost:8080/SpringMVCTest/mvc/hello/pathVar/John/24
	
	@GetMapping("pathVar/{name}/{age}")
	public ModelAndView pathVariables(@PathVariable String name, @PathVariable int age) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		//setting model data
		modelAndView.addObject("welMsg", "Welcome to Spring MVC user " + name + " and age: " + age);			//request.setAttribute();
		modelAndView.addObject("balance", 50000);
		
		//setting view english name
		modelAndView.setViewName("welcome");
		
		
		return modelAndView;
		
		
		
		
		
	}
	
	
	
	
	
	
	
}
