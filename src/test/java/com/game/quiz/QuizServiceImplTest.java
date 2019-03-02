package com.game.quiz;

import org.junit.Test;

import com.game.quiz.service_impls.QuizServiceImpl;

import static org.junit.Assert.assertEquals;

public class QuizServiceImplTest {
	
	QuizServiceImpl service = new QuizServiceImpl();
	
	//Constructor
	public QuizServiceImplTest() {
		service.addQuestion("home");
		service.addQuestion("car");
		service.addQuestion("laptop");
	}
	
	@Test
	public void getQuestionsTest() {
		boolean expectedResult = true;
		boolean actualResult = false;

		if (service.getQustions().size() == 3) {
			actualResult = true;
		}
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void getQuestionTest() {
		String expectedResult = "laptop";
		String actualResult = service.getQuestion(2);
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void addQuestionTest() {
		String expectedResult = "success";
		String actualResult = service.addQuestion("book");
		assertEquals(expectedResult, actualResult);
	}
}