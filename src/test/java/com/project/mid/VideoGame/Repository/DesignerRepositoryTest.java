package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DesignerRepositoryTest {
    @Autowired
    DesignerRepository designerRepository;
    DesignerIformation designerIformation=new DesignerIformation("Ahmad","Ahmad@gmail.com","KSA");
    Designer designer=new Designer(designerIformation);
    @BeforeEach
    public void setUp() {designerRepository.save(designer);}
    @AfterEach
    public void tearDown(){ designerRepository.delete(designer);}
    @Test
    public void findAllByDesignerIformationDesignerName() {
        String designerName = "Ahmad";
        Optional<Designer> designerOptional = designerRepository.findAllByDesignerIformationDesignerName(designerName);
        assertTrue(designerOptional.isPresent());
        System.out.println(designerOptional.get());
        assertEquals(designerName, designerOptional.get().getDesignerIformation().getDesignerName());
    }




}