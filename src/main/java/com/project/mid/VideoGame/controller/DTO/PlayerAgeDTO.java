package com.project.mid.VideoGame.controller.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PlayerAgeDTO {
    @Max(value = 50, message = "The AGE of player cannot be longer than 50 years")
    @Min(value = 10, message = "The AGE of player cannot be less than 10 years")
    private Integer playerAge;

    public Integer getPlayerAge() {
        return playerAge;
    }

    public PlayerAgeDTO() {
    }

    public PlayerAgeDTO(Integer playerAge) {
        this.playerAge = playerAge;
    }
}
