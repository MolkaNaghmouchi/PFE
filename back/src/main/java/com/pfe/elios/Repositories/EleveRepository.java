package com.pfe.elios.Repositories;

import com.pfe.elios.entities.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {


}
