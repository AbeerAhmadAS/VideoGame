package com.project.mid.VideoGame.Service.Interface;

import com.project.mid.VideoGame.model.Game;

import java.util.List;

public interface IGameService {
    public Game getGamerById(Integer gameID);
    public void updateGame( Game game, Integer gameID);
    public void deleteGame(Integer gameID);
    //public List<Game> getGameByDevice(String deviceGameRunningOn);
    public void updateGamePrice(Integer price, Integer gameID);
}
