package com.pfe.elios.services;

import com.pfe.elios.Repositories.SeanceRepository;
import com.pfe.elios.entities.Seance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SeanceService {
    @Autowired
    private final SeanceRepository seanceRepository;

    public SeanceService(SeanceRepository seanceRepository) {


        this.seanceRepository = seanceRepository;
    }

    public Seance addSeance(Seance seance) {

        return seanceRepository.save(seance);
    }


    public List<Seance> findAllSeances() {

        return seanceRepository.findAll();
    }

    public Seance updateSeance(Seance seance) {

        return seanceRepository.save(seance);
    }
    public Seance findSeanceById(Long id) {
        return  seanceRepository.findSeanceById(id);

    }

    public void deleteSeance(Long id) {

        seanceRepository.deleteSeanceById(id);
    }



}

