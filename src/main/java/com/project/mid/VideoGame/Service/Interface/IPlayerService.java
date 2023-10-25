package com.project.mid.VideoGame.Service.Interface;

import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IPlayerService {
    public Player getPlayerById(Integer playerID);
    public void updatePlayer( Player player , Integer playerID);
    public void deletePlayer(Integer playerID);
    public void updatePlayerAge(Integer age, Integer playerID);
    public List<Player> getPlayerByGameGameName( String gameName);
}
