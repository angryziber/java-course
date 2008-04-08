package net.azib.java.students.t030633.homework.Model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.junit.Test;

/**
 * AthleteTest
 * 
 * @author t030633
 */
public class AthleteTest {

	private final String NAME = "Piitsut";
	private final String COUNTRY = "EE";
	private final Date DATE = new Date();
	private final Map<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
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

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getName()}.
	 */
	@Test
	public void canGetName() {
		assertEquals(NAME, createAthleteA().getName());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getBirthDate()}.
	 */
	@Test
	public void canGetBirthDate() {
		assertEquals(DATE, createAthleteA().getBirthDate());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getCountry()}.
	 */
	@Test
	public void canGetCountry() {
		assertEquals(COUNTRY, createAthleteA().getCountry());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getResults()}.
	 */
	@Test
	public void canGetResults() {
		assertEquals(RESULTS, createAthleteA().getResults());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getScore()}.
	 */
	@Test
	public void canGetScore() {
		assertEquals(SCORE_A, createAthleteA().getScore());
	}

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.Athlete#compareTo()}.
	 */
	@Test
	public void comparesAsInteger() {
		Athlete a = createAthleteA();
		Athlete b = createAthleteB();
		assertTrue((Integer)a.compareTo(b) instanceof Integer);
	}
	@Test
	public void compareIsScoreDifference() {
		Athlete a = createAthleteA();
		Athlete b = createAthleteB();
		assertEquals(SCORE_A - SCORE_B, a.compareTo(b));
	}

}
