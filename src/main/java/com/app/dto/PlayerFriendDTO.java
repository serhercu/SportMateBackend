package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerFriendDTO {

	private Long sender;
	private Long receiver;
	private String status;
	
}
