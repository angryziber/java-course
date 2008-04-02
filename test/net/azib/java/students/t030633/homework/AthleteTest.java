package net.azib.java.students.t030633.homework;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.EnumMap;

import org.junit.Test;

/**
 * AthleteTest
 * 
 * @author t030633
 */
public class AthleteTest {

	/** Test map for Athlete */
	private static EnumMap<Event, Double> TEST_MAP = new EnumMap<Event, Double>(Event.class);
	/** Test name for Athlete */
	private static final String TEST_NAME = "Piitsut";
	/** Test country for Athlete */
	private static final String TEST_COUNTRY = "EE";
	/** Test birth date for Athlete */
	private static final Date TEST_BIRTH_DATE = new Date();

	private Athlete createAthlete() {
		Athlete a = new Athlete(TEST_NAME, TEST_BIRTH_DATE, TEST_COUNTRY, TEST_MAP);
		return a;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getName()}.
	 */
	@Test
	public void canGetName() {
		Athlete a = createAthlete();
		assertEquals(TEST_NAME, a.getName());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getResults()}.
	 */
	@Test
	public void canGetResults() {
		assertEquals(TEST_MAP, createAthlete().getResults());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getCountry()}.
	 */
	@Test
	public void canGetCountry() {
		assertEquals(TEST_COUNTRY, createAthlete().getCountry());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getResults()}.
	 */
	@Test
	public void canGetBirthDate() {
		assertEquals(TEST_BIRTH_DATE, createAthlete().getBirthDate());
	}

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getScore()}.
	 */
	@Test
	public void scoreForNoResults() {
		assertEquals(0D, createAthlete().getScore());
	}

	@Test
	public void scoreForSingleResult() {
		TEST_MAP.put(Event.SHOT, 8.3D); // 8.3m
		assertEquals(384, createAthlete().getScore());
	}

	@Test
	public void scoreForTwoResults() {
		TEST_MAP.put(Event.DISCUS, 14.2D); // 14.2m
		assertEquals(550, createAthlete().getScore());
	}

	@Test
	public void scoreForThreeResults() {
		TEST_MAP.put(Event.M1500, 403D); // 6min 43sec
		assertEquals(666, createAthlete().getScore());
	}

}
