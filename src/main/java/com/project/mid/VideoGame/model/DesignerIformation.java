package com.project.mid.VideoGame.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DesignerIformation {

    @NotEmpty(message = "ops!! the Name is Empty")
    private String designerName;
    @Email(message = "the Email invalid")
    private  String designerEmail;
    private String designerNationality;
}
