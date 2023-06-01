package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8080")
@RestController
public class EmployeeController {
	
	@Autowired EmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee> listAll() {
		return repo.findAll();
	}
}
