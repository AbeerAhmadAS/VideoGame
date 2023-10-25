package com.project.mid.VideoGame.controller.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.controller.DTO.DesignerNameDTO;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
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

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DesignerControllerTest {
    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    WebApplicationContext webApplicationContext;

    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();
    Designer designer;
    DesignerIformation designerIfo;
    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        designerIfo=new DesignerIformation("Ali","Ali@gmail.com","KSA");
        designer = new Designer(designerIfo);
    }

    @AfterEach
    public void tearDown() {

 //      designerRepository.deleteById(1);
    }
    @Test
    void getAllDesigner_validRequest_allDesigner() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/designer"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Abeer"));
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Adeel"));
    }
    @Test
    void getDesignerById_validId_correctDesigner() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/api/designer/3"))
                .andExpect(status().isAccepted())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();

        assertTrue(mvcResult.getResponse().getContentAsString().contains("Abeer"));
    }
    @Test
    void getDesignerById_invalidId_notFound() throws Exception {
        mockMvc.perform(get("/api/designer/88").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andReturn();
    }


      //test POST
    @Test
    void saveDesigner_validBody_designerSaved() throws Exception {
        String body = objectMapper.writeValueAsString(designer);

        mockMvc.perform(post("/api/designer").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();

        assertTrue(designerRepository.findAll().toString().contains("Abeer"));
    }
     //test PUT
    @Test
    void updateDesigner_validBody_designerUpdated() throws Exception {
        designerIfo.setDesignerNationality("UML");
        designer.setDesignerIformation(designerIfo);

        String body = objectMapper.writeValueAsString(designer);

        mockMvc.perform(put("/api/designer/4").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(designerRepository.findAll().toString().contains("UML"));
    }

    @Test
    void updateDesignerName_validBody_designerUpdated() throws Exception {
        DesignerNameDTO designerNameDTO = new DesignerNameDTO("Mohammed");

        String body = objectMapper.writeValueAsString(designerNameDTO);

        mockMvc.perform(patch("/api/designer/designerName/4").content(body).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andReturn();

        assertTrue(designerRepository.findAll().toString().contains("Mohammed"));
    }

   @Test
    void deleteDesigner_validRequest_designerDeleted() throws Exception {
        designerRepository.save(designer);

        mockMvc.perform(delete("/api/designer/4"))
                .andExpect(status().isNoContent())
                .andReturn();

        assertFalse(designerRepository.findAll().toString().contains("4"));
    }





}