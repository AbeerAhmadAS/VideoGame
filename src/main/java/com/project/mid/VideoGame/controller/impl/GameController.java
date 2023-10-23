package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.Service.Interface.IGameService;
import com.project.mid.VideoGame.Service.impl.GameService;
import com.project.mid.VideoGame.controller.Interface.IGameController;
import com.project.mid.VideoGame.model.Designer;
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
    @GetMapping("/Games")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Game> grtAllGames(){
        return  gameRepository.findAll();
    }
    @GetMapping("/Games/{gameID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Game getGameById(@PathVariable Integer gameID){
        return iGameService.getGamerById(gameID);
    }
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

}
