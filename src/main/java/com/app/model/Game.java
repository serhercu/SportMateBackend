package com.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.app.dto.GameDTO;

@Entity
@DynamicUpdate
@Table(name = "GAME")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "GAM_ID")
	private Integer id;
	
	@Column(name = "GAM_DESCRIPTION")
	private String description;
	
	@Column(name = "GAM_PLAYERS_REQUIRED")
	private Integer playersRequired;
	
	@Column(name = "GAM_LEVEL")
	private Integer level;
	
	@Column(name = "GAM_PROVINCE")
	private Integer province;
	
	@Column(name = "GAM_LOCATION")
	private String location;
	
	@Column(name = "GAM_DATE")
	private Date date;
	
	@Column(name = "GAM_PRIVACY")
	private Integer privacy;
	
	@Column(name = "GAM_CHAT_ID")
	private Integer chatId;
	
	@ManyToOne
	@JoinColumn(name = "GAM_CEN_ID", referencedColumnName = "CNT_ID")
	private Center center;
	
	@ManyToOne
	@JoinColumn(name = "GAM_SPO_ID", referencedColumnName = "SPO_ID")
	private Sport sport;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPlayersRequired() {
		return playersRequired;
	}

	public void setPlayersRequired(Integer playersRequired) {
		this.playersRequired = playersRequired;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Integer privacy) {
		this.privacy = privacy;
	}

	public Integer getChatId() {
		return chatId;
	}

	public void setChatId(Integer chatId) {
		this.chatId = chatId;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Sport getSport() {
		return sport;
	}

	public void setSport(Sport sport) {
		this.sport = sport;
	}
	
	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public static GameDTO createDTO(Game game) {
		GameDTO gameDTO = new GameDTO();
		
		gameDTO.setId(game.getId());
		gameDTO.setDescription(game.getDescription());
		gameDTO.setCenter(game.getCenter());
		gameDTO.setChatId(game.getChatId());
		gameDTO.setDate(game.getDate());
		gameDTO.setLevel(game.getLevel());
		gameDTO.setLocation(game.getLocation());
		gameDTO.setPlayersRequired(game.getPlayersRequired());
		gameDTO.setPrivacy(game.getPrivacy());
		gameDTO.setSport(game.getSport());
		gameDTO.setProvince(game.getProvince());
		
		return gameDTO;
	}
	
}
