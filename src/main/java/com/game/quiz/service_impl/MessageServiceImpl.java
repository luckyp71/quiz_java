package com.game.quiz.service_impl;

import com.game.quiz.service.MessageService;

public class MessageServiceImpl implements MessageService {

	@Override
	public void onSuccess(int score) {
		System.out.println("BENAR SEKALI!!!!!! Selamat, point anda: " + score + "!\n");
	}

	@Override
	public void onError() {
		System.out.println("MAAF ANDA SALAH!!!! Silahkan mencoba lagi!!!!!\n");
	}
	
}
