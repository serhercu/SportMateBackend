package com.app;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	
}
