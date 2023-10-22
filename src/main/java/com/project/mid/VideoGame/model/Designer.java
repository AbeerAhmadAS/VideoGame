package com.project.mid.VideoGame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String designerName;
    private  String designerEmail;
    private String designerNationality;
}
