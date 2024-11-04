package com.app.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import com.app.model.City;
import com.app.model.Level;
import com.app.model.Sport;
import com.app.model.center.Center;
import com.app.model.player.Player;

import lombok.Data;

@Data
public class GameDTO {
	
	private Integer id;
	private String description;
	private Integer playersRequired;
	private Level level;
	private String location;
	private Date date;
	private Integer privacy;
	private Integer chatId;
	private Center center;
	private Sport sport;
	private Integer province;
	private City city;
	private Set<Player> players;
	private LocalTime time;
	private Long playerCreatorId;
	private Integer status;
	
}
