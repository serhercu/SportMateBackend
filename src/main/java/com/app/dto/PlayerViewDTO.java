package com.app.dto;

import java.util.Set;

import com.app.model.Sport;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerViewDTO {
	
	private String username;
	private String name;
	private String surname;
	private Set<Sport> sports;

}
