package com.project.mid.VideoGame.controller.Interface;

import com.project.mid.VideoGame.model.Player;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IPlayerController {
    public void savePlayer(Player player);


    public List<Player> getAllPlayer();
}
