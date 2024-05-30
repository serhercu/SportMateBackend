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

import com.app.dto.player.PlayerViewDTO;
import com.app.service.player.IPlayerViewService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/player")
@RestController
public class PlayerController {
	
	@Autowired
	private IPlayerViewService playerService;
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<PlayerViewDTO>> getPlayerBySearch(@RequestParam(required = true) String search,
			@RequestParam(required = true) Long playerId,
			UriComponentsBuilder builder, HttpServletRequest request, HttpServletResponse response) {

		return new ResponseEntity<>(playerService.getPlayerBySearch(search, playerId), HttpStatus.OK);
	}

}
