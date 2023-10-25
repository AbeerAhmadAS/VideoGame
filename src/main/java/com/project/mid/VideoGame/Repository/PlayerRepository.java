package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Game;
import com.project.mid.VideoGame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
      List<Player> findByGameByGameName(String gameName);
}
