package com.app.model.player;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DynamicUpdate
@IdClass(PlayerFriend.PlayerFriendId.class)
@Table(name = "PLAYER_FRIEND")
public class PlayerFriend {
	
	public static final String PENDING = "P";
	public static final String PENDING_OTHER_USER = "O";
	public static final String ACCEPTED = "A";
	
	@Id
	@Column(name = "PLF_PLY_SENDER")
	private Long sender;
	
	@Id
	@Column(name = "PLF_PLY_RECEIVER")
	private Long receiver;
	
	@Column(name = "PLF_STATUS")
	private String status;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class PlayerFriendId implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Column(name = "PLF_PLY_SENDER")
		private Long sender;
		
		@Column(name = "PLF_PLY_RECEIVER")
		private Long receiver;
	}
}
