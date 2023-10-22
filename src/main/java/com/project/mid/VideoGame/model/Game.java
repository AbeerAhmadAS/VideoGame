package com.project.mid.VideoGame.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Game {
    @Id
    private Integer gameID;
    private String gameName;
    private  String gameType;
    private Integer gamePrice;
    private String deviceGameRunningOn;
    @OneToOne
    private Designer designer;

}
