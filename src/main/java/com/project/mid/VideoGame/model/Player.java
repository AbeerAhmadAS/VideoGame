package com.project.mid.VideoGame.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer playerID;

    @NotEmpty(message = "ops!! the Name is Empty")
    private String playerName;
    @Email(message = "the Email invalid")
    private String playerEmail;
    @Max(value = 50, message = "The AGE of player cannot be longer than 50 years")
    @Min(value = 10, message = "The AGE of player cannot be less than 10 years")
    private Integer playerAge;
    @ManyToOne
    @JoinColumn(name = "play_by")
    private Game game;



    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public void setPlayerAge(Integer playerAge) {
        this.playerAge = playerAge;
    }
}
