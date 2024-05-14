package com.app.model;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.app.dto.GameDTO;

import lombok.Data;

@Entity
@DynamicUpdate
@Data
@Table(name = "GAME")
public class Game {
	
	public static final Integer STATUS_OPEN = 10;
	public static final Integer STATUS_CANCELED = 50;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "GAM_ID")
	private Integer id;
	
	@Column(name = "GAM_DESCRIPTION")
	private String description;
	
	@Column(name = "GAM_PLAYERS_REQUIRED")
	private Integer playersRequired;
	
	@ManyToOne
	@JoinColumn(name = "GAM_LEVEL", referencedColumnName = "LEV_ID")
	private Level level;
	
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
	
	@ManyToOne
	@JoinColumn(name = "GAM_CTY_ID", referencedColumnName = "CTY_ID")
	private City city;
	
	@ManyToMany
    @JoinTable(
        name = "GAME_PLAYER",
        joinColumns = @JoinColumn(name = "GAP_GAM_ID"),
        inverseJoinColumns = @JoinColumn(name = "GAP_PLY_ID")
    )
    private Set<Player> players;
	
	@Column(name = "GAM_TIME")
	private LocalTime time;
	
	@Column(name = "GAM_STATUS")
	private Integer status;
	
	@Column(name = "GAM_PLY_CREATOR")
	private Long playerCreatorId;

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
		gameDTO.setCity(game.getCity());
		gameDTO.setPlayers(game.getPlayers());
		gameDTO.setTime(game.getTime());
		gameDTO.setPlayerCreatorId(game.getPlayerCreatorId());
		gameDTO.setStatus(game.getStatus());
		
		return gameDTO;
	}
	
}
