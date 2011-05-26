package net.azib.java.students.t092855.homework;

import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * InputCSVTest
 *
 * @author t092855
 */
public class InputCSVTest {
	private Athlete athlete;

	@Before
	public void parseCSVToMakeAnAthlete() throws ParseException {
		String line = "\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 ";
		athlete = new InputCSV().parseLine(line);
	}

	/**
	 * Unit test for {@link InputCSV#parseLine(String)}
	 */
	@Test
	public void parseCSVAthleteIsCorrect() {
		assertNotNull(athlete);
		assertEquals("José Mañana Perez", athlete.getName());
		assertEquals("ES", athlete.getCountry());
	}

	/**
	 * Unit test for {@link InputCSV#parseLine(String)}
	 * @throws java.text.ParseException if parsing date fails
	 */
	@Test
	public void parseCSVAthleteBirthdayIsCorrect() throws ParseException {
		SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.MEDIUM);
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse("3.04.1972");
		String dateString = dateFormat.format(date);
		assertEquals(dateString, dateFormat.format(athlete.getBirthday()));
	}

	/**
	 * Unit test for {@link InputCSV#parseLine(String)}
	 */
	@Test
	public void parseCSVAthleteResultsAreCorrect() {
		assertEquals(3494, athlete.getAthleteEvents().getTotalPoints());
		assertEquals(13.75, athlete.getAthleteEvents().getDecathlonResults()[0], 0.0);
		assertEquals(4.84, athlete.getAthleteEvents().getDecathlonResults()[1], 0.0);
		assertEquals(10.12, athlete.getAthleteEvents().getDecathlonResults()[2], 0.0);
		assertEquals(1.50, athlete.getAthleteEvents().getDecathlonResults()[3], 0.0);
		assertEquals(68.44, athlete.getAthleteEvents().getDecathlonResults()[4], 0.0);
		assertEquals(19.18, athlete.getAthleteEvents().getDecathlonResults()[5], 0.0);
		assertEquals(30.85, athlete.getAthleteEvents().getDecathlonResults()[6], 0.0);
		assertEquals(2.8, athlete.getAthleteEvents().getDecathlonResults()[7], 0.0);
		assertEquals(33.88, athlete.getAthleteEvents().getDecathlonResults()[8], 0.0);
		assertEquals(382.75, athlete.getAthleteEvents().getDecathlonResults()[9], 0.0);
	}
}
