package com.app.service.game;

import java.util.List;

import com.app.dto.GameDTO;

public interface IGameService {

	GameDTO createGame(GameDTO game);
	
	List<GameDTO> getGames(Integer sportId, Integer levelId, Long dateStart, Long dateEnd, Integer locationId);
}
