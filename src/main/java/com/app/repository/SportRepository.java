package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Sport;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface SportRepository extends JpaRepository<Sport, Integer>{
	
	List<Sport> findAll();

}
