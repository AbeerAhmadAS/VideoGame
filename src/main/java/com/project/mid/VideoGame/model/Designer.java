package com.project.mid.VideoGame.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Designer  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer designerID;
    @Embedded
    DesignerIformation designerIformation;

    public Designer(DesignerIformation designerIformation) {
        this.designerIformation = designerIformation;
    }

    public void setDesignerID(Integer designerID) {
        this.designerID = designerID;
    }

    public DesignerIformation getDesignerIformation() {
        return designerIformation;
    }

    public void setDesignerIformation(DesignerIformation designerIformation) {
        this.designerIformation = designerIformation;
    }
}
