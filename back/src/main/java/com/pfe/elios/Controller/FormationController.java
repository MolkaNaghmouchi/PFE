package com.pfe.elios.Controller;

import com.pfe.elios.entities.Formation;

import com.pfe.elios.entities.UserTest;
import com.pfe.elios.services.FormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.text.Normalizer;
import java.util.List;

@Transactional

@RestController
public class FormationController {

	@Autowired
	FormationService FormationService;



	// http://localhost:8081/SpringMVC/servlet/GetActivities
	@GetMapping("auth/GetFormations")
	@ResponseBody
	public List<Formation> getFormations() {
		return FormationService.retrieveAllFormation();

	}


	// http://localhost:8081/SpringMVC/servlet/retrieve-user/{user-id}
	@GetMapping("auth/retrieveFormation/{user-id}")
	@ResponseBody
	public Formation retrieveFormation(@PathVariable("user-id") Long userId) {
		return FormationService.retrieveFormation(userId);

	}

	// Ajouter User : http://localhost:8081/SpringMVC/servlet/AddActivity
	//@PostMapping("/AddActivity")
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("auth/AddFormation")
	@ResponseBody
	public String addFormation(@RequestBody Formation u) {
		FormationService.addFormation(u);

		return " Formation added";
	}






	// http://localhost:8081/SpringMVC/servlet/RemoveActivity/{user-id}
	@DeleteMapping("auth/RemoveFormation/{user-id}")
	@ResponseBody
	public void removeFormation(@PathVariable("user-id") Long userId) {
		FormationService.deleteFormation(userId);
	}

	@DeleteMapping("auth/deletee/{id}")
	public ResponseEntity<?> deleteFormation(@PathVariable("id") Long id) {
		FormationService.deleteFormation(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	// http://localhost:8081/SpringMVC/servlet/ModifyActivity
	@PutMapping("auth/ModifyActivity")
	@ResponseBody
	public Formation modifyFormation(@RequestBody Formation Formation) {
		return FormationService.updateFormation(Formation);

	}


   /* @GetMapping(path = "auth/formation/{id}") // localhost:8080/utilisateur/2
    public ResponseEntity<Formation> findFormationById(@PathVariable Long IdFormation) {
        Formation formation = FormationService.findFormationById(IdFormation);

        if (formation == null) {
            return new ResponseEntity<Formation>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Formation>(formation, HttpStatus.OK);
        }
    }*/

	/*@GetMapping("auth/findd/{id}")
     public Optional<Formation> getFormationById (@PathVariable("IdFormation") Long IdFormation) {
         Optional<Formation> formation = FormationService.getFormationById(IdFormation);
         return formation;
     }*/
	@GetMapping(path = "auth/get/{IdFormation}") // localhost:8080/utilisateur/2
	public ResponseEntity<Formation> findFormationById(@PathVariable Long IdFormation) {
		Formation formation =  FormationService.findFormationById(IdFormation);

		if (formation == null) {
			return new ResponseEntity<Formation>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Formation>(formation, HttpStatus.OK);
		}
	}


}







