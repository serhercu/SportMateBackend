package com.app.service.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GameDTO;
import com.app.model.Game;
import com.app.repository.GameRepository;

@Service
public class GameService implements IGameService {
	
	@Autowired
	GameRepository gameRepo;

	@Override
	public GameDTO createGame(GameDTO game) {
		
		Game newGame = new Game();
		newGame.setDescription(game.getDescription());
		newGame.setPlayersRequired(game.getPlayersRequired());
		newGame.setLevel(game.getLevel());
		newGame.setLocation(game.getLocation());
		newGame.setDate(game.getDate());
		newGame.setPrivacy(game.getPrivacy());
		newGame.setChatId(1);
//		newGame.setCenter(game.getCenter());
		newGame.setSport(game.getSport());
		newGame.setProvince(game.getProvince());
		
		gameRepo.save(newGame);
		GameDTO result = Game.createDTO(newGame);
		
		return result;
	}
	
}
