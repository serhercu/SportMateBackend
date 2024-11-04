package com.app.repository.player;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.app.model.Authentication;

@CrossOrigin(origins="http://localhost:8080")
@Repository
public interface AuthenticationRepository extends JpaRepository<Authentication, Long> {
	
	Optional<Authentication> findByUserId(Long userId);
}
