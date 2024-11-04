package com.app.repository.center;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.model.center.Center;

@Repository
public interface CenterRepository extends JpaRepository<Center, Integer> {
	
	@Query("SELECT c FROM Center c " +
		       "WHERE (:city IS NULL OR c.city.id = :city) " +
		       " AND (:name is null OR UPPER(c.name) LIKE UPPER(CONCAT('%', :name, '%'))) " +
		       " AND (:nullSportList = 1 OR c.id IN " +
		       " (SELECT cs.center.id FROM CenterSport cs WHERE cs.sport IN (:sportList)))")
		List<Center> findGamesParameters(@Param("name") String name,
				@Param("city") Integer city, @Param("sportList") List<Integer> sportList,
				@Param("nullSportList") Integer nullSportList);

}
