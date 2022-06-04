package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.app.dto.SportDTO;

@Entity
@DynamicUpdate
@Table(name = "SPORT")
public class Sport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SPO_ID")
	private Integer id;
	
	@Column(name = "SPO_NAME")
	private String name;

	@Column(name = "SPO_IMAGE")
	private String image;
	
	@Column(name = "SPO_NUMBER_OF_PLAYERS")
	private Integer numberPlayers;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getNumberPlayers() {
		return numberPlayers;
	}

	public void setNumberPlayers(Integer numberPlayers) {
		this.numberPlayers = numberPlayers;
	}
	
	public static SportDTO createDTO(Sport sport) {
		SportDTO sportDTO = new SportDTO();
		
		sportDTO.setId(sport.getId());
		sportDTO.setName(sport.getName());
		sportDTO.setImage(sport.getImage());
		sportDTO.setNumberPlayers(sport.getNumberPlayers());
		
		return sportDTO;
		
	}
}