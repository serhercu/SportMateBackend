package com.app.controller;

import java.util.List;

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

import com.app.dto.GameDTO;
import com.app.service.game.GameService;

@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/game")
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
	
	@GetMapping(value = "/games")
	public ResponseEntity<List<GameDTO>> getAllLevels(@RequestParam(required = false) Integer sportId, @RequestParam(required = false) Integer levelValue,
			@RequestParam(required = false) Long dateStart, @RequestParam(required = false) Long dateEnd, @RequestParam(required = false) Integer locationId,
			UriComponentsBuilder builder, HttpServletRequest request, HttpServletResponse response) {

		return new ResponseEntity<>(gameService.getGames(sportId, levelValue, dateStart, dateEnd, locationId), HttpStatus.OK);
	}

}
