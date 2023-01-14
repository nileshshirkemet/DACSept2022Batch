package com.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/welcome")
public class WelcomeRESTController {

	/*
	 * @GetMapping public @ResponseBody String welcome() {
	 * 
	 * return "Welcome to Spring REST services";
	 * 
	 * }
	 */
	
	/*
	 * @GetMapping public @ResponseBody ResponseEntity<String> welcome(){ return new
	 * ResponseEntity<String>("Welcome to Spring REST services", HttpStatus.OK); }
	 */
	
	//@RestController -> @Controller + @ResponseBody
	
	@GetMapping
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("Welcome to Spring REST services", HttpStatus.OK);
	}
	
	@GetMapping("withHeaders")
	public ResponseEntity<String> welcomeWIthHeaders(){
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("count", "5");
		
		
		return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
		
	}
	
	//@PutMapping
	
	
	
}




