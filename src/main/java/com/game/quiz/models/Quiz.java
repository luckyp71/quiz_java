package com.game.quiz.models;

public class Quiz {

	private String question;
	private String answer;
	
	//Default constructor
	public Quiz() {}
	
	public Quiz(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
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
