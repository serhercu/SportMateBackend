package com.app.repository.player;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Player;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	Optional<Player> findByUsername(String username);
	
	@Query("SELECT p FROM Player p WHERE " +
	       " UPPER(p.name) LIKE UPPER(CONCAT('%', :search, '%')) " +
	       " OR UPPER(p.surname) LIKE UPPER(CONCAT('%', :search, '%')) " +
	       " OR UPPER(p.username) LIKE UPPER(CONCAT('%', :search, '%')) ")
	List<Player> findBySearch(@Param("search") String search);

}
