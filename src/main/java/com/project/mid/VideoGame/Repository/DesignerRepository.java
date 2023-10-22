package com.project.mid.VideoGame.Repository;

import com.project.mid.VideoGame.model.Designer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignerRepository extends JpaRepository<Designer,Integer> {
}
