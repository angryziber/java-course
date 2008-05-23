package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.EnumMap;

import org.junit.Test;

/**
 * DecathlonAthleteTest
 * 
 * @author t030633
 */
public class AthleteTest {

	private final String NAME = "Testname";
	private final String COUNTRY = "EE";
	private final Date DATE = new Date();
	private final EnumMap<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	private final int SCORE_A = 2;
	private final int SCORE_B = 3;

	private Athlete createAthleteA() {
		Athlete a = new Athlete(NAME, DATE, COUNTRY, RESULTS, SCORE_A);
		return a;
	}

	private Athlete createAthleteB() {
		Athlete b = new Athlete(NAME, DATE, COUNTRY, RESULTS, SCORE_B);
		return b;
	}

	@Test
	public void canGetName() {
		assertEquals(NAME, createAthleteA().getName());
	}

	@Test
	public void canGetBirthDate() {
		assertEquals(DATE, createAthleteA().getBirthDate());
	}

	@Test
	public void canGetCountry() {
		assertEquals(COUNTRY, createAthleteA().getCountry());
	}

	@Test
	public void canGetResults() {
		assertEquals(RESULTS, createAthleteA().getResults());
	}

	@Test
	public void canGetScore() {
		assertEquals(SCORE_A, createAthleteA().getScore());
	}

	@Test
	public void comparesAsInteger() {
		assertTrue((Integer) createAthleteA().compareTo(createAthleteB()) instanceof Integer);
	}

	@Test
	public void compareIsScoreDifference() {
		assertEquals(SCORE_B - SCORE_A, createAthleteA().compareTo(createAthleteB()));
	}

}
