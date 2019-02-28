package com.game.quiz.service_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.game.quiz.models.Quiz;
import com.game.quiz.service.QuizService;

public class QuizServiceImpl implements QuizService {

	List<Quiz> questionList = new ArrayList<>();

	@Override
	public List<String> getQustions() {
		List<String> output = questionList.stream().map(i -> i.getQuestion()).collect(Collectors.toList());
		return output;
	}

	@Override
	public String getQuestion(int index) {
		Quiz quiz = questionList.get(index);
		return quiz.getQuestion();
	}
	
	@Override
	public String addQuestion(String question) {
		questionList.add(new Quiz(question));
		return "success";
	}
}