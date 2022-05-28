package com.pfe.elios.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="Formation")
public class Formation implements Serializable {


	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long Id;

	@Column(name="IntituleFormation")
	private String IntituleFormation;


	@Column(name="Description")
	private String Description;


	@Column(name="TypeFormation")
	private String TypeFormation;

	@Column(name="Prix")
	private String Prix;



	@Column(name="Duree")
	private String Duree;


	@Column(name="Mode")
	private String Mode;

	@Column(name="Debut")
	private String Debut;









	public Formation(String intituleFormation, String description,String mode,String typeFormation,String prix,String duree,
					 String debut) {
		super();
		IntituleFormation = intituleFormation;
		Description = description;
		TypeFormation = typeFormation;
		Prix = prix;
		Duree = duree;
		Mode = mode;
		Debut=debut;


	}
	
	
	
	
	  @ManyToOne(cascade = {CascadeType.PERSIST})
	    private User user;




	@OneToMany(mappedBy ="formation" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})

	private List<Cour> cours = new ArrayList<>();





	public Formation() {
	}


	@OneToMany(mappedBy ="formation" ,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE},fetch = FetchType.EAGER)
	private Set<Seance> seances;


}
