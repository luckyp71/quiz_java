package com.game.quiz.service;

public interface MessageService {
	
	// Display success message
	public void onSuccess(int score);

	// Display error message
	public void onError();
}
