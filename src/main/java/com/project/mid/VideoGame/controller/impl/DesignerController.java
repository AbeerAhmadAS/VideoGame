package com.project.mid.VideoGame.controller.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Service.Interface.IDesignerService;
import com.project.mid.VideoGame.controller.Interface.IDedignerController;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.Game;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DesignerController implements IDedignerController {
    @Autowired
    DesignerRepository designerRepository;
    @Autowired
    IDesignerService iDesignerService;
    /////////////////////////POST////////////////////////////////////////
    @PostMapping("/designer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void saveDesigner(@RequestBody @Valid Designer designer){
        designerRepository.save(designer);
    }
    ////////////////////////GET///////////////////////////////////////////
    //GET BY ALL DESIGNER
    @GetMapping("/designer")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Designer> grtAllDesigner(){
        return  designerRepository.findAll();
    }
    //GET BY ID
    @GetMapping("/designer/{designerID}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Designer getDesignerById(@PathVariable Integer designerID){
        return iDesignerService.getDesignerById(designerID);
    }
    //BY NAME OF GAME RETURN THE OF DESIGNER

    /////////////////////////////PUT//////////////////////////////////////////////
    @PutMapping("/designer/{designerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDesigner(@RequestBody @Valid Designer designer, @PathVariable Integer designerID) {
        iDesignerService.updateDesigner(designer, designerID);
    }
    /////////////////////////////////DELETE////////////////////////////////////////////////////
    @DeleteMapping("/designer/{designerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDesigner(@PathVariable Integer designerID) {
        iDesignerService.deleteDesigner(designerID);
    }

}
