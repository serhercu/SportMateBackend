package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.dto.SportDTO;
import com.app.repository.SportRepository;
import com.app.service.sport.ISportService;

@CrossOrigin(origins="http://localhost:8080")
@RestController
public class SportController {
	
	@Autowired
	ISportService sportService;
	
	@Autowired
	SportRepository sportRepo;


	@GetMapping(value = "/getAllSports")
	public ResponseEntity<List<SportDTO>> getUserSucursal(UriComponentsBuilder builder, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(sportService.getAllSports(), HttpStatus.OK);
	}
}
