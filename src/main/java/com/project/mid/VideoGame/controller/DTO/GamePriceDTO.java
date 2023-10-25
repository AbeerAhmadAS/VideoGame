package com.project.mid.VideoGame.controller.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class GamePriceDTO {
    @Max(value = 5000, message = "The price of game cannot be longer than 5000 dollar")
    @Min(value = 50 ,message = "The price of game cannot be less than 50 dollar")
    private Integer gamePrice;

    public Integer getGamePrice() {
        return gamePrice;
    }

    public GamePriceDTO() {
    }

    public GamePriceDTO(Integer gamePrice) {
        this.gamePrice = gamePrice;
    }
}
