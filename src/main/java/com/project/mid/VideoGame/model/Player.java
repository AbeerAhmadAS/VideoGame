package com.project.mid.VideoGame.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    private Integer playerID;
    @Embedded
    PlayerInforamtion playerInforamtion;

    @ManyToOne
    private Game game;

}
