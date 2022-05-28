package com.pfe.elios.Repositories;


import com.pfe.elios.entities.Formation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends CrudRepository <Formation,Long> {
	@Query(value="SELECT * FROM Formation Order By intitule",nativeQuery =true)
	public List<Formation> FindQuizSortedByFormation();
	
	@Query(value="SELECT user_id FROM user_liste_formation ",nativeQuery =true)
	public List<Integer> FindFormationByUser();
	
	
	@Query(value="SELECT liste_formation_id_formation FROM user_liste_formation where user_id=?1 ",nativeQuery =true)
	public List<Long> FindFormationByUser2(int user_id );
	
}
