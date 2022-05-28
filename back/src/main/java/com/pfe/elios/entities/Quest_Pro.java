package com.pfe.elios.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="ques")
public class Quest_Pro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_Quest;
    private String title;
    private String question;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    private User user;
    @OneToOne(cascade={CascadeType.REMOVE})
    Response response;
	public int getId_Quest() {
		return id_Quest;
	}
	public void setId_Quest(int id_Quest) {
		this.id_Quest = id_Quest;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Response getResponse() {
		return response;
	}
	public void setResponse(Response response) {
		this.response = response;
	}





}
