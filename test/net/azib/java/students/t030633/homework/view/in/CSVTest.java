package net.azib.java.students.t030633.homework.view.in;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.Event;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

/**
 * CSVTest
 * 
 * @author t030633
 */
public class CSVTest {

	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
	private static final String COUNTRY = "EE";
	private static final String NAME = "Testname";
	private static final Date DATE = new Date();

	private static int NUMBER = 1; // number of athletes in athlete reading test

	@Test
	public void noInputFileExceptionIsThrown() {
		try {
			new CSV().read();
		}
		catch (IOException e) {
			assertEquals("Input file not specified.", e.getMessage());
		}
	}

	@Test
	public void inputFileNotFoundExceptionIsThrown() {
		try {
			Input csv = new CSV();
			csv.read("NoSuchFileName");
		}
		catch (IOException e) {
			assertEquals("Input file not found.", e.getMessage());
		}
	}

	@Test
	public void athleteIsReadCorrectly() throws Exception {
		BufferedReader mockReader = createMockUserInput(NUMBER, "1", DATE_FORMAT.format(DATE));
		List<Athlete> testList = new CSV(mockReader).read();

		assertTrue(testList.get(0) instanceof Athlete);
		verify(mockReader);
	}

	private BufferedReader createMockUserInput(int times, String result, String date) throws IOException {
		BufferedReader mockReader = createMock(BufferedReader.class);
		StringBuilder csv = new StringBuilder(NAME + "," + date + "," + COUNTRY + ",");
		for (int j = 0; j < Event.values().length; j++) {
			csv.append(result);
			if (j < (Event.values().length - 1))
				csv.append(",");
		}
		for (int i = 0; i < times; i++) {
			expect(mockReader.readLine()).andReturn(csv.toString());
		}
		expect(mockReader.readLine()).andReturn(null); // end of file
		replay(mockReader);
		return mockReader;
	}

}
