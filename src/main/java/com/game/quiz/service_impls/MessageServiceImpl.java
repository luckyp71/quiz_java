package com.game.quiz.service_impls;

import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.game.quiz.services.MessageService;

public class MessageServiceImpl implements MessageService {

	private String[] successMessages = new String[3];
	private String[] errorMessages = new String[3];
	private int randomIndex = 0;
	private static final Logger logger = Logger.getLogger(MessageServiceImpl.class.getName());

	public MessageServiceImpl() {
		this.successMessages = new String[] { "YOU ARE CORRECT!!!!!! Congrats, your point: ",
				"Right!!!!! Congrats, your point: ", "Absolutely Right!!!! Congrats, congrats, your point: ",
				"YOU GOT THAT RIGHT!!!! Congrats, your point: ", "VERY AWESOME!!!! Congrats, your point: ",
				"MATCH!!!!!! Congrats, your point: ", " AWESOME!!!!!! Congrats, congrats, congrats, your point: " };

		this.errorMessages = new String[] { "YOU WRONG!!!! Please try again!!!!!\n",
				"SORRY, YOUR ANSWER IS EXTREMELY WRONG!!!! Please try again!!!!\n",
				"YOU MUST ANSWER CORRECTLY!!!!!! Please try again!!!!\n",
				"YOUR ANSWER IS ABSOLUTELY WRONG!!!!!! Please try again!!!!\n" };
	}

	@Override
	public void onSuccess(int score) {
		randomIndex = new SecureRandom().nextInt(successMessages.length);
		logger.log(Level.INFO, () -> successMessages[randomIndex]+score + "!\n\n"); 
	}

	@Override
	public String onError() {
		randomIndex = new SecureRandom().nextInt(errorMessages.length);
		return errorMessages[randomIndex];
	}

}
