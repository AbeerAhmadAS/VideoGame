package com.project.mid.VideoGame.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.Repository.PlayerRepository;
import com.project.mid.VideoGame.controller.DTO.GamePriceDTO;
import com.project.mid.VideoGame.controller.DTO.PlayerAgeDTO;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class PlayerControllerTest {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    PlayerRepository playerRepository;


    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    Player player;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        Game game = new Game("test","testing",330,"Pc",null);
        gameRepository.save(game);
        player = new Player("peal","peal@gamil.com", 34 ,  game);
    }

    @AfterEach
    public void tearDown() {
        //gameRepository.deleteById(1);
    }
    @Test
    void getAllPlayer_validRequest_allPlayer() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/player"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("mjd"));
    }
    @Test
    void getPlayerById_validId_correctPlayer() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/player/id/1"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("mjd"));
    }
    @Test
    void getPlayerById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/player/id/99").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }


    //test POST
    @Test
    void savePlayer_validBody_playerSaved() throws Exception {
        String body = objectMapper.writeValueAsString(player);

        mockMvc.perform(post("/api/player").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(playerRepository.findAll().toString().contains("Abeer"));
    }
    //test PUT
    @Test
    void updatePlayer_validBody_playerUpdated() throws Exception {


        player.setPlayerName("George");

        String body = objectMapper.writeValueAsString(player);

        mockMvc.perform(put("/api/player/2").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(playerRepository.findAll().toString().contains("George"));
    }

    @Test
    void updatePlayerAge_validBody_playerUpdated() throws Exception {
        PlayerAgeDTO playerAgeDTO = new PlayerAgeDTO(21);

        String body = objectMapper.writeValueAsString(playerAgeDTO);

        mockMvc.perform(patch("/api/player/playerAge/2").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(playerRepository.findAll().toString().contains("21"));
    }

    @Test
    void deletePlayer_validRequest_playerDeleted() throws Exception {
        Player player1 = new Player("test player", "test@gamil.com", 36,  null);
        playerRepository.save(player1);

        System.out.println(player1);

        mockMvc.perform(delete("/api/player/" + player1.getPlayerID()))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(playerRepository.findAll().toString().contains(player1.getPlayerID().toString()));
    }
}