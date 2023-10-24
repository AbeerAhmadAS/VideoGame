package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.Service.Interface.IGameService;
import com.project.mid.VideoGame.controller.DTO.GamePriceDTO;
import com.project.mid.VideoGame.controller.Interface.IGameController;
import com.project.mid.VideoGame.model.Game;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController implements IGameController {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    IGameService iGameService;
    ///////////////////////////////POST//////////////////////////////////////////
    @PostMapping("/Games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveGames(@RequestBody @Valid Game game){
        gameRepository.save(game);
    }
   ///////////////////////////////////GET/////////////////////////////////////////////////
    //GET ALL GAMES
    @GetMapping("/games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Game> grtAllGames(){
        return  gameRepository.findAll();
    }
    //GET GAME BY ID
    @GetMapping("/games/{gameID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game getGameById(@PathVariable Integer gameID){
        return iGameService.getGamerById(gameID);
    }

    //get game by name of device that running the game
   /* @GetMapping("/games/{deviceGameRunningOn}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void getGameByDevice(@PathVariable String deviceGameRunningOn){
          iGameService.getGameByDevice(deviceGameRunningOn);
    }*/




















    ///////////////////////////////PUT////////////////////////////////////////////////
      @PutMapping("/Games/{gameID}")
      @ResponseStatus(HttpStatus.NO_CONTENT)
      public void updateGame(@RequestBody @Valid Game game, @PathVariable Integer gameID) {
           iGameService.updateGame(game,gameID);
}
    /////////////////////////////////DELETE////////////////////////////////////////////////////
    @DeleteMapping("/Games/{gameID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable Integer gameID) {
        iGameService.deleteGame(gameID);
    }
    ///////////////////////////////////PUTCH/////////////////////
    @PatchMapping("/Games/gamePrice/{gameID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGamePrice(@RequestBody @Valid GamePriceDTO gamePriceDTO, @PathVariable (name = "gameID" )Integer gameID){
        iGameService.updateGamePrice(gamePriceDTO.getGamePrice(),gameID);
    }

}
