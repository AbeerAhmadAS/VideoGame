package com.project.mid.VideoGame.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor

@Data
public class DesignerIformation {

    @NotEmpty(message = "ops!! the Name is Empty")
    private String designerName;
    @Email(message = "the Email invalid")
    private  String designerEmail;
    private String designerNationality;

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public void setDesignerNationality(String designerNationality) {
        this.designerNationality = designerNationality;
    }

    public String getDesignerName() {
        return designerName;
    }

    public DesignerIformation(String designerName, String designerEmail, String designerNationality) {
        this.designerName = designerName;
        this.designerEmail = designerEmail;
        this.designerNationality = designerNationality;
    }
}
