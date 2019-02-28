package com.game.quiz.models;

public class Message {
	
	private String success;
	private String error;
	
	//Default constructor
	public Message() {}
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
