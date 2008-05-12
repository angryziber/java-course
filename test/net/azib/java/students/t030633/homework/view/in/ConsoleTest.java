package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.AthleteBuilder;
import net.azib.java.students.t030633.homework.model.Event;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * ConsoleTest
 * 
 * @author t030633
 */
public class ConsoleTest {

	private static final String COUNTRY = "EE";
	private static final String NAME = "Testname";
	private static final Date DATE = new Date();
	
	private static int NUMBER = 2; // number of athletes in athlete reading test

	@Test
	public void beginMessageIsShown() throws Exception {

		AthleteBuilder mockBuilder = createMockBuilder(0, "1", Console.DF.format(DATE), null);
		BufferedReader mockReader = createMockUserInput(0, "1", Console.DF.format(DATE));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		new Console(new PrintStream(output), mockReader).read(mockBuilder);

		assertEquals(Console.BEGIN_MSG + Console.LN + Console.QUESTION, output.toString());
		verify(mockBuilder);
		verify(mockReader);

	}

	@Test
	public void userMessagesAreShown() throws Exception {

		AthleteBuilder mockBuilder = createMockBuilder(1, "1", Console.DF.format(DATE), createMockAthlete());
		BufferedReader mockReader = createMockUserInput(1, "1", Console.DF.format(DATE));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		new Console(new PrintStream(output), mockReader).read(mockBuilder);

		// User input moves lines forward, therefore some newlines are missing
		String expected = Console.BEGIN_MSG + Console.LN + Console.QUESTION + "Name: " + 
				"Country: " + "Birth date: " + "Results: " + Console.LN;
		StringBuilder sb = new StringBuilder(expected);
		for (Event e : Event.values()) {
			sb.append("\t").append(e.getName()).append(": ");
		}
		expected = sb.append(Console.QUESTION).toString();

		assertEquals(expected, output.toString());
		verify(mockBuilder);
		verify(mockReader);

	}

	@Test
	public void athletesAreReadCorrectly() throws Exception {

		Athlete mockAthlete = createMockAthlete();

		AthleteBuilder mockBuilder = createMockBuilder(NUMBER, "1", Console.DF.format(DATE), mockAthlete);
		BufferedReader mockReader = createMockUserInput(NUMBER, "1", Console.DF.format(DATE));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		List<Athlete> testList = new Console(new PrintStream(output), mockReader).read(mockBuilder);

		List<Athlete> expectedList = new LinkedList<Athlete>();
		for (int i = 0; i < NUMBER; i++)
			expectedList.add(mockAthlete);

		assertEquals(expectedList, testList);

		verify(mockBuilder);
		verify(mockReader);

	}

	@Test
	public void wrongDateFormatMessageIsShown() throws Exception {

		Athlete mockAthlete = createMockAthlete();

		AthleteBuilder mockBuilder = createMockBuilder(1, "1", "wrong date here", mockAthlete);
		BufferedReader mockReader = createMockUserInput(1, "1", "wrong date here");

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		new Console(new PrintStream(output), mockReader).read(mockBuilder);

		// User input moves lines forward, therefore some newlines are missing
		String expected = Console.BEGIN_MSG + Console.LN + Console.QUESTION + "Name: " + "Country: " + 
				"Birth date: " + Console.WRONG_DATE_FORMAT + "Results: " + Console.LN;
		StringBuilder sb = new StringBuilder(expected);
		for (Event e : Event.values()) {
			sb.append("\t").append(e.getName()).append(": ");
		}
		expected = sb.append(Console.QUESTION).toString();
		
		assertEquals(expected, output.toString());
		verify(mockBuilder);
		verify(mockReader);

	}
	
	@Test
	public void wrongResultFormatMessageIsShown() throws Exception {

		Athlete mockAthlete = createMockAthlete();

		AthleteBuilder mockBuilder = createMockBuilder(1, "a", Console.DF.format(DATE), mockAthlete);
		BufferedReader mockReader = createMockUserInput(1, "a",Console.DF.format(DATE));

		ByteArrayOutputStream output = new ByteArrayOutputStream();

		new Console(new PrintStream(output), mockReader).read(mockBuilder);

		// User input moves lines forward, therefore some newlines are missing
		String expected = Console.BEGIN_MSG + Console.LN + Console.QUESTION + "Name: " + "Country: " + 
				"Birth date: " + "Results: " + Console.LN;
		StringBuilder sb = new StringBuilder(expected);
		for (Event e : Event.values()) {
			sb.append("\t").append(e.getName()).append(": ").append(Console.WRONG_RESULT_FORMAT);
		}
		expected = sb.append(Console.QUESTION).toString();
		
		assertEquals(expected, output.toString());
		verify(mockBuilder);
		verify(mockReader);

	}

	private Athlete createMockAthlete() {
		Athlete mockAthlete = createMock(Athlete.class);
		replay(mockAthlete);
		return mockAthlete;
	}

	private BufferedReader createMockUserInput(int times, String result, String date) throws IOException {
		BufferedReader mockReader = createMock(BufferedReader.class);
		for (int i = 0; i < times; i++) {
			expect(mockReader.readLine()).andReturn("y");
			expect(mockReader.readLine()).andReturn(NAME);
			expect(mockReader.readLine()).andReturn(COUNTRY);
			expect(mockReader.readLine()).andReturn(date);
			for (int j = 0; j < Event.values().length; j++) {
				expect(mockReader.readLine()).andReturn(result);
			}
		}
		expect(mockReader.readLine()).andReturn("n");
		replay(mockReader);
		return mockReader;
	}

	private AthleteBuilder createMockBuilder(int times, String result, String date, Athlete mockAthlete) {
		AthleteBuilder mockBuilder = createMock(AthleteBuilder.class);
		for (int i = 0; i < times; i++) {
			expect(mockBuilder.name(NAME)).andReturn(mockBuilder);
			expect(mockBuilder.country(COUNTRY)).andReturn(mockBuilder);
			try {
				expect(mockBuilder.date(Console.DF.parse(date))).andReturn(mockBuilder);
			}
			catch (ParseException e0) {
			}
			for (Event e : Event.values()) {
				try {
					expect(mockBuilder.addResult(e, Double.parseDouble(result))).andReturn(mockBuilder);
				}
				catch (NumberFormatException e1) {
				}
			}
			expect(mockBuilder.build()).andReturn(mockAthlete);
		}
		replay(mockBuilder);
		return mockBuilder;
	}

}
