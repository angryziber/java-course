package net.azib.java.questionnaire;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * QuestionTest
 *
 * @author anton
 */
public class QuestionTest {
	private Question q;
	
	@Before
	public void initSimpleQuestion() {
		q = new Question(1, "Hello?");
	}
	
	@Test
	public void editBoxQuestion() throws Exception {
		q.answers.add("World");		
		assertFalse(q.isChoice());
	}
	
	@Test
	public void checkboxQuestion() throws Exception {
		q.correct.add("World1");
		q.correct.add("World2");
		assertFalse(q.isSingleAnswer());
	}
	
	@Test
	public void radioButtonQuestion() throws Exception {
		q.correct.add("World");
		assertTrue(q.isSingleAnswer());
	}
}
