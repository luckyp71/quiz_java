package com.game.quiz.service_impl;

import java.util.Random;

import com.game.quiz.service.MessageService;

public class MessageServiceImpl implements MessageService {

	String[] successMessages = new String[3];
	String[] errorMessages = new String[3];
	int randomIndex = 0;

	public MessageServiceImpl() {
		this.successMessages = new String[] {"BENAR SEKALI!!!!!! Selamat, point anda: ",
											 "TEPAT!!!!! Selamat, point anda: ",
											 "BETUL SEKALI!!!! Selamat, selamat, point anda: ",
											 "TEPAT SEKALI!!!! Selamat, point anda: ",
											 "SANGAT TEPAT!!!! Selamat, point anda: ",
											 "COCOK!!!!!! Selamat, point anda:",
											 "SANGAT COCOK!!!!!! Selamat, selamat, point anda:"};
		
		this.errorMessages = new String[] {"MAAF ANDA SALAH!!!! Silahkan mencoba lagi!!!!!\n",
										   "MOHON MAAF, JAWABAN ANDA INI SALAH!!!! Silahkan mencoba lagi!!!!\n",
										    "ANDA HARUS MENJAWAB DENGAN BENAR!!!!!! Silahkan mencoba lagi!!!!\n",
											"JAWABAN ANDA SANGAT TIDAK TEPAT!!!!!! Silahkan mencoba lagi!!!!\n"};
	}
	
	@Override
	public void onSuccess(int score) {
		randomIndex = new Random().nextInt(successMessages.length);
		System.out.println(successMessages[randomIndex] + score + "!\n");
	}

	@Override
	public String onError() {
		randomIndex = new Random().nextInt(errorMessages.length);
		return errorMessages[randomIndex];
	}
	
}
