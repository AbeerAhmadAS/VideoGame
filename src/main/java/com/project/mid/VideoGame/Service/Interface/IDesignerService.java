package com.project.mid.VideoGame.Service.Interface;

import com.project.mid.VideoGame.model.Designer;

public interface IDesignerService {
    public Designer getDesignerById(Integer designerID);
    public void updateDesigner( Designer designer, Integer designerID);
    public void deleteDesigner(Integer designerID);
}
