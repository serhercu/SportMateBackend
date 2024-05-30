package com.app.service.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.player.PlayerViewDTO;
import com.app.dto.player.PlayerViewFriendStatusDTO;
import com.app.model.player.Player;
import com.app.repository.player.PlayerRepository;
import com.app.service.friend.IPlayerFriendService;

@Service
public class PlayerViewImpl implements IPlayerViewService {
	
	@Autowired
	private PlayerRepository playerRepo;
	
	@Autowired
	private IPlayerFriendService playerFriendService;

	@Override
	public List<PlayerViewDTO> getPlayerBySearch(String search, Long playerId) {
		List<PlayerViewDTO> list = new ArrayList<>();
		List<Player> results = playerRepo.findBySearch(search);
		
		for (Player result : results) {
			String status = playerFriendService.getPlayerStatus(playerId, result.getId());
			list.add(new PlayerViewFriendStatusDTO(result, status));
		}
		return list;
	}

}
