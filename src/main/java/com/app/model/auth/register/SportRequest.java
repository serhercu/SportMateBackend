package com.app.model.auth.register;

import com.app.model.Level;
import com.app.model.Sport;

import lombok.Data;

@Data
public class SportRequest {
	
	private Sport sport;
	private Level level;

}
