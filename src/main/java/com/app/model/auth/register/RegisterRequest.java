package com.app.model.auth.register;

import java.util.List;

import com.app.model.player.Player;

public class RegisterRequest {
	
	private Player player;
	private List<SportRequest> sportList;
	private String password;

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<SportRequest> getSportList() {
		return sportList;
	}

	public void setSportList(List<SportRequest> sportList) {
		this.sportList = sportList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
