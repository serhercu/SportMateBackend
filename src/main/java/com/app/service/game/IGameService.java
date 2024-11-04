package com.app.service.game;

import java.util.List;

import com.app.dto.GameDTO;
import com.app.dto.GamePlayerDTO;

public interface IGameService {
	
	GameDTO getGame(Integer idGame);

	GameDTO createGame(GameDTO game);
	
	List<GameDTO> getGames(Integer sportId, Integer levelId, Long dateStart, Long dateEnd, Integer locationId);
	
	List<GameDTO> getFinishedGames(Long playerId);

	GameDTO joinGame(GamePlayerDTO gamePlayer);
	
	GameDTO leaveGame(GamePlayerDTO gamePlayer);
	
	GameDTO cancelGame(GamePlayerDTO gamePlayer);
	
	List<GameDTO> getGamesByPlayer(Long playerId);
}
