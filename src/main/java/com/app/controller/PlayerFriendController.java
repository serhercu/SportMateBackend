package com.app.controller;

import java.util.List;

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

import com.app.dto.player.PlayerFriendDTO;
import com.app.dto.player.PlayerFriendRequestReplyDTO;
import com.app.dto.player.PlayerViewFriendStatusDTO;
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
		
		return new ResponseEntity<>(playerFriendService.status(playerId1, playerId2), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFriendRequestByPlayer")
	public ResponseEntity<List<PlayerViewFriendStatusDTO>> getFriendRequestByPlayer(@RequestParam(required = true) Long playerId, HttpServletRequest request,
			HttpServletResponse response) {
		
		return new ResponseEntity<>(playerFriendService.getFriendRequestByPlayer(playerId), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getFriendsByPlayer")
	public ResponseEntity<List<PlayerViewFriendStatusDTO>> getFriendsByPlayer(@RequestParam(required = true) Long playerId, HttpServletRequest request,
			HttpServletResponse response) {
		
		return new ResponseEntity<>(playerFriendService.getFriendsByPlayer(playerId), HttpStatus.OK);
	}
	
	@PutMapping(value = "/replyFriendRequest")
	public ResponseEntity<?> replyFriendRequest(@RequestBody PlayerFriendRequestReplyDTO reply, HttpServletRequest request,
			HttpServletResponse response) {
		playerFriendService.replyFriendRequest(reply);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
