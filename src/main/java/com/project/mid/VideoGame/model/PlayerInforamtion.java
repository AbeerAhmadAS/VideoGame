package com.project.mid.VideoGame.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlayerInforamtion {
    private String playerName;
    private  String playerEmail;
    private Integer playerAge;
    @ManyToOne
    private Game game;

}
