package com.game.quiz.utils;

public class NotMatchException extends Exception {

	private static final long serialVersionUID = 1L;
	
	//Default constructor
	public NotMatchException() {}

	public NotMatchException(String message) {
		super(message);
	}

	public NotMatchException(Throwable cause) {
		super(cause);
	}

	public NotMatchException(String message, Throwable cause) {
		super(message, cause);
	}
}
