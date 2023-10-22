package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.controller.Interface.IDedignerController;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesignerController implements IDedignerController {
    @Autowired
    DesignerRepository designerRepository;
    @PostMapping("/designer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveDesigner(@RequestBody Designer designer){
        designerRepository.save(designer);
    }
    @GetMapping("/designer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Designer> grtAllDesigner(){
        return  designerRepository.findAll();
    }

}
