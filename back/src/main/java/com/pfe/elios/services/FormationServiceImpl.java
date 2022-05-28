package com.pfe.elios.services;


import com.pfe.elios.Repositories.FormationRepository;
import com.pfe.elios.Repositories.UserRepository;
import com.pfe.elios.entities.Formation;
import com.pfe.elios.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormationServiceImpl implements FormationService{

	@Autowired
	FormationRepository FormationRepository;

	@Autowired
	UserRepository UserRepository;


	@Override
	public List<Formation> retrieveAllFormation() {
		return 	(List<Formation>) FormationRepository.findAll();
	}

	@Override
	public Formation addFormation(Formation a) {
		return FormationRepository.save(a);
	}

	@Override
	public void deleteFormation(Long id) {
		FormationRepository.deleteById(id);
	}

	@Override
	public Formation updateFormation(Formation u) {
		return FormationRepository.save(u);

	}

	@Override
	public Formation retrieveFormation(Long id) {
		return FormationRepository.findById(id).get();
	}

	@Override
	public Formation findFormationById(Long IdFormation) {
		Optional<Formation> utOptional = FormationRepository.findById(IdFormation);

		if (utOptional.isEmpty()) {
			return null;
		} else {
			return utOptional.get();
		}

	}

	/*@Override
	public ResponseEntity<?> UserParticipeFormation(Long IdFormation) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User user = UserRepository.findByUserName(username).get();

		Formation formation=FormationRepository.findById(IdFormation).get();

		user.get().add(formation);

		UserRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);

	}
*/







}
