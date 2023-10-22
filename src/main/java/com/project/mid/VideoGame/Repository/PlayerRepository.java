package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
}
