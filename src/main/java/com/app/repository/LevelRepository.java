package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Level;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface LevelRepository extends JpaRepository<Level, Integer>{	

}
