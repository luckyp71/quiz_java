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
		this.successMessages = new String[] { "BENAR SEKALI!!!!!! Selamat, point anda: ",
				"TEPAT!!!!! Selamat, point anda: ", "BETUL SEKALI!!!! Selamat, selamat, point anda: ",
				"TEPAT SEKALI!!!! Selamat, point anda: ", "SANGAT TEPAT!!!! Selamat, point anda: ",
				"COCOK!!!!!! Selamat, point anda: ", "SANGAT COCOK!!!!!! Selamat, selamat, point anda: " };

		this.errorMessages = new String[] { "MAAF ANDA SALAH!!!! Silahkan mencoba lagi!!!!!\n",
				"MOHON MAAF, JAWABAN ANDA INI SALAH!!!! Silahkan mencoba lagi!!!!\n",
				"ANDA HARUS MENJAWAB DENGAN BENAR!!!!!! Silahkan mencoba lagi!!!!\n",
				"JAWABAN ANDA SANGAT TIDAK TEPAT!!!!!! Silahkan mencoba lagi!!!!\n" };
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
