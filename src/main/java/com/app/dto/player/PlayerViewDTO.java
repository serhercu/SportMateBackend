package com.app.dto.player;

import java.util.Set;

import com.app.model.Sport;
import com.app.model.player.Player;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerViewDTO {
	
	private Long playerId;
	private String username;
	private String name;
	private String surname;
	private Set<Sport> sports;
	
	public PlayerViewDTO(Player player) {
		this.playerId = player.getId();
		this.username = player.getUsername();
		this.name = player.getName();
		this.surname = player.getSurname();
		this.sports = player.getSports();
	}

}
