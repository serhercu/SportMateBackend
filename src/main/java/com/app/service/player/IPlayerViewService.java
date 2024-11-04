package com.app.service.player;

import java.util.List;

import com.app.dto.player.PlayerViewDTO;

public interface IPlayerViewService {
	
	List<PlayerViewDTO> getPlayerBySearch(String search, Long playerId);

}
