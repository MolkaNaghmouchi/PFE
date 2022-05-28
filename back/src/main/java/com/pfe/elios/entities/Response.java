package com.pfe.elios.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Response {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    String title;
    private  String response;
    @OneToOne(mappedBy = "response")
    Quest_Pro quest_pro;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Quest_Pro getQuest_pro() {
		return quest_pro;
	}
	public void setQuest_pro(Quest_Pro quest_pro) {
		this.quest_pro = quest_pro;
	}
    
    

}
