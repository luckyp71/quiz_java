package com.game.quiz;

import com.game.quiz.service_impls.QuizServiceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class QuizServiceImplTest {

	private QuizServiceImpl service = new QuizServiceImpl();
	private List<String> questionList = new ArrayList<>();
	
	@Before
	public void init() {
		questionList.add("home");
		questionList.add("laptop");
		questionList.add("car");
		
		service.addQuestion("home");
		service.addQuestion("car");
		service.addQuestion("laptop");
	}

	@Test
	public void getQuestionsTest() {
		int expectedResult = questionList.size();
		int actualResult = 0;

		if (service.getQustions().size() > 0) {
			actualResult = service.getQustions().size();
		}
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void getQuestionTest() {
		String expectedResult = questionList.get(1);
		String actualResult = service.getQuestion(2);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void addQuestionTest() {
		String expectedResult = "success";
		String actualResult = service.addQuestion("book");
		assertEquals(expectedResult, actualResult);
	}
	
	@After
	public void destroy() {
		questionList.removeAll(questionList);
	}
}