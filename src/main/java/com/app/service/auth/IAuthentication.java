package com.app.service.auth;

import com.app.model.Player;
import com.app.model.auth.register.RegisterRequest;

public interface IAuthentication {

	Player registerPlayer(RegisterRequest registerRequest);
	
	Integer checkUsernameEmail(String username, String email);
	
	Player login(String username, String password);
}
