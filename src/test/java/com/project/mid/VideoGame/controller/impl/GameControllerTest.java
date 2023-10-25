package com.project.mid.VideoGame.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Repository.GameRepository;
import com.project.mid.VideoGame.controller.DTO.DesignerNameDTO;
import com.project.mid.VideoGame.controller.DTO.GamePriceDTO;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import com.project.mid.VideoGame.model.Game;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
class GameControllerTest {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    DesignerRepository designerRepository;


    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    Game game;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        DesignerIformation designerIformation = new DesignerIformation("test", "test@test.com", "England");
        Designer designer = new Designer(designerIformation);
        designerRepository.save(designer);
        game = new Game("Code", "action", 380, "PC", designer);
    }

    @AfterEach
    public void tearDown() {
        //gameRepository.deleteById(1);
    }
    @Test
    void grtAllGames_validRequest_allGame() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/games"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Hay Day"));
        //assertTrue(mvcResult.getResponse().getContentAsString().contains("Adeel"));
    }
    @Test
    void getGameById_validId_correctGame() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/games/id/3"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Hay Day"));
    }
    @Test
    void getGameById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/games/id/99").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }


    //test POST
    @Test
    void saveGames_validBody_gamesSaved() throws Exception {
        String body = objectMapper.writeValueAsString(game);

        mockMvc.perform(post("/api/games").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(gameRepository.findAll().toString().contains("Hay Day"));
    }
    //test PUT
  @Test
    void updateGame_validBody_gameUpdated() throws Exception {


        game.setGameName("Car race");

        String body = objectMapper.writeValueAsString(game);

        mockMvc.perform(put("/api/games/2").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(gameRepository.findAll().toString().contains("Car race"));
    }

    @Test
    void updateGamePrice_validBody_gameUpdated() throws Exception {
        GamePriceDTO gamePriceDTO = new GamePriceDTO(300);

        String body = objectMapper.writeValueAsString(gamePriceDTO);

        mockMvc.perform(patch("/api/games/gamePrice/2").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(gameRepository.findAll().toString().contains("300"));
    }

    @Test
    void deleteGame_validRequest_gameDeleted() throws Exception {
        Game myGame = new Game("test game", "Action", 100, "X-box", null);
        gameRepository.save(myGame);

        System.out.println(myGame);

        mockMvc.perform(delete("/api/games/" + myGame.getGameID()))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(gameRepository.findAll().toString().contains(myGame.getGameID().toString()));
    }



}