package com.pfe.elios.Controller;
import com.pfe.elios.entities.Seance;
import com.pfe.elios.services.SeanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/seance")
public class SeanceController {

    @Autowired
    private final SeanceService seanceService;

    public SeanceController(SeanceService seanceService) {
        this.seanceService = seanceService;
    }
    @PostMapping("/add")
    public ResponseEntity<Seance> addSeance(@RequestBody Seance seance) {
        Seance newSeance = seanceService.addSeance(seance);
        return new ResponseEntity<>(newSeance, HttpStatus.CREATED);
    }





    @GetMapping("/all")
    public ResponseEntity<List<Seance>> getAllSeances () {
        List<Seance> seances = seanceService.findAllSeances();
        return new ResponseEntity<>(seances, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Seance> getSeanceById (@PathVariable("id") Long id) {
        Seance seance = seanceService.findSeanceById(id);
        return new ResponseEntity<>(seance, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Seance> updatSeance(@RequestBody Seance seance) {
        Seance updateSeance =seanceService.updateSeance(seance);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSeance(@PathVariable("id") Long id) {
        seanceService.deleteSeance(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}


