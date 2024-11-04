package com.app.repository.player;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.player.PlayerFriend;

public interface PlayerFriendRepository extends JpaRepository<PlayerFriend, PlayerFriend.PlayerFriendId>{

	@Query("SELECT p.status FROM PlayerFriend p WHERE " +
	           " p.sender = :sender " +
	           " AND p.receiver = :receiver ")
	String status(@Param("sender") Long sender, @Param("receiver") Long receiver);
	
	@Query("SELECT p FROM PlayerFriend p WHERE " +
	           " (p.sender = :playerId1 AND p.receiver = :playerId2) " +
	           " OR (p.sender = :playerId2 AND p.receiver = :playerId1) ")
	Optional<PlayerFriend> friendStatus(@Param("playerId1") Long playerId1, @Param("playerId2") Long playerId2);
	
	List<PlayerFriend> findByReceiverAndStatus(Long receiver, String status);
	
	@Query("SELECT p FROM PlayerFriend p WHERE " +
	           " (p.sender = :playerId1 " +
	           " OR p.receiver = :playerId1) " +
	           " AND p.status = 'A' ")
	List<PlayerFriend> findByReceiverOrSender(@Param("playerId1") Long playerId);
}
