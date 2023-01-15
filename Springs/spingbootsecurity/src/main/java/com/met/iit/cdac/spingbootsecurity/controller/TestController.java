package com.met.iit.cdac.spingbootsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("hello")
	public String hello() {
		
		return "Welcome to Spring Boot Security";
		
	}
	
	@GetMapping("user")
	public String helloUser() {
		
		return "Welcome to Spring Boot Security User";
		
	}
	
	@GetMapping("admin")
	public String helloAdmin() {
		
		return "Welcome to Spring Boot Security Admin";
		
	}
}
