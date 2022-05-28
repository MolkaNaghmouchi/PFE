package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Cour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourRepository extends JpaRepository<Cour, Long> {


    void deleteCourById(Long id);

    Cour findCourById(Long id);



}
