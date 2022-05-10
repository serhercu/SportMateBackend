package com.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:8080")
@RestController
public class EmployeeController {
	
//	@Autowired JdbcTemplate jdbcTemplate;
	
	@Autowired EmployeeRepository repo;
	
	@GetMapping("/employees")
	public List<Employee> listAll() {
//		String sql = "SELECT * FROM Employees";
//		return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));
//		
		return repo.findAll();
	}
}
