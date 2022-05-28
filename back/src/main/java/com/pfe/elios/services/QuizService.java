package com.pfe.elios.services;

import com.pfe.elios.entities.Quiz;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface QuizService {
	public List<Quiz> retrieveAllQuiz();
	Quiz addQuiz(Quiz a);
	 void deleteQuiz(Long id);
	 Quiz updateQuiz(Quiz u);
	 Quiz retrieveQuiz(Long id);
	 public List<Quiz> FindQuizSortedByName();
	 public ResponseEntity<?> UserParticipeQuiz(Long IdQuiz); 


}
