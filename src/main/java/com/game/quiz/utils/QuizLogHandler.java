package com.game.quiz.utils;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class QuizLogHandler extends Handler{

	@Override
	public void publish(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		sb.append(record.getMessage());
		System.out.print(sb.toString());
	}

	@Override
	public void flush() {
		// Not used
	}

	@Override
	public void close() {
		// Not used
	}

}
