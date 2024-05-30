package com.app.service.friend;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.player.PlayerFriendDTO;
import com.app.dto.player.PlayerFriendRequestReplyDTO;
import com.app.dto.player.PlayerViewDTO;
import com.app.dto.player.PlayerViewFriendStatusDTO;
import com.app.model.player.Player;
import com.app.model.player.PlayerFriend;
import com.app.model.player.PlayerFriend.PlayerFriendId;
import com.app.repository.player.PlayerFriendRepository;
import com.app.repository.player.PlayerRepository;
import com.app.util.ErrorCodes;
import com.app.util.InternalException;

@Service
public class PlayerFriendImpl implements IPlayerFriendService {
	
	@Autowired
	private PlayerFriendRepository playerFriendRepo;
	
	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public PlayerFriendDTO request(PlayerFriendDTO request) {
		PlayerFriend newRequest = new PlayerFriend(request.getSender(), request.getReceiver(),
				PlayerFriend.PENDING);
		
		PlayerFriend created = playerFriendRepo.save(newRequest);
		
		return new PlayerFriendDTO(created, PlayerFriend.PENDING_OTHER_USER);
		
	}
	
	@Override
	public String getPlayerStatus(Long player, Long searchedPlayer) {
		Optional<PlayerFriend> playerFriend = playerFriendRepo.friendStatus(player, searchedPlayer);
		if (!playerFriend.isPresent()) {
			return null;
		} else if (playerFriend.get().getStatus().equalsIgnoreCase(PlayerFriend.PENDING)) {
			if (playerFriend.get().getSender().equals(player)) {
				return PlayerFriend.PENDING_OTHER_USER;
			} else {
				return PlayerFriend.PENDING;
			}
		} else {
			return playerFriend.get().getStatus();
		}
	}

	@Override
	public String status(Long sender, Long receiver) {
		return playerFriendRepo.status(sender, receiver);
	}

	@Override
	public List<PlayerViewFriendStatusDTO> getFriendRequestByPlayer(Long playerId) {
		List<PlayerViewDTO> resultList = new ArrayList<>();
		List<PlayerFriend> repoList = playerFriendRepo.findByReceiverAndStatus(playerId, PlayerFriend.PENDING);
		for (PlayerFriend request : repoList) {
			Optional<Player> playerRequester = playerRepo.findById(request.getSender());
			if (playerRequester.isPresent()) {
				resultList.add(new PlayerViewDTO(playerRequester.get()));				
			}
		}
		return getPlayerViewFriendStatusDTOList(repoList, playerId);
	}
	
	@Override
	public List<PlayerViewFriendStatusDTO> getFriendsByPlayer(Long playerId) {
		List<PlayerFriend> repoList = playerFriendRepo.findByReceiverOrSender(playerId);
		return getPlayerViewFriendStatusDTOList(repoList, playerId);
	}
	
	private List<PlayerViewFriendStatusDTO> getPlayerViewFriendStatusDTOList(List<PlayerFriend> list, Long playerId) {
		List<PlayerViewFriendStatusDTO> resultList = new ArrayList<>();
		for (PlayerFriend request : list) {
			Optional<Player> playerRequester = playerRepo.findById(request.getSender().equals(playerId) ? request.getReceiver() : request.getSender());
			if (playerRequester.isPresent()) {
				resultList.add(new PlayerViewFriendStatusDTO(playerRequester.get(), request.getStatus()));				
			}
		}
		return resultList;
	}

	@Override
	public void replyFriendRequest(PlayerFriendRequestReplyDTO reply) {
		Optional<PlayerFriend> friendRequestOpt = playerFriendRepo.findById(new PlayerFriendId(reply.getSender(), reply.getRequesterReplier()));
		if (friendRequestOpt.isPresent()) {
			PlayerFriend friendRequest = friendRequestOpt.get();
			friendRequest.setStatus(reply.getStatus());
			playerFriendRepo.save(friendRequest);
		} else {
			throw new InternalException(ErrorCodes.REPLY_FRIEND_REQUEST_ERROR, "No se ha encontrado la solicitud con esos parámetros");
		}
		
	}

}
