package com.game.quiz.service;

public interface CommonService {
	
	//Generate Random Word
	public String generateRandomWord(String input);
	
	//Check Answer
	public boolean checkAnswer(String question, String answer);
	
	//Add Score
	public int getScore();

}
