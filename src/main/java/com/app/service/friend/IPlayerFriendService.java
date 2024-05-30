package com.app.service.friend;

import java.util.List;

import com.app.dto.player.PlayerFriendDTO;
import com.app.dto.player.PlayerFriendRequestReplyDTO;
import com.app.dto.player.PlayerViewFriendStatusDTO;

public interface IPlayerFriendService {
	
	PlayerFriendDTO request(PlayerFriendDTO request);
	
	String status(Long sender, Long receiver);
	
	List<PlayerViewFriendStatusDTO> getFriendRequestByPlayer(Long playerId);
	
	List<PlayerViewFriendStatusDTO> getFriendsByPlayer(Long playerId);
	
	void replyFriendRequest(PlayerFriendRequestReplyDTO reply);
	
	String getPlayerStatus(Long player, Long searchedPlayer);

}
