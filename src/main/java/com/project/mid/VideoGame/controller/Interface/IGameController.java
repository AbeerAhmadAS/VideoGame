package com.project.mid.VideoGame.controller.Interface;

import com.project.mid.VideoGame.model.Game;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IGameController {
    public void saveGames( Game game);
    public List<Game> grtAllGames();



}
