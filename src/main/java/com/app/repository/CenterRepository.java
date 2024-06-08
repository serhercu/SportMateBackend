package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.Center;

public interface CenterRepository  extends JpaRepository<Center, Integer> {
	
	@Query("SELECT c FROM Center c " +
		       "WHERE ((:sportList) IS NULL OR " +
		       "c.id IN (SELECT cs.center FROM CenterSport cs " +
		       "WHERE c.id = cs.center " +
		       "AND cs.sport IN (:sportList)))")
		List<Center> findGamesParameters(@Param("sportList") List<Integer> sportList);

}
