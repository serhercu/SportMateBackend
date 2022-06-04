package com.app.dto;

public class SportDTO {
	
	private Integer id;
	private String name;
	private String image;
	private Integer numberPlayers;
	
	public SportDTO() {
		super();
	}
	
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
}
