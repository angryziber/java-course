package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.Athlete;
import net.azib.java.students.t073756.homework.TestHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.PrintStream;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

public class ConsoleOutputTest {
	private final StringBuffer result = new StringBuffer();
	private String expectedOutput = "  5| 5000|Siim Susi      |01. 1.1976|EE|12.61   |5.00    |9.22    " +
			"|1.50    |59.39   |16.43   |21.60   |2.60    |35.81   |5:25.72 |";

	@Before
	public void setUp() throws Exception {
		PrintStream out = mockOut();
		System.setOut(out);
	}

	@Test
	public void testOutput() throws Exception {
		new ConsoleOutput().writeAthletes(TestHelper.createAthleteList());

		assertEquals(expectedOutput, result.toString());
	}

	@Test
	public void testLongAthleteName() throws Exception {
		Athlete a = TestHelper.createAthlete();
		a.setName("Siim Susi Siim Susi Siim Susi");

		new ConsoleOutput().writeAthletes(Arrays.asList(a));

		assertEquals("  5| 5000|Siim Susi Si...|01. 1.1976|EE|12.61   |5.00    |9.22    " +
				"|1.50    |59.39   |16.43   |21.60   |2.60    |35.81   |5:25.72 |", result.toString());
	}

	@After
	public void tearDown() throws Exception {
		result.delete(0, result.length());
	}

	private PrintStream mockOut() {
		PrintStream out = mock(PrintStream.class);

		doAnswer(new Answer() {
			@Override
			public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
				result.append(invocationOnMock.getArguments()[0]);
				return null;
			}
		}).when(out).println(anyString());

		return out;
	}
}
