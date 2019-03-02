package com.game.quiz.service_impls;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.game.quiz.models.Quiz;
import com.game.quiz.services.QuizService;

public class QuizServiceImpl implements QuizService {
	
	private List<Quiz> questionList = new ArrayList<>();

	@Override
	public List<String> getQustions() {
		return questionList.stream().map(Quiz::getQuestion).collect(Collectors.toList());
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
