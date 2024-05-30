package com.app.service.game;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.GameDTO;
import com.app.dto.GamePlayerDTO;
import com.app.model.Game;
import com.app.model.player.Player;
import com.app.repository.GameRepository;
import com.app.repository.player.PlayerRepository;
import com.app.util.ErrorCodes;
import com.app.util.InternalException;

@Service
public class GameService implements IGameService {
	
	@Autowired
	GameRepository gameRepo;
	
	@Autowired
	PlayerRepository playerRepo;

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
		newGame.setTime(game.getTime());
		newGame.setPlayerCreatorId(game.getPlayerCreatorId());
		newGame.setPlayers(new HashSet<>());
		newGame.setStatus(Game.STATUS_OPEN);
		
		Optional<Player> playerCreator = playerRepo.findById(newGame.getPlayerCreatorId());
		if (playerCreator.isPresent()) {
			newGame.getPlayers().add(playerCreator.get());
		}
		
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

	@Override
	public GameDTO getGame(Integer idGame) {
		Game gameRes = gameRepo.getById(idGame);
		return gameRes != null ? Game.createDTO(gameRes) : null;
	}

	@Override
	public GameDTO joinGame(GamePlayerDTO gamePlayer) {
		Optional<Player> optPlayer = playerRepo.findById(gamePlayer.getPlayerId());
		Optional<Game> optGame = gameRepo.findById(gamePlayer.getGameId());
		
		if (optPlayer.isPresent() && optGame.isPresent()) {
			Game game = optGame.get();
			game.getPlayers().add(optPlayer.get());
			gameRepo.save(game);
			return Game.createDTO(game);
		} else {
			throw new InternalException(ErrorCodes.JOIN_PLAYER_ERROR, "El usuario o el partido no existe"); 
		}
	}
	
	@Override
	public GameDTO leaveGame(GamePlayerDTO gamePlayer) {
		Optional<Player> optPlayer = playerRepo.findById(gamePlayer.getPlayerId());
		Optional<Game> optGame = gameRepo.findById(gamePlayer.getGameId());
		
		if (optPlayer.isPresent() && optGame.isPresent()) {
			Game game = optGame.get();
			game.getPlayers().remove(optPlayer.get());
			gameRepo.save(game);
			return Game.createDTO(game);
		} else {
			throw new InternalException(ErrorCodes.JOIN_PLAYER_ERROR, "El usuario o el partido no existe"); 
		}
	}

	@Override
	public GameDTO cancelGame(GamePlayerDTO gamePlayer) {
		Optional<Player> optPlayer = playerRepo.findById(gamePlayer.getPlayerId());
		Optional<Game> optGame = gameRepo.findById(gamePlayer.getGameId());
		
		if (optPlayer.isPresent() && optGame.isPresent()) {
			Game game = optGame.get();
			game.setStatus(Game.STATUS_CANCELED);
			game.getPlayers().clear();
			gameRepo.save(game);
			return Game.createDTO(game);
		} else {
			throw new InternalException(ErrorCodes.CANCEL_PLAYER_ERROR, "El usuario o el partido no existe"); 
		}
	}

	@Override
	public List<GameDTO> getFinishedGames(Long playerId) {

		List<GameDTO> resultList = new ArrayList<>();
		Optional<Player> optPlayer = playerRepo.findById(playerId);
		
		if (optPlayer.isPresent()) {
			List<Game> gameList = gameRepo.findFinishedGamesByPlayer(playerId);
			for (Game game : gameList) {
				resultList.add(Game.createDTO(game));
			}
			return resultList;
		} else {
			throw new InternalException(ErrorCodes.FINISHED_GAMES_ERROR, "El usuario o el partido no existe"); 
		}
	}
	
}
