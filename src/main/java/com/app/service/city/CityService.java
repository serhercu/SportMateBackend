package com.app.service.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.City;
import com.app.repository.CityRepository;

@Service
public class CityService implements ICityService {
	
	@Autowired
	CityRepository cityRepo;
	
	@Override
	public List<City> getAll() {
		return cityRepo.findAll();
	}

}
