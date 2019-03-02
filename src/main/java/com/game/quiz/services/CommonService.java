package com.game.quiz.services;

public interface CommonService {
	
	//Generate Radom Word from Input
	public String generateRandomWord(String input);
	
	//Check wheter the answer equals to question
	public boolean checkAnswer(String question, String answer);
	
	//Get score when user answer correctly
	public int getScore();

}
