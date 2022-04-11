package com.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Dto.StudentDto;
import com.model.StudentEntity;
import com.serviceImpl.StudnentServiceImpl;


@RestController
public class StudentController {
	
	@Autowired
	StudnentServiceImpl studentServiceImpl;
	
	@PostMapping("/student")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentDto dto){
		try {
			StudentEntity s =this.studentServiceImpl.save(dto);
			return ResponseEntity.of(Optional.of(s));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
	
	@GetMapping("/student{Id}")
	public ResponseEntity<StudentEntity> getStudent(@RequestParam Long id){
		try {
			StudentEntity s =this.studentServiceImpl.getbyId(id);
			return ResponseEntity.of(Optional.of(s));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
	@SuppressWarnings("unchecked")
	@GetMapping("/studentAll")
	public List<ResponseEntity<StudentEntity>> getStudentList(@RequestBody StudentEntity student){
		try {
			List<StudentEntity> s =this.studentServiceImpl.getAllStudent(student);
			return (List<ResponseEntity<StudentEntity>>) ResponseEntity.of(Optional.of(s));
		} catch (Exception e) {
			e.printStackTrace();
			return  (List<ResponseEntity<StudentEntity>>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
	}
	
}
