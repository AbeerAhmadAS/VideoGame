package com.project.mid.VideoGame.Service.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Service.Interface.IDesignerService;
import com.project.mid.VideoGame.model.Designer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class DesignerService implements IDesignerService {
    @Autowired
    DesignerRepository designerRepository;
    @Override
    public Designer getDesignerById(Integer designerID){
        Optional<Designer> designerOptional=designerRepository.findById(designerID);
        if(designerOptional.isEmpty())return  null;
        return designerOptional.get();

    }
    @Override
    public void updateDesigner( Designer designer, Integer designerID){
        Optional<Designer> designerOptional=designerRepository.findById(designerID);
        if(designerOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "patient " + designerID + " not found") ;
        designer.setDesignerID(designerID);
        designerRepository.save(designer);

    }
    @Override
    public void deleteDesigner(Integer designerID) {
        Optional<Designer> designerOptional = designerRepository.findById(designerID);
        if (designerOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course " + designerID + " not found");
        designerRepository.deleteById(designerID);
    }

}
