package com.pfe.elios.Controller;

import com.pfe.elios.entities.Groupe;
import com.pfe.elios.services.GroupeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth/groupe")
public class GroupeController {
    @Autowired
    private final GroupeService  groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Groupe>> getAllGroupes () {
        List<Groupe> groupes = groupeService.findAllGroupes();
        return new ResponseEntity<>(groupes, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") Long id) {
        Groupe groupe = groupeService.findGroupeById(id);
        return new ResponseEntity<>(groupe, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Groupe> addGroupe(@RequestBody Groupe groupe) {
        Groupe newGroupe = groupeService.addGroupe(groupe);
        return new ResponseEntity<>(newGroupe, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Groupe> updateGroupe(@RequestBody Groupe groupe) {
        Groupe updateGroupe = groupeService.updateGroupe(groupe);
        return new ResponseEntity<>(updateGroupe, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGroupe(@PathVariable("id") Long id) {
        groupeService.deleteGroupe(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

