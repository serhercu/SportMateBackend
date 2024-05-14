package com.app.repository.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Player;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	Optional<Player> findByUsername(String username);

}
