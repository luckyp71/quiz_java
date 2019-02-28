package com.game.quiz.models;

public class Quiz {

	private String question;
	
	public Quiz() {};
	
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
