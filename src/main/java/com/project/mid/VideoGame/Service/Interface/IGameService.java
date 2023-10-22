package com.project.mid.VideoGame.Service.Interface;

import com.project.mid.VideoGame.model.Game;

public interface IGameService {
    public Game getGamerById(Integer gameID);
    public void updateGame( Game game, Integer gameID);
}
