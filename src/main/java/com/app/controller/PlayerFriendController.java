package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PlayerFriendDTO;
import com.app.service.friend.IPlayerFriendService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/friend")
@RestController
public class PlayerFriendController {
	
	@Autowired
	IPlayerFriendService playerFriendService;
	
	@PutMapping(value = "/request")
	public ResponseEntity<PlayerFriendDTO> request(@RequestBody PlayerFriendDTO friendRequest, HttpServletRequest request,
			HttpServletResponse response) {
		
		return new ResponseEntity<>(playerFriendService.request(friendRequest), HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/status")
	public ResponseEntity<String> status(@RequestParam(required = true) Long playerId1, 
			@RequestParam(required = true) Long playerId2, HttpServletRequest request,
			HttpServletResponse response) {
		
		return new ResponseEntity<>(playerFriendService.status(playerId1, playerId2), HttpStatus.CREATED);
	}

}
