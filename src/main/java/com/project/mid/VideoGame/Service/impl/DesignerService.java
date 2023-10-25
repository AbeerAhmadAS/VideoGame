package com.project.mid.VideoGame.Service.impl;

import com.project.mid.VideoGame.Repository.DesignerRepository;
import com.project.mid.VideoGame.Service.Interface.IDesignerService;
import com.project.mid.VideoGame.model.Designer;
import com.project.mid.VideoGame.model.DesignerIformation;
import com.project.mid.VideoGame.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
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
    public Designer findAllByDesignerIformationDesignerName(String designerName) {
        Optional<Designer>designerList=designerRepository.findAllByDesignerIformationDesignerName(designerName);
        if(designerList.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "designer" +designerName + " not found") ;
        return designerList.get();


    }
    @Override
    public void updateDesignerName(String designerName, Integer designerID){
        Optional<Designer>designerOptional=designerRepository.findById(designerID);
        if(designerOptional.isEmpty())throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee " + designerID + " not found") ;
        DesignerIformation designerIformation=designerOptional.get().getDesignerIformation();
        Designer designer=designerOptional.get();
        designerIformation.setDesignerName(designerName);
        designer.setDesignerIformation(designerIformation);
        designerRepository.save(designer);
    }

}
