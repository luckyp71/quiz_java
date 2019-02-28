package com.game.quiz.service;

import java.util.List;

public interface QuizService {
	
	//Get questions
	public List<String> getQustions();
	
	//Get single question
	public String getQuestion(int index);
	
	//Add new question
	public String addQuestion(String quiz);
	
}
