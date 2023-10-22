package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Repository.PlayerRepository;
import com.project.mid.VideoGame.controller.Interface.IPlayerController;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController implements IPlayerController {

    @Autowired
    PlayerRepository playerRepository;
    @PostMapping("/player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void savePlayer(@RequestBody Player player){
        playerRepository.save(player);
    }
    @GetMapping("/player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Player> getAllPlayer(){
        return  playerRepository.findAll();
    }
}
