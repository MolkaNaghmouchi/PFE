package com.pfe.elios.services;


import com.pfe.elios.Repositories.QuizRepository;
import com.pfe.elios.Repositories.UserRepository;
import com.pfe.elios.entities.Quiz;
import com.pfe.elios.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuizServiceImpl implements QuizService{

	 @Autowired
	 QuizRepository QuizRepository;
	 
	 
	 @Autowired
	UserRepository UserRepository;
	 
	@Override
	public List<Quiz> retrieveAllQuiz() {
	return	(List<Quiz>) QuizRepository.findAll();
	}


	@Override
	public Quiz addQuiz(Quiz a) {
		return QuizRepository.save(a);
	}

	@Override
	public void deleteQuiz(Long id) {
		QuizRepository.deleteById(id);
	}

	@Override
	public Quiz updateQuiz(Quiz u) {
		return QuizRepository.save(u);

	}

	@Override
	public Quiz retrieveQuiz(Long id) {
return QuizRepository.findById(id).get();
	}

	@Override
	public List<Quiz> FindQuizSortedByName() {
	 		return QuizRepository.FindQuizSortedByName();

	}

	@Override
	public ResponseEntity<?> UserParticipeQuiz(Long IdQuiz) {
	
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User user = UserRepository.findByUserName(userName).get();
        
        Quiz quiz=QuizRepository.findById(IdQuiz).get();
        
        user.getListeQuiz().add(quiz);
        
        UserRepository.save(user);
		return new ResponseEntity<>(user,HttpStatus.ACCEPTED);
		
		
	}

}
