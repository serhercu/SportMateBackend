package com.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "CENTER")
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CNT_ID")
	private Integer id;
	
	@Column(name = "CNT_DESCRIPTION")
	private String description;
	
	@Column(name = "CNT_NAME")
	private Integer playersRequired;
	
	@Column(name = "CNT_LOCATION")
	private Integer level;
	
	@ManyToMany
	@JoinTable(
	  name = "CENTER_SPORT", 
	  joinColumns = @JoinColumn(name = "CNT_ID"), 
	  inverseJoinColumns = @JoinColumn(name = "SPO_ID"))
	Set<Sport> sports;

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

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
	
}
