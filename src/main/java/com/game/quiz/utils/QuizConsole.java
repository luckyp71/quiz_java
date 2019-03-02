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

	BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	QuizServiceImpl quizService = new QuizServiceImpl();
	CommonServiceImpl commonService = new CommonServiceImpl();
	MessageServiceImpl messageService = new MessageServiceImpl();

	public void start() {
		quizService.addQuestion("buku");
		quizService.addQuestion("rumah");
		quizService.addQuestion("truk");
		quizService.addQuestion("nampan");
		quizService.addQuestion("televisi");
		quizService.addQuestion("radio");
		quizService.addQuestion("divisi");
		quizService.addQuestion("dividen");
		quizService.addQuestion("saham");
		quizService.addQuestion("bahasa");
		quizService.addQuestion("pemrograman");
		quizService.addQuestion("jaringan");
		quizService.addQuestion("saraf");
		quizService.addQuestion("buatan");
		quizService.addQuestion("keuangan");
		quizService.addQuestion("otomatisasi");
		quizService.addQuestion("proses");
		quizService.addQuestion("teknokrat");
		quizService.addQuestion("teknokratik");
		quizService.addQuestion("cendekiawan");
		quizService.addQuestion("latihan");
		quizService.addQuestion("belajar");
		quizService.addQuestion("dokter");
		quizService.addQuestion("akuntan");

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

			String tebak = "Tebak: " + randomWord + "\nJawab: ";

			logger.info(tebak);
			String jawab = input.readLine();

			/**
			 * Prevent null pointer exception message raised when we force quit the program
			 ***/
			if (jawab == null) {
				System.exit(0);
			}
			/*********************************************************************************/

			boolean message = commonService.checkAnswer(question, jawab.trim());
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