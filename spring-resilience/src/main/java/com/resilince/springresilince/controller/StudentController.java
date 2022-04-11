package com.resilince.springresilince.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

public class StudentController {

	public static final String USER_SERVICE = "userService";

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/save")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "studentFallback")
	public String createStudent() {

		String response = restTemplate.getForObject("https://localhost:8888/student", String.class);
		return response;

	}

	@PostMapping("/get")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "studentFallback")
	public String getStudent() {

		String response = restTemplate.getForObject("https://localhost:8888/student{Id}", String.class);
		return response;
	}

	@PostMapping("/getList")
	@CircuitBreaker(name = USER_SERVICE, fallbackMethod = "studentFallback")
	public String getStudentList() {

		String response = restTemplate.getForObject("https://localhost:8888/studentAll", String.class);
		return response;

	}

	public String studentfallback(Exception e) {
		return "service is down come again leter";
	}

}
