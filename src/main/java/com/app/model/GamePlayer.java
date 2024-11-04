package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "GAME_PLAYER")
public class GamePlayer {
    @Id
    @Column(name = "GAP_ID")
    private Long id;

    @Column(name = "GAP_PLY_ID")
    private Long playerId;

    @Column(name = "GAP_GAM_ID")
    private Long gameId;
}