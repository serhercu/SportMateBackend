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

import com.app.dto.LevelDTO;
import com.app.service.level.LevelService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/level")
@RestController
public class LevelController {

	@Autowired
	LevelService levelService;
	
	@GetMapping(value = "/getAllLevels")
	public ResponseEntity<List<LevelDTO>> getAllLevels(UriComponentsBuilder builder, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(levelService.getAllLevels(), HttpStatus.OK);

	}
}
