package com.app.dto.player;

import lombok.Data;

@Data
public class PlayerFriendRequestReplyDTO {
	
	private Long sender;
	private Long requesterReplier;
	private String status;

}
