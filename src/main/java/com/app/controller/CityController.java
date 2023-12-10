package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.City;
import com.app.service.city.ICityService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/city")
@RestController
public class CityController {

	@Autowired
	ICityService cityService;
	
	@GetMapping(value = "/cities")
	public ResponseEntity<List<City>> getAllCities(UriComponentsBuilder builder, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(cityService.getAll(), HttpStatus.OK);
	}
}
