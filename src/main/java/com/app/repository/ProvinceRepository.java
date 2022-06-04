package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Province;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{

}
