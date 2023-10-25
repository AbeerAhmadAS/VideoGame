package com.project.mid.VideoGame.controller.Interface;

import com.project.mid.VideoGame.model.Designer;

import java.util.List;

public interface IDedignerController {
    public void saveDesigner( Designer designer);


    public List<Designer> grtAllDesigner();
    public Designer findAllByDesignerIformationDesignerName(String designerName);
}
