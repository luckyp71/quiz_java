package com.game.quiz.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.game.quiz.service_impl.CommonServiceImpl;
import com.game.quiz.service_impl.MessageServiceImpl;
import com.game.quiz.service_impl.QuizServiceImpl;

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
				messageService.onError();
				throw new NotMatchException();
			}
			messageService.onSuccess(commonService.getScore());
			counter = counter + 1;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotMatchException ne) {
			this.display(counter);
		}
	}
}