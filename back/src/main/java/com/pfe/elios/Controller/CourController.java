package com.pfe.elios.Controller;


import com.pfe.elios.Repositories.CourRepository;
import com.pfe.elios.Repositories.FormationRepository;
import com.pfe.elios.entities.*;

import com.pfe.elios.services.CourService;

import com.pfe.elios.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;


@RestController
@RequestMapping("auth/cour")
public class CourController {
    @Autowired
    private final CourService courService;
    @Autowired
    private  final CourRepository courRepository;
    @Autowired
    private  final FormationRepository formationRepository;
    @Autowired
    private  final FormationService formationService;
    public CourController(CourService courService, CourRepository courRepository, FormationRepository formationRepository, FormationService formationService) {
        this.courService = courService;
        this.courRepository = courRepository;
        this.formationRepository = formationRepository;
        this.formationService = formationService;
    }


  @PostMapping("/add")
    public ResponseEntity<Cour> addCour(@RequestBody DtoCour dtoCour ) {
        // Cour newCour = courService.addCour(cour);
        //return new ResponseEntity<>( HttpStatus.CREATED);
        Formation formation = formationService.findFormationById(dtoCour.getIdFormation());
        var newCour =new Cour();
        newCour.setNom_cour(dtoCour.getNom_cour());
        newCour.setNiveau(dtoCour.getNiveau());
        newCour.setFormation(formation);

        var crs = formation.getCours();
        crs.add(newCour);
        Cour peristedCour = courService.addCour(newCour);



        return new ResponseEntity<>(peristedCour, HttpStatus.CREATED);
    }


    @GetMapping("/all")
    public ResponseEntity<List<CourseDtoResponse>> getAllCours() {
        List<CourseDtoResponse> cours = courService.findAllCours();

        return new ResponseEntity<>(cours, HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Cour> updateCour(@RequestBody Cour cour) {
        Cour updateCour =courService.updateCour(cour);
        return new ResponseEntity<>(updateCour, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCour(@PathVariable("id") Long id) {
        courService.deleteCour(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("auth/find/{id}")
    public ResponseEntity<Cour> getCourById (@PathVariable("id") Long id) {
        Cour cour = courService.findCourById(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
   /* @GetMapping(path = "/findBynom_courAndIntituleFormation{nom_cour}/{IntituleFormation}")
    public ResponseEntity<List<Cour>> findByNom_courAndFormationIntituleFormation(@PathVariable String nom_cour,
                                                                           @PathVariable String IntituleFormation) {
        List<Cour> cours = courService.findByNom_courAndFormationIntituleFormation(nom_cour, IntituleFormation);

        if (cours.isEmpty()) {
            return new ResponseEntity<List<Cour>>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Cour>>(cours, HttpStatus.OK);
        }
    }*/
  /* @GetMapping("/gets/{course_id}")
   public List<Formation> getFormationCour(@PathVariable Long course_id) {
       List<Formation> Formations = formationRepository.findAll();
       List<Formation> listFormations = new ArrayList<>();
       Cour cour =courRepository.findOne(course_id);
       for (Formation formation : formations) {
           if (formation.getCour() == cour) {
               listFormations.add(formation);
           }
       }
       return listFormations;
       //Maven: org.springframework.data:spring-data-commons:2.6.4 (spring-data-commons-2.6.4.jar)*/
}



