package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Long> {

}
