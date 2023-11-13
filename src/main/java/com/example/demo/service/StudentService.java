package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;


@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> allStudents = studentRepo.findAll();
		return ResponseEntity.ok(allStudents);

	}
	
	public ResponseEntity<String> addStudent(Student student) {
		Student student1 = studentRepo.save(student);
		if(student1 != null) {
			return ResponseEntity.ok("student added succesfully");
		}
		return ResponseEntity.ok("Something went wrong");
	}
	
	public ResponseEntity<String> removeStudent(int id) {
		 studentRepo.deleteById(id);
		 return ResponseEntity.status(HttpStatus.OK).body("Deleted succesfully");
	}
	
	public Optional<Student> getStudentById(int id) {
		Optional<Student> student =studentRepo.findById(id);
		return student;
	}
	
	public String updateStudentById(int id,Student student) {
		
		student.setId(id);
		Student student1 = studentRepo.save(student);
		if(student1 != null) {
			return "student updated succesfully";
		}
		return "something went wrong";
		
		
	}
}
