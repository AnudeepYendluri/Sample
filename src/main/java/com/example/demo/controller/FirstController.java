package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;


@RestController
public class FirstController {
	
	@Autowired
	private StudentService studentService;
	
	
	
	
	@RequestMapping("/first")
	public String firstApi () {
		return "This is my first api in spring boot";
	}
	
	@RequestMapping("/allstudents")
	public ResponseEntity<List<Student>> getAllStudents() {
		
		ResponseEntity<List<Student>> students = studentService.getAllStudents();
		return students;
	    	}
	
	@RequestMapping("/addstudent")
	public ResponseEntity<String> addingStudent(@RequestBody Student student) {
		
		ResponseEntity<String> result =studentService.addStudent(student);
		return result;
	}

	@RequestMapping("/deletestudent/{id}")
	public ResponseEntity<String> deletingStudentById(@PathVariable Integer id) {
		ResponseEntity<String> result = studentService.removeStudent(id);
		return result;
	}
	
	@RequestMapping("/findStudentById/{id}")
	public Optional<Student> getStudentById(@PathVariable Integer id) {
		
		Optional<Student> student = studentService.getStudentById(id);
		return student;
	}
	
	@RequestMapping("/updateStudentById	/{id}")
	public String updateStudentById(@PathVariable Integer id,@RequestBody Student student1) {
		String result = studentService.updateStudentById(id,student1);
		return result;
	}
}
