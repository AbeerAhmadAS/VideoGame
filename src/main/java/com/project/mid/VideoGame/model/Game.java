package com.project.mid.VideoGame.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameID;
    @NotEmpty(message = "ops!! the Name is Empty")
    private String gameName;
    private  String gameType;
    @Max(value = 5000, message = "The price of game cannot be longer than 5000 dollar")
    @Min(value = 50 ,message = "The price of game cannot be less than 50 dollar")
    private Integer gamePrice;
    private String deviceGameRunningOn;
    @OneToOne
    @JoinColumn(name = "design_by")
    private Designer designBy;

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }
    public Designer getDesignBy() {return designBy;}
    public void setGamePrice(Integer gamePrice) {
        this.gamePrice = gamePrice;
    }
}
