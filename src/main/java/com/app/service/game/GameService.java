package com.app.service.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
		newGame.setSport(game.getSport());
		newGame.setProvince(game.getProvince());
		newGame.setCity(game.getCity());
		
		gameRepo.save(newGame);
		return Game.createDTO(newGame);
	}
	
	@Override
	public List<GameDTO> getGames(Integer sportId, Integer levelId, Long dateStart, Long dateEnd, Integer locationId) {
		List<GameDTO> resultList = new ArrayList<>();
		Date startDate =  dateStart != null ? new Date(dateStart) : null;
		Date endDate =  dateEnd != null ? new Date(dateStart) : null;
		
		List<Game> gameList = gameRepo.findGamesBySportIdAndLevelAndCityAndDateRange(sportId, levelId, locationId, startDate, endDate);
		
		for (Game game : gameList) {
			resultList.add(Game.createDTO(game));
		}
		return resultList;
	}
	
}
