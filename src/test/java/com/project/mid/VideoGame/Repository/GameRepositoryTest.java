package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import com.project.mid.VideoGame.model.Game;
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
    DesignerIformation designerIformation = new DesignerIformation("Ahmad", "Ahmad@gmail.com", "KSA");
    Designer designer = new Designer(designerIformation);
    @Autowired
    GameRepository gameRepository;
    Game game = new Game("Chrome Valley Customs", "puzzle", 100, "mobile",designer);

    @BeforeEach
    public void setUp() {
        gameRepository.save(game);
    }

    @AfterEach
    public void tearDown() {
        //gameRepository.delete(game);
    }

    //@Test
    /*public void findAllByDeviceGameRunningOn() {
        Game game1=new Game("test","testing",100,"PC",null);
        GameRepository gameRepository1 = null;
        gameRepository1.save(game1);
        String deviceGameRunningOn = "PC";
        Optional<Game> gameOptional = gameRepository1.findAllByDeviceGameRunningOn(deviceGameRunningOn);
        //assertTrue(gameOptional.isPresent());
        System.out.println(gameOptional);
        assertEquals(deviceGameRunningOn, gameOptional.get().getDeviceGameRunningOn());
    }*/
}
