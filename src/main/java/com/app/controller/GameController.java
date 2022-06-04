package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.GameDTO;
import com.app.service.game.GameService;

@CrossOrigin(origins="http://localhost:8080")
@RestController
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@PostMapping(value = "/createGame")
	public ResponseEntity<GameDTO> createGame(@RequestBody GameDTO game, HttpServletRequest request,
			HttpServletResponse response) {
		
		gameService.createGame(game);
		
		return new ResponseEntity<>(game, HttpStatus.CREATED);
	}

}
