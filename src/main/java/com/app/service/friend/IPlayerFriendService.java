package com.app.service.friend;

import com.app.dto.PlayerFriendDTO;

public interface IPlayerFriendService {
	
	PlayerFriendDTO request(PlayerFriendDTO request);
	
	String status(Long sender, Long receiver);

}
