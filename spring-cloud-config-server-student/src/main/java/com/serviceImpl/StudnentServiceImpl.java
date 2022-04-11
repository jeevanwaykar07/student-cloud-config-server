package com.serviceImpl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dto.StudentDto;
import com.model.StudentEntity;
import com.repository.StudentRepository;
@Service
public class StudnentServiceImpl {
	@Autowired
	StudentRepository repository;
	static Predicate<StudentEntity> predicateByGpa = (stu) -> Double.parseDouble(stu.getGpa())>=3.5;

	public StudentEntity save(StudentDto dto) {
		StudentEntity stud = new StudentEntity();
		stud.setGender(dto.getGender());
		return repository.save(stud);
	}

	public StudentEntity getbyId(Long id) {
		
		return repository.getById(id);
	}

	public List<StudentEntity> getAllStudent(StudentEntity student) {
		// TODO Auto-generated method stub
		return  repository.findAll().stream().filter(predicateByGpa).collect(Collectors.toList());
	}

}
