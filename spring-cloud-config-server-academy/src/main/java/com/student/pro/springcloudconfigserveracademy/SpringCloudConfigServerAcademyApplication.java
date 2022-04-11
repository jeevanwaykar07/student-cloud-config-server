package com.student.pro.springcloudconfigserveracademy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringCloudConfigServerAcademyApplication {
	
	@Autowired
	public RestTemplate template; 
	
	@Value("${spring-config-cloud-server.ur}")
	public List<String> getSports(){
		@SuppressWarnings("unchecked")
		List<String> sports = template.getForObject("url",List.class);
		return sports;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerAcademyApplication.class, args);
	}
	
	public RestTemplate template() {
		return new RestTemplate();
	}
	
}
