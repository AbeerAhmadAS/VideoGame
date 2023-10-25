package com.project.mid.VideoGame.controller.Interface;

import com.project.mid.VideoGame.model.Game;

import java.util.List;

public interface IGameController {
    public void saveGames( Game game);
    public List<Game> grtAllGames();
    public List<Game> findAllByDeviceGameRunningOn(String deviceGameRunningOn);
    public List<Game> getGameByDesignerDesignerName(String designerName);


    }
