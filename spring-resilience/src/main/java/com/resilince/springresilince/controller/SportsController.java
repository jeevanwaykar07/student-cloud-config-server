package com.resilince.springresilince.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class SportsController {
	
	public static final String USER_SERVICE = "userService";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/getListOfSports")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "Fallback")
	public String createStudent() {

		String response = restTemplate.getForObject("https://localhost:9090/sports", String.class);
		return response;

	}
	
	public String fallback(Exception e) {
		return "service is down come again leter";
	}

		

}
