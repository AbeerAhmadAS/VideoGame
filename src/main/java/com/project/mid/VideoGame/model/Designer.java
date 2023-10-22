package com.project.mid.VideoGame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Designer {
    @Id
    private Integer designerID;
    @NotEmpty(message = "ops!! the Name is Empty")
    private String designerName;
    @Email(message = "the Email invalid")
    private  String designerEmail;
    private String designerNationality;

    public void setDesignerID(Integer designerID) {
        this.designerID = designerID;
    }
}
