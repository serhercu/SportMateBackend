package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.app.dto.LevelDTO;

@Entity
@DynamicUpdate
@Table(name = "LEVEL")
public class Level {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "LEV_ID")
	private Integer id;
	
	@Column(name = "LEV_DESCRIPTION")
	private String description;
	
	@Column(name = "LEV_VALUE")
	private Integer value;

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

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	public static LevelDTO createDTO(Level level) {
		LevelDTO levelDTO = new LevelDTO();
		
		levelDTO.setId(level.getId());
		levelDTO.setDescription(level.getDescription());
		levelDTO.setValue(level.getValue());
		
		return levelDTO;
	}
	
	public static Level convertFromDTO(LevelDTO levelDto) {
		Level level = new Level();
		
		level.setId(levelDto.getId());
		level.setDescription(levelDto.getDescription());
		level.setValue(levelDto.getValue());
		
		return level;
	}

}
