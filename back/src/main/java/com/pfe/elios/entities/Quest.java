package com.pfe.elios.entities;

import lombok.Data;

@Data
public class Quest {
    private String title;
    private String question;
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




}
