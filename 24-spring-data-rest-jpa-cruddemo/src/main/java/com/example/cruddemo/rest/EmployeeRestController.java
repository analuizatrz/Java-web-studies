package com.example.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cruddemo.entity.Employee;
import com.example.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}

	@GetMapping("/employees/{id}")
	public Employee getEmployees(@PathVariable int id){
		var employee = employeeService.findById(id);
		
		if(employee == null) {
			throw new RuntimeException("as Employee id not found " + id);
		}
		return employee;
	}
	

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee){
		employee.setId(0);
		employeeService.save(employee);
		return employee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){
		employeeService.save(employee);
		return employee;
	}
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable int id){
		Employee tempEmployee = employeeService.findById(id);
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found " + id);
		}
		employeeService.deleteById(id);
		return "Deleted employee "+id;
	}
}
