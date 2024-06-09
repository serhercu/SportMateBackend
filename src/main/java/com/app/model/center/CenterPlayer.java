package com.app.model.center;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "CENTER_PLAYER")
@NoArgsConstructor
public class CenterPlayer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CNP_ID")
	private Integer id;
	
	@Column(name = "CNP_PLY")
	private Integer player;
	
	@Column(name = "CNP_CNT")
	private Integer center;
	
	public CenterPlayer(Integer player, Integer center) {
		this.player = player;
		this.center = center;
	}
}
