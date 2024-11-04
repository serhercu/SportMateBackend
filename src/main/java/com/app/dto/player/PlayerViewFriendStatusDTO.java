package com.app.dto.player;

import com.app.model.player.Player;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PlayerViewFriendStatusDTO extends PlayerViewDTO {
	
	private String status;

	public PlayerViewFriendStatusDTO(Player player, String status) {
		super(player);
		this.status = status;
	}
}
