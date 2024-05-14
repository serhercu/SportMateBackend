package com.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Game;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {
	
	@Query("SELECT g FROM Game g WHERE (:sportId IS NULL OR g.sport.id = :sportId) " +
			   "AND (:levelId IS NULL OR g.level = :levelId) " +
			   "AND (:cityId IS NULL OR g.city.id = :cityId) " +
	           "AND (:startDate IS NULL OR g.date >= :startDate) " +
	           "AND (:endDate IS NULL OR g.date <= :endDate) " +
			   "ORDER BY g.date desc")
	List<Game> findGamesBySportIdAndLevelAndCityAndDateRange(@Param("sportId") Integer sportId, @Param("levelId") Integer levelId,
			@Param("cityId") Integer cityId, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
