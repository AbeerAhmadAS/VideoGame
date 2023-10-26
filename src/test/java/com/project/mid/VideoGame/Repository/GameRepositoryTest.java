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

            gameRepository.save(game);


    }


    @AfterEach
    public void tearDown() {
        gameRepository.delete(game);
    }

    /*@Test
    public void findAllByDeviceGameRunningOn() {
        String deviceGameRunningOn = "Chrome Valley Customs";
        List<Game> gameOptional = gameRepository.findAllByDeviceGameRunningOn(deviceGameRunningOn);
        System.out.println(gameOptional);
        assertEquals(deviceGameRunningOn, gameOptional);
    }


    @Test
    public void findAllByDeviceGameRunningOn_validName_correctGame() {
        List<Game> gameList = gameRepository.findAllByDeviceGameRunningOn("PC");
        System.out.println(gameList);
        assertEquals(1, gameList.size());
    }
    @Test
    public void findByDesignByDesignerIformationDesignerName(){
        List<Game> gameList = gameRepository.findByDesignByDesignerIformationDesignerName("Abeer");
        System.out.println(gameList);
        assertEquals(1, gameList.size());

    }*/
}
