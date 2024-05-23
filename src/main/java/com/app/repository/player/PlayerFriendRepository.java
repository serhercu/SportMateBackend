package com.app.repository.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.model.PlayerFriend;

public interface PlayerFriendRepository extends JpaRepository<PlayerFriend, PlayerFriend.PlayerFriendId>{

	@Query("SELECT p.status FROM PlayerFriend p WHERE " +
	           " p.sender = :sender " +
	           " AND p.receiver = :receiver ")
	String status(@Param("sender") Long sender, @Param("receiver") Long receiver);
}
