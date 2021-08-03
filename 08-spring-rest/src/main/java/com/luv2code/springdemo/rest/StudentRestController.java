package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students;
	
	@PostConstruct
	public void loadStudents() {
		students = new ArrayList<>();
		
		students.add(new Student("Poornima", "Patel"));
		students.add(new Student("Mario", "Rossi"));
		students.add(new Student("Mary", "Smith"));	
	}
	// define endpoint for "/students" - return list of students
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	// http://localhost:9548/spring-rest-demo/api/students/0
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		if((studentId >= students.size()) || studentId < 0){
			throw new StudentNotFoundException("Student id not found - "+studentId);
		}
		return students.get(studentId);
	}
	
	// ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleResponse(StudentNotFoundException exception){
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exception.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}	
}