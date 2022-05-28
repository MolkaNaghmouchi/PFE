package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Quest_Pro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestRepository extends JpaRepository<Quest_Pro,Integer> {
   Optional<Quest_Pro> findByTitle(String title);
}
