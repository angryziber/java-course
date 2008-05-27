package net.azib.java.students.t010588.homework;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 * Tests if information has no changes inside of Athlete class
 *
 * @author Vjatseslav Rosin, 010588
 */
public class AthleteTest {

	private static final String NAME = "Bobby Miller";

	private static final Date BIRTHDAY = new Date(100000000000l);

	private static final char[] COUNTRY = new char[] { 'E', 'E' };

	private static final int FIRSTPLACE = 5;

	private static final int LASTPLACE = 6;

	private static final int SCORE = 8000;

	private static final Result[] RESULTS = new Result[] { new RunningEventResult(0, 11.07f), new FieldEventResult(1, 6.42f),
			new FieldEventResult(2, 6f), new FieldEventResult(3, 1.75f), new RunningEventResult(4, 50.47f),
			new RunningEventResult(5, 13.5f), new FieldEventResult(6, 40f), new FieldEventResult(7, 4.0f),
			new FieldEventResult(8, 60f), new RunningEventResult(9, 4 * 60 + 20) };

	@Test
	public void testAthlete() {
		Athlete athlete = new Athlete();
		athlete.setName(NAME);
		athlete.setBirhday(BIRTHDAY);
		athlete.setCountry(COUNTRY);
		athlete.setFirstPlace(FIRSTPLACE);
		athlete.setLastPlace(LASTPLACE);
		athlete.setResults(RESULTS);
		athlete.setScore(SCORE);

		assertEquals(NAME, athlete.getName());
		assertEquals(BIRTHDAY, athlete.getBirhday());
		assertEquals(COUNTRY, athlete.getCountry());
		assertEquals(FIRSTPLACE, athlete.getFirstPlace());
		assertEquals(LASTPLACE, athlete.getLastPlace());

		System.out.println(BIRTHDAY);

		Result[] results = athlete.getResults();

		for (int i = 0; i < RESULTS.length; i++) {
			assertEquals(RESULTS[i], results[i]);
		}
		assertEquals(SCORE, athlete.getScore());
	}
}