package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Groupe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    void deleteGroupeById(Long id);

    Groupe findGroupeById(Long id);
}
