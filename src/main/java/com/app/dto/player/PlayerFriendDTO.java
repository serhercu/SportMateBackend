package com.app.dto.player;

import com.app.model.player.PlayerFriend;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerFriendDTO {

	private Long sender;
	private Long receiver;
	private String status;
	
	public PlayerFriendDTO(PlayerFriend entity) {
		this.sender = entity.getSender();
		this.receiver = entity.getReceiver();
		this.status = entity.getStatus();
	}
	
	public PlayerFriendDTO(PlayerFriend entity, String status) {
		this.sender = entity.getSender();
		this.receiver = entity.getReceiver();
		this.status = status;
	}
	
}
