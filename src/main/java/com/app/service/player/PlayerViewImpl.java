package com.app.service.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PlayerViewDTO;
import com.app.model.Player;
import com.app.repository.player.PlayerRepository;

@Service
public class PlayerViewImpl implements IPlayerViewService {
	
	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public List<PlayerViewDTO> getPlayerBySearch(String search) {
		List<PlayerViewDTO> list = new ArrayList<>();
		List<Player> results = playerRepo.findBySearch(search);
		
		for (Player result : results) {
			list.add(new PlayerViewDTO(result.getUsername(), result.getName(),
					result.getSurname(), result.getSports()));
		}
		return list;
	}

}
