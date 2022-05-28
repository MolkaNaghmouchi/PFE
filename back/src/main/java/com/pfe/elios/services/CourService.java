package com.pfe.elios.services;



import com.pfe.elios.Repositories.CourRepository;

import com.pfe.elios.entities.Cour;
import com.pfe.elios.entities.CourseDtoResponse;
import com.pfe.elios.entities.Formation;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CourService {
    @Autowired
    private final CourRepository courRepository;


    @Autowired
    private FormationService formationService;
    public CourService(CourRepository courRepository,FormationService formationService) {
        this.formationService =formationService;
        this.courRepository = courRepository;
    }


    public Cour addCour(Cour cour) {

        return courRepository.save(cour);
    }
//filtre map java stream

    //[.......].filtre(user ->   user.payment.status === true )

    // findAllUser = [.....]
    //   var userPayés =  findAllUser.filter( user -> user.payment.etatDePayement === true)
    public List<CourseDtoResponse> findAllCours() {

        var crx = courRepository.findAll().stream().map( cour -> {
            var dtoResponse = new CourseDtoResponse();
            Formation formation = formationService.retrieveFormation(cour.getFormation().getId());
            dtoResponse.setNom_cour(cour.getNom_cour());
            dtoResponse.setNiveau(cour.getNiveau());
            dtoResponse.setIdFormation(cour.getId());
            dtoResponse.setFormationName(formation.getIntituleFormation());
            return dtoResponse;
        } ).collect(Collectors.toList());

        return crx;
    }



    public Cour updateCour(Cour cour) {
        return courRepository.save(cour);
    }
    public Cour findCourById(Long id) {

        return  courRepository.findCourById(id);

    }

    public void deleteCour(Long id) {
        courRepository.deleteCourById(id);
    }

   /* public List<Cour> findByNom_courAndFormationIntituleFormation(String nom_cour, String IntituleFormation) {
        return courRepository.findByNom_courAndFormationIntituleFormation(nom_cour,IntituleFormation);
    }*/
}
