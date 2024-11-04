package com.app.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Authentication;
import com.app.model.auth.register.RegisterRequest;
import com.app.model.auth.register.SportRequest;
import com.app.model.player.Player;
import com.app.model.player.PlayerSport;
import com.app.repository.player.AuthenticationRepository;
import com.app.repository.player.PlayerRepository;
import com.app.repository.player.PlayerSportRepository;
import com.app.util.ErrorCodes;
import com.app.util.InternalException;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@Service
public class AuthenticationServiceImpl implements IAuthentication {

	@Autowired
	PlayerRepository playerRepo;
	
	@Autowired
	PlayerSportRepository playerSportRepo;
	
	@Autowired
	AuthenticationRepository authRepo;
	
	Argon2 argon2 = Argon2Factory.create();
	
	@Override
	public Player registerPlayer(RegisterRequest registerRequest) {
		Player requestPlayer = registerRequest.getPlayer();

		playerRepo.save(requestPlayer);

		try {
			String hashedPassword = argon2.hash(10, 65536, 1, registerRequest.getPassword());
			Authentication authRequest = new Authentication(requestPlayer.getId(), hashedPassword);
			authRepo.save(authRequest);
		} finally {
		    argon2.wipeArray(registerRequest.getPassword().toCharArray());
		}
		
		for (SportRequest sportRequest : registerRequest.getSportList()) {
	        PlayerSport playerSport = new PlayerSport(requestPlayer.getId(), sportRequest.getSport().getId(),
	        		sportRequest.getLevel().getId());
	        playerSportRepo.save(playerSport);
	    }
		
		return requestPlayer;
	}

	@Override
	public Integer checkUsernameEmail(String username, String email) {
		if (playerRepo.existsByEmail(email)) {			
			return ErrorCodes.EMAIL_ALREADY_EXISTS;
		}
		if (playerRepo.existsByUsername(username)) {
			return ErrorCodes.USER_ALREADY_EXISTS;
		}
		return 200;
	}
	
	@Override
	public Player login(String username, String password) {
		Optional<Player> player = playerRepo.findByUsername(username);
		if (!player.isPresent()) {
		    throw new InternalException(ErrorCodes.USER_NOT_EXISTS, "El usuario no existe");
		}
		
		if (!checkLogin(player.get().getId(), password)) {
			throw new InternalException(ErrorCodes.WRONG_PASSWORD, "Contraseña incorrecta");
		}

		return player.get();
	}
	
	private boolean checkLogin(Long userId, String password) {
		Optional<Authentication> optAuth = authRepo.findByUserId(userId);
		if (!optAuth.isPresent()) {
		    return false;
		}
		try {
			return argon2.verify(optAuth.get().getHash(), password);
		} finally {
		    argon2.wipeArray(password.toCharArray());
		}
	}
}
