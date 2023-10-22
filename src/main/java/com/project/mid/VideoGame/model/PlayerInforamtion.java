package com.project.mid.VideoGame.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class PlayerInforamtion {
    private String playerName;
    private  String playerEmail;
    private Integer playerAge;
}
