package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    void deleteSeanceById(Long id);
    Seance findSeanceById(Long id);
}
