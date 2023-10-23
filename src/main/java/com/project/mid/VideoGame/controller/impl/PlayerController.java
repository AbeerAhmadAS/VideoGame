package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Repository.PlayerRepository;
import com.project.mid.VideoGame.Service.Interface.IPlayerService;
import com.project.mid.VideoGame.controller.Interface.IPlayerController;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Player;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController implements IPlayerController {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    IPlayerService iPlayerService;
    /////////////////////////////////POST//////////////////////////////////
    @PostMapping("/player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void savePlayer(@RequestBody Player player){
        playerRepository.save(player);
    }
    //////////////////////////////////GET//////////////////////////////////////////
    @GetMapping("/player")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Player> getAllPlayer(){
        return  playerRepository.findAll();
    }
//GET BY ID
    @GetMapping("/player/{playerID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Player getPlayerById(@PathVariable Integer playerID){
        return iPlayerService.getPlayerById(playerID);
    }
    /////////////////////////////////////////PUT//////////////////////////////////
    @PutMapping("/player/{playerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePlayer(@RequestBody @Valid Player player, @PathVariable Integer playerID) {
        iPlayerService.updatePlayer(player, playerID);
    }


    /////////////////////////////////////PATCH////////////////////////////////////


    /////////////////////////////////////////DELETE////////////////////////////////////
    @DeleteMapping("/player/{playerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePlayer(@PathVariable Integer playerID) {
        iPlayerService.deletePlayer(playerID);
    }





}
