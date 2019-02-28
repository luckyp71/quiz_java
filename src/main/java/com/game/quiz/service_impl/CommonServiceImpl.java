package com.game.quiz.service_impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.game.quiz.service.CommonService;

public class CommonServiceImpl implements CommonService{
	
	private int score = 0;
	
	@Override
	public String generateRandomWord(String input) {
		String output;
		List<Integer> indexes = new ArrayList<>();
		char[] chars = new char[input.length()];

		for (int i = 0; i < input.length(); i++) {
			int rand = new Random().nextInt(input.length());
			while (indexes.contains(rand)) {
				rand = new Random().nextInt(input.length());
			}
			indexes.add(rand);
		}
		for (int i = 0; i < indexes.size(); i++) {
			chars[i] = input.charAt(indexes.get(i));
		}
		output = String.valueOf(chars);
		return output;
	}
	
	@Override
	public boolean checkAnswer(String question, String answer) {
		boolean output = false;
		if(question.equals(answer)) {
			output = true;
			score++;
		}
		return output;
	}

	@Override
	public int getScore() {
		return score;
	}
}
