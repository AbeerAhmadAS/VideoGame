package com.project.mid.VideoGame.Service.impl;

import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.Service.Interface.IGameService;
import com.project.mid.VideoGame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {
    @Autowired
    GameRepository gameRepository;

    @Override
    public Game getGamerById(Integer gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isEmpty()) return null;
        return gameOptional.get();

    }

    @Override
    public void updateGame(Game game, Integer gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "patient " + gameID + " not found");
        game.setGameID(gameID);
        gameRepository.save(game);

    }

    @Override
    public void deleteGame(Integer gameID) {
        Optional<Game> gameOptional = gameRepository.findById(gameID);
        if (gameOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + gameID + " not found");
        gameRepository.deleteById(gameID);
    }

    @Override
    public List<Game> findAllByDeviceGameRunningOn(String deviceGameRunningOn){
        List<Game>gameList=gameRepository.findAllByDeviceGameRunningOn(deviceGameRunningOn);
        if (gameList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + deviceGameRunningOn + " not found");
        return gameList;
    }
    @Override
    public void updateGamePrice(Integer price, Integer gameID){
        Optional<Game>gamePrice=gameRepository.findById(gameID);
        if(gamePrice.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee " + gameID + " not found") ;
        Game game=gamePrice.get();
        game.setGamePrice(price);
        gameRepository.save(game);
    }

    public List<Game> getGameByDesignerDesignerName(String designerName) {
        List<Game>gameList=gameRepository.findByDesignByDesignerIformationDesignerName(designerName);
        if(gameList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "designer" +designerName + " not found") ;
        return gameList;


    }




}
