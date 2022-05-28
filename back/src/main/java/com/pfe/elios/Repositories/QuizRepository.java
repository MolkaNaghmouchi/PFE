package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface QuizRepository extends CrudRepository <Quiz,Long> {
	@Query(value="SELECT * FROM Quiz Order By quiz",nativeQuery =true)
	public List<Quiz> FindQuizSortedByName();
}
