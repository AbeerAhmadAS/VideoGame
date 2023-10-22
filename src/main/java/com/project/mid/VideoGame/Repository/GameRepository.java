package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {
}
