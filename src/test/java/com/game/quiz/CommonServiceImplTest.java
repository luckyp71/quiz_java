package com.game.quiz;

import org.junit.Test;

import com.game.quiz.service_impls.CommonServiceImpl;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class CommonServiceImplTest {

	private CommonServiceImpl service = new CommonServiceImpl();

	@Test
	public void generateRandomWordTest() {
		String input = "mobil";
		char[] inputChars = input.toCharArray();
		Arrays.sort(inputChars);
		String inputString = String.valueOf(inputChars);

		String actualResultString = service.generateRandomWord(input);
		char[] actualResultChars = actualResultString.toCharArray();
		Arrays.sort(actualResultChars);
		String actualResult = String.valueOf(actualResultChars);

		String expectedResult = input;

		if (inputString.equals(actualResult)) {
			expectedResult = actualResult;
		}

		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void checkAnswerTest() {
		boolean expectedResult = true;
		boolean actualResult = service.checkAnswer("buku", "buku");
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test 
	public void getScoreTest() {
		int expectedResult = 1;
		
		this.checkAnswerTest();
		
		int actualResult = service.getScore();
	
		assertEquals(expectedResult, actualResult);
	}
}