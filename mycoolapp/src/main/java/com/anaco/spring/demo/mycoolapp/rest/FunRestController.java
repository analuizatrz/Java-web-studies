package com.anaco.spring.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
		
	// expose "/" that return "Hello World"
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		return "Coach "+ coachName + " team: "+ teamName; 
	}
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is " + LocalDateTime.now();
	}
	@GetMapping("/test")
	public String test() {
		return "testingreload ";
	}
	
}