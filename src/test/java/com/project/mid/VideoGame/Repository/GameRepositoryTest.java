package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class GameRepositoryTest {

    @Autowired
    DesignerRepository designerRepository;
    DesignerIformation designerIformation=new DesignerIformation("Ahmad","Ahmad@gmail.com","KSA");
    Designer designer=new Designer(designerIformation);
    @Autowired
    GameRepository gameRepository;

    Game game=new Game("Chrome Valley Customs", "puzzle", 100, "mobile",designer);
    @BeforeEach
    public void setUp() {

            //gameRepository.save(game);


    }


    @AfterEach
    public void tearDown() {
        gameRepository.delete(game);
    }

    @Test
    public void findAllByDeviceGameRunningOn() {
        String deviceGameRunningOn = "PC";
        List<Game> gameList = gameRepository.findAllByDeviceGameRunningOn(deviceGameRunningOn);
        if(gameList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The device " + deviceGameRunningOn + " not found");
        System.out.println(gameList);
        assertEquals(deviceGameRunningOn, gameList.get(0).getDeviceGameRunningOn());
    }




    @Test
    public void findByDesignByDesignerIformationDesignerName(){
        List<Game> gameList = gameRepository.findByDesignByDesignerIformationDesignerName("Abeer");
        System.out.println(gameList);
        assertEquals(1, gameList.size());

    }
}
