package com.pfe.elios.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Quiz")
public class Quiz implements Serializable  {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="IdQuiz")
	private Long IdQuiz;
	
	@Column(name="Quiz")
	private String Quiz;
	
	
	@Column(name="Reponse1")
	private String Reponse1;
	
	
	
	@Column(name="Reponse2")
	private String Reponse2;
	
	
	
	@Column(name="Reponse3")
	private String Reponse3;
	
	
	@Column(name="ReponseCorrecte")
	private String ReponseCorrecte;




	public Quiz(Long idQuiz, String quiz, String reponse1, String reponse2, String reponse3, String reponseCorrecte) {
		super();
		IdQuiz = idQuiz;
		Quiz = quiz;
		Reponse1 = reponse1;
		Reponse2 = reponse2;
		Reponse3 = reponse3;
		ReponseCorrecte = reponseCorrecte;
	}
	
	
	
	
	
	public Quiz(String quiz, String reponse1, String reponse2, String reponse3, String reponseCorrecte) {
		super();
		
		Quiz = quiz;
		Reponse1 = reponse1;
		Reponse2 = reponse2;
		Reponse3 = reponse3;
		ReponseCorrecte = reponseCorrecte;
	}

	public Quiz() {
	
	}


	@Override
	public String toString() {
		return "Quiz [IdQuiz=" + IdQuiz + ", Quiz=" + Quiz + ", Reponse1=" + Reponse1 + ", Reponse2=" + Reponse2
				+ ", Reponse3=" + Reponse3 + ", ReponseCorrecte=" + ReponseCorrecte + "]";
	}
	
	
	
	
	
}

