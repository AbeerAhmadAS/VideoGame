package com.project.mid.VideoGame.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Embeddable
public class PlayerInforamtion {
    @NotEmpty(message = "ops!! the Name is Empty")
    private String playerName;
    @Email(message = "the Email invalid")
    private  String playerEmail;
    @Max(value = 50, message = "The AGE of player cannot be longer than 50 years")
    @Min(value = 10 ,message = "The AGE of player cannot be less than 10 years")
    private Integer playerAge;

    public PlayerInforamtion() {
    }

    public PlayerInforamtion(String playerName, String playerEmail, Integer playerAge) {
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerAge = playerAge;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public Integer getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(Integer playerAge) {
        this.playerAge = playerAge;
    }
}
