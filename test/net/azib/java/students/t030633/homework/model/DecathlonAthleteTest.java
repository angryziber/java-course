package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import net.azib.java.students.t030633.homework.model.Athlete;
import net.azib.java.students.t030633.homework.model.DecathlonAthlete;
import net.azib.java.students.t030633.homework.model.Event;

import java.util.Date;
import java.util.EnumMap;

import org.junit.Test;

/**
 * DecathlonAthleteTest
 * 
 * @author t030633
 */
public class DecathlonAthleteTest {

	private final String NAME = "Testname";
	private final String COUNTRY = "EE";
	private final Date DATE = new Date();
	private final EnumMap<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	private final int SCORE_A = 2;
	private final int SCORE_B = 3;

	private Athlete createAthleteA() {
		DecathlonAthlete a = new DecathlonAthlete(NAME, DATE, COUNTRY, RESULTS, SCORE_A);
		return a;
	}

	private Athlete createAthleteB() {
		DecathlonAthlete b = new DecathlonAthlete(NAME, DATE, COUNTRY, RESULTS, SCORE_B);
		return b;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#getName()}.
	 */
	@Test
	public void canGetName() {
		assertEquals(NAME, createAthleteA().getName());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#getBirthDate()}.
	 */
	@Test
	public void canGetBirthDate() {
		assertEquals(DATE, createAthleteA().getBirthDate());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#getCountry()}.
	 */
	@Test
	public void canGetCountry() {
		assertEquals(COUNTRY, createAthleteA().getCountry());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#getResults()}.
	 */
	@Test
	public void canGetResults() {
		assertEquals(RESULTS, createAthleteA().getResults());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#getScore()}.
	 */
	@Test
	public void canGetScore() {
		assertEquals(SCORE_A, createAthleteA().getScore());
	}

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthlete#compareTo()}.
	 */
	@Test
	public void comparesAsInteger() {
		Athlete a = createAthleteA();
		Athlete b = createAthleteB();
		assertTrue((Integer) a.compareTo(b) instanceof Integer);
	}

	@Test
	public void compareIsScoreDifference() {
		Athlete a = createAthleteA();
		Athlete b = createAthleteB();
		assertEquals(SCORE_A - SCORE_B, a.compareTo(b));
	}

}
