package com.project.mid.VideoGame.Service.impl;

import com.project.mid.VideoGame.Repository.PlayerRepository;
import com.project.mid.VideoGame.Service.Interface.IPlayerService;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService implements IPlayerService {
    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player getPlayerById(Integer playerID){
        Optional <Player> PlayerOptional=playerRepository.findById(playerID);
        if(PlayerOptional.isEmpty())return  null;
        return PlayerOptional.get();}

    @Override
    public void updatePlayer( Player player , Integer playerID){
        Optional<Player> PlayerOptional=playerRepository.findById(playerID);
        if(PlayerOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "patient " + playerID + " not found") ;
        player.setPlayerID(playerID);
        playerRepository.save(player);

    }
    @Override
    public void deletePlayer(Integer playerID) {
        Optional<Player> PlayerOptional = playerRepository.findById(playerID);
        if (PlayerOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + playerID + " not found");
        playerRepository.deleteById(playerID);
    }
    @Override
    public void updatePlayerAge(Integer age, Integer playerID){
        Optional<Player>playerAge=playerRepository.findById(playerID);
        if(playerAge.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee " + playerID + " not found") ;
        Player player=playerAge.get();
        player.setPlayerAge(age);
        playerRepository.save(player);
    }
   @Override
    public List<Player> getPlayerByGameGameName( String gameName) {
        List<Player>PlayerList=playerRepository.findByGameByGameName(gameName);
        if(PlayerList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "game " + gameName + " not found") ;
        return PlayerList;


    }
}

