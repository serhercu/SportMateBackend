package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.app.model.auth.register.RegisterRequest;
import com.app.model.player.Player;
import com.app.service.auth.IAuthentication;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	@Autowired
	IAuthentication authService;

	@PostMapping(value = "/registerPlayer")
	public ResponseEntity<Player> registerPlayer(@RequestBody RegisterRequest registerRequest, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(authService.registerPlayer(registerRequest), HttpStatus.OK);
	}
	
	@GetMapping(value = "/checkUsernameEmail")
	public ResponseEntity<Integer> checkUsernameEmail(@RequestParam String username, @RequestParam String email,
			UriComponentsBuilder builder, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(authService.checkUsernameEmail(username, email), HttpStatus.OK);
	}
	
	@GetMapping(value = "/login")
	public ResponseEntity<Player> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) {

		return new ResponseEntity<>(authService.login(username, password), HttpStatus.OK);
	}
}
