package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Game;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
