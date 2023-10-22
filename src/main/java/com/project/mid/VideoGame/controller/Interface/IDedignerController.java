package com.project.mid.VideoGame.controller.Interface;

import com.project.mid.VideoGame.model.Designer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public interface IDedignerController {
    public void saveDesigner( Designer designer);


    public List<Designer> grtAllDesigner();
}
