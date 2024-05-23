package com.app.service.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PlayerFriendDTO;
import com.app.model.PlayerFriend;
import com.app.repository.player.PlayerFriendRepository;

@Service
public class PlayerFriendImpl implements IPlayerFriendService {
	
	@Autowired
	private PlayerFriendRepository playerFriendRepo;

	@Override
	public PlayerFriendDTO request(PlayerFriendDTO request) {
		PlayerFriend newRequest = new PlayerFriend(request.getSender(), request.getReceiver(),
				PlayerFriend.PENDING);
		
		PlayerFriend created = playerFriendRepo.save(newRequest);
		
		return new PlayerFriendDTO(created.getSender(), created.getReceiver(), created.getStatus());
		
	}

	@Override
	public String status(Long sender, Long receiver) {
		return playerFriendRepo.status(sender, receiver);
	}

}
