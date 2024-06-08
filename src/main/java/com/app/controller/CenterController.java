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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.Center;
import com.app.service.center.ICenterService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/center")
@RestController
public class CenterController {
	
	@Autowired
	private ICenterService centerService;
	
	@GetMapping(value = "/centers")
	public ResponseEntity<List<Center>> getAllLevels(@RequestParam(required = false) String centerName, 
	        @RequestParam(required = false) Integer cityId, @RequestParam(required = false) List<Integer> listSports,
	        UriComponentsBuilder builder, HttpServletRequest request, HttpServletResponse response) {

	    return new ResponseEntity<>(centerService.getCenters(centerName, cityId, listSports), HttpStatus.OK);
	}

}
