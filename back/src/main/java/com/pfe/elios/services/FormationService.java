package com.pfe.elios.services;


import com.pfe.elios.entities.Formation;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;



public interface FormationService {
	public List<Formation> retrieveAllFormation();
	Formation addFormation(Formation a);
	void deleteFormation(Long id);
	Formation updateFormation(Formation u);
	Formation retrieveFormation(Long id);
	public Formation findFormationById(Long IdFormation);
	//public ResponseEntity<?> UserParticipeFormation(Long IdFormation);


}
