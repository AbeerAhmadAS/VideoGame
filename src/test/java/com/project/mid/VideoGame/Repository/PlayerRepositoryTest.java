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

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PlayerRepositoryTest {
    DesignerIformation designerIformation=new DesignerIformation("Ahmad","Ahmad@gmail.com","KSA");
    Designer designer=new Designer(designerIformation);
    Game game=new Game("Chrome Valley Customs", "puzzle", 100, "mobile",designer);
    @Autowired
    PlayerRepository playerRepository;
    Player player=new Player("player test","playerTest@gmail.com",34,game);
    @BeforeEach
    public void setUp() {

        //playerRepository.save(player);
        }


    @AfterEach
    public void tearDown() {
        playerRepository.delete(player);
    }
    @Test
    public void findByGameByGameName(){
        List<Player> playerList = playerRepository.findByGameByGameName("Car race");
        System.out.println(playerList);
        assertEquals(1, playerList.size());

    }

}