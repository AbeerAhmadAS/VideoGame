package com.project.mid.VideoGame.Service.impl;

import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.Service.Interface.IGameService;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class GameService implements IGameService {
    @Autowired
    GameRepository gameRepository;
    @Override
    public Game getGamerById(Integer gameID){
        Optional<Game> gameOptional=gameRepository.findById(gameID);
        if(gameOptional.isEmpty())return  null;
        return gameOptional.get();

    }
    @Override
    public void updateGame( Game game, Integer gameID){
        Optional<Game> gameOptional=gameRepository.findById(gameID);
        if(gameOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "patient " + gameID + " not found") ;
        game.setGameID(gameID);
        gameRepository.save(game);

    }
    @Override
    public void deleteGame(Integer gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + gameID + " not found");
        gameRepository.deleteById(gameID);
    }
}
