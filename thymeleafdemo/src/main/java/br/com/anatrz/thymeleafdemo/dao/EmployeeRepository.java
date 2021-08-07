package br.com.anatrz.thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anatrz.thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// that's it ... no need to write any code LOL!
	
}
