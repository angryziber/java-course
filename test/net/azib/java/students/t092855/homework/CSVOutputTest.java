package net.azib.java.students.t092855.homework;

import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * CSVOutputTest
 *
 * @author t092855
 */
public class CSVOutputTest {

	/**
	 * Unit test for {@link CSVOutput#formatLineCSV(String, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void formattingCSVLineWorksWithMocking() throws ParseException {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse("12.12.1912");
		String dateString = dateFormat.format(date);
		double[] results = {13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,322.75};

		DecathlonEvents decathlonEvents = mock(DecathlonEvents.class);
		when(decathlonEvents.getDecathlonResults()).thenReturn(results);
		when(decathlonEvents.getTotalPoints()).thenReturn(3751);

		Athlete athlete = mock(Athlete.class);
        when(athlete.getBirthday()).thenReturn(date);
		when(athlete.getCountry()).thenReturn("EE");
		when(athlete.getName()).thenReturn("Siim Piim");
		when(athlete.getAthleteEvents()).thenReturn(decathlonEvents);

		String actualString = new CSVOutput().formatLineCSV("1", athlete);
		String expectedString = "1,3751,\"Siim Piim\"," +
				dateString + "," +
				"EE," +
				"13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,322.75";

		assertEquals(expectedString, actualString);
	}

	/**
	 * Unit test for {@link CSVOutput#formatLineCSV(String, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void formattingCSVLineWorks() throws ParseException {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse("12.12.1912");
		String dateString = dateFormat.format(date);

		double[] results = {13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,322.75};
		Athlete athlete = new Athlete();
		athlete.setName("Siim Piim");
		athlete.setBirthday(dateString);
		athlete.setCountry("EE");
		athlete.setDecathlonEvent(new DecathlonEvents(results));

		String actualString = new CSVOutput().formatLineCSV("1", athlete);
		String expectedString = "1,3751,\"Siim Piim\"," +
				dateString + "," +
				"EE," +
				"13.75,4.84,10.12,1.5,68.44,19.18,30.85,2.8,33.88,322.75";

		assertEquals(expectedString, actualString);
	}
}
