package com.met.iit.cdac.springbootweb.contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeRESTController {

	@GetMapping
	public String welcome() {
		
		return "Welcome to Spring Boot REST Services!";
		
	}
}
