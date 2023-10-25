package com.project.mid.VideoGame.controller.DTO;

import jakarta.validation.constraints.NotEmpty;

public class DesignerNameDTO {
    @NotEmpty(message = "ops!! the Name is Empty")
    private String designerName;

    public String getDesignerName() {
        return designerName;
    }

    public DesignerNameDTO() {
    }

    public DesignerNameDTO(String designerName) {
        this.designerName = designerName;
    }
}
