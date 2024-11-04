package com.app.model.player;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

@Entity
@DynamicUpdate
@Table(name = "PLAYER_SPORT")
public class PlayerSport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLS_ID")
	private Integer id;
	
	@NonNull
	@Column(name = "PLS_PLY_ID")
	private Long playerId;
	
	@NonNull
	@Column(name = "PLS_SPO_ID")
	private Integer sportId;
	
	@Column(name = "PLS_LEVEL")
	private Integer level;
	
	public PlayerSport() {
		
	}
	
	public PlayerSport(Long playerId, Integer sportId, Integer level) {
		this.playerId = playerId;
		this.sportId = sportId;
		this.level = level;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public Integer getSportId() {
		return sportId;
	}

	public void setSportId(Integer sportId) {
		this.sportId = sportId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}
}
