package com.project.mid.VideoGame.Service.Interface;

import com.project.mid.VideoGame.model.Player;

public interface IPlayerService {
    public Player getPlayerById(Integer playerID);
    public void updatePlayer( Player player , Integer playerID);
    public void deletePlayer(Integer playerID);
    public void updatePlayerAge(Integer age, Integer playerID);
}
