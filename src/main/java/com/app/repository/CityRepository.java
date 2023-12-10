package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
