package com.app.repository.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.player.PlayerSport;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface PlayerSportRepository extends JpaRepository<PlayerSport, Integer> {

}
