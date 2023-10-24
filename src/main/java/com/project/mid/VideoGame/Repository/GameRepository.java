package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Integer> {
    //Optional<Player>findGameByName(String gameName);

    //List<Game> findByDeviceGameRunningOn(String deviceGameRunningOn);
}
