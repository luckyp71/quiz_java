package com.game.quiz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.game.quiz.service_impls.CommonServiceImpl;
import com.game.quiz.service_impls.MessageServiceImpl;
import com.game.quiz.service_impls.QuizServiceImpl;

public class QuizConsole {

	private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	private QuizServiceImpl quizService = new QuizServiceImpl();
	private CommonServiceImpl commonService = new CommonServiceImpl();
	private MessageServiceImpl messageService = new MessageServiceImpl();

	public void start() {
		quizService.addQuestion("book");
		quizService.addQuestion("home");
		quizService.addQuestion("truck");
		quizService.addQuestion("television");
		quizService.addQuestion("radio");
		quizService.addQuestion("division");
		quizService.addQuestion("stock");
		quizService.addQuestion("language");
		quizService.addQuestion("programming");
		quizService.addQuestion("network");
		quizService.addQuestion("neuron");
		quizService.addQuestion("buatan");
		quizService.addQuestion("financial");
		quizService.addQuestion("learning");
		quizService.addQuestion("accountant");

		for (int i = 0; i < quizService.getQustions().size(); i++) {
			display(i);
		}
	}

	public void display(int counter) {
		LogManager.getLogManager().reset();
		Logger logger = LogManager.getLogManager().getLogger("");
		logger.addHandler(new QuizLogHandler());

		try {
			String question = quizService.getQuestion(counter);
			String randomWord = commonService.generateRandomWord(question);

			String tebak = "Guess: " + randomWord + "\nAnswer: ";

			logger.info(tebak);
			String jawab = input.readLine();

			/**
			 * Prevent null pointer exception message raised when we force quit the program
			 ***/
			if (jawab == null) {
				System.exit(0);
			}
			/*********************************************************************************/

			boolean message = commonService.checkAnswer(question, jawab.trim().toLowerCase());
			if (!message) {
				throw new NotMatchException(messageService.onError());
			}
			messageService.onSuccess(commonService.getScore());
		} catch (IOException e) {
			logger.info(e.getLocalizedMessage() + "\n");
		} catch (NotMatchException ne) {
			logger.info(ne.getLocalizedMessage() + "\n");
			this.display(counter);
		}
	}
}