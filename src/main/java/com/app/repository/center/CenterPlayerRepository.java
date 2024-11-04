package com.app.repository.center;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.model.center.CenterPlayer;

public interface CenterPlayerRepository extends JpaRepository<CenterPlayer, Integer> {
	
	Optional<CenterPlayer> findByPlayerAndCenter(Integer player, Integer center);
}
