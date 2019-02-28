package com.game.quiz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import com.game.quiz.service_impl.CommonServiceImpl;
import com.game.quiz.service_impl.QuizServiceImpl;

public class QuizConsole {

	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	QuizServiceImpl quizService = new QuizServiceImpl();
	CommonServiceImpl commonService = new CommonServiceImpl();
	Logger logger = Logger.getLogger(QuizConsole.class.getName());
	
	public void start() {
		
		quizService.addQuestion("buku");
		quizService.addQuestion("rumah");
		quizService.addQuestion("mobil");
		
		for (int i = 0; i < quizService.getQustions().size(); i++) {
			display(i);
		}
	}
	
	public void display(int counter) {
		try {
			String question = quizService.getQuestion(counter);
			String randomWord = commonService.generateRandomWord(question);
			
			String tebak = "Tebak: " + randomWord + "\nJawab: ";
			System.out.print(tebak);
			
			String jawab = input.readLine();
				
			boolean message = commonService.checkAnswer(question, jawab.trim());
			if (!message) {
				logger.info("Jawaban anda salah, aduh sayang sekali\n");
				throw new IOException();
			}
			logger.info("Jawaban anda benar sekali, selamat!!!\nScore: "+commonService.getScore()+"\n");
			counter=counter+1;
		} catch (IOException e) {
			this.display(counter);
		}
	}
}
