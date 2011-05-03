package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.DecathlonEvent;
import net.azib.java.students.t073756.homework.validator.ResultValidator;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ConsoleProcessorTest {

	private ConsoleProcessor processor;

	@Test
	public void testQuestionsInPlace() throws Exception {
		processor = new ConsoleProcessor(null);
		assertEquals(13, processor.questionsWithRegexp.size());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCantRemoveQuestion() throws Exception {
		processor = new ConsoleProcessor(null);
		processor.questionsWithRegexp.clear();
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testCantAddQuestion() throws Exception {
		processor = new ConsoleProcessor(null);
		processor.questionsWithRegexp.put("new question", ResultValidator.NAME_VALIDATOR);
	}

	@Test
	public void testReadsAnswerFromReader() throws Exception {
		processor = new ConsoleProcessor(new BufferedReader(new StringReader("test answer")));
		assertEquals("test answer", processor.askQuestion(null));
	}

	@Test
	public void testShouldCreateAthlete() throws Exception {
		BufferedReader reader = mock(BufferedReader.class);

		when(reader.readLine()).thenAnswer(new Answer<String>() {
			Iterator<String> it =
					Arrays.asList(("Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50," +
							"59.39,16.43,21.60,2.60,35.81,5:25.72,no").split(",")).iterator();

			public String answer(InvocationOnMock invocationOnMock) {
				return it.next();
			}
		});

		processor = new ConsoleProcessor(reader);

		List<Athlete> athletes = processor.readAthletes();

		assertEquals(1, athletes.size());
		Athlete a = athletes.iterator().next();
		assertEquals("Siim Susi", a.getName());
		assertEquals("5:25.72", a.getResult().getResults().get(DecathlonEvent.M_1500));

		verify(reader, times(14)).readLine();
	}

}
