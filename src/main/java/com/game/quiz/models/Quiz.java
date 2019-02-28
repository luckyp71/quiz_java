package com.game.quiz.models;

public class Quiz {

	private String question;
	
	//Default constructor
	public Quiz() {}
	
	//Constructor with question as it param
	public Quiz(String question) {
		this.question = question;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
}
