package com.project.mid.VideoGame.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class Player {
    @Id
    private Integer playerID;
    @Embedded
    PlayerInforamtion playerInforamtion;

    @ManyToOne
    private Game game;

    public Player() {
    }

    public Player(Integer playerID, PlayerInforamtion playerInforamtion, Game game) {
        this.playerID = playerID;
        this.playerInforamtion = playerInforamtion;
        this.game = game;
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public PlayerInforamtion getPlayerInforamtion() {
        return playerInforamtion;
    }

    public void setPlayerInforamtion(PlayerInforamtion playerInforamtion) {
        this.playerInforamtion = playerInforamtion;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
