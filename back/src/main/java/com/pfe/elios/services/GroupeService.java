package com.pfe.elios.services;



import com.pfe.elios.Repositories.GroupeRepository;
import com.pfe.elios.entities.Groupe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class GroupeService {
    @Autowired
    private final GroupeRepository groupeRepository;

    @Autowired
    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public Groupe addGroupe(Groupe groupe) {

        return groupeRepository.save(groupe);
    }

    public List<Groupe> findAllGroupes() {
        return groupeRepository.findAll();
    }

    public Groupe updateGroupe(Groupe groupe ){
        return groupeRepository.save(groupe);
    }

    public Groupe findGroupeById(Long id) {
        return  groupeRepository.findGroupeById(id);

    }

    public void deleteGroupe(Long id){
        groupeRepository.deleteGroupeById(id);
    }
}
