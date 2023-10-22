package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.controller.Interface.IGameController;
import com.project.mid.VideoGame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController implements IGameController {
    @Autowired
    GameRepository gameRepository;
    @PostMapping("/Games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveGames(@RequestBody  Game game){
        gameRepository.save(game);
    }
    @GetMapping("/Games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Game> grtAllGames(){
        return  gameRepository.findAll();
    }


}
