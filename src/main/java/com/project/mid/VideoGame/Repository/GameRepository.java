package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    //Optional<Player>findGameByName(String gameName);

    List<Game> findAllByDeviceGameRunningOn(String deviceGameRunningOn);
    List<Game> findByDesignByDesignerIformationDesignerName(String designerName);
}
