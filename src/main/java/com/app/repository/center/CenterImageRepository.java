package com.app.repository.center;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.center.Center;
import com.app.model.center.CenterImage;

@Repository
public interface CenterImageRepository extends JpaRepository<CenterImage, Integer> {

	List<CenterImage> findByCenter(Center center);
}
