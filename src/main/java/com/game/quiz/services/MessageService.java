package com.game.quiz.services;

public interface MessageService {
	
	// Display success message
	public void onSuccess(int score);

	// Display error message
	public String onError();
}
