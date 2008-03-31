package net.azib.java.students.t030633.homework;

import static org.junit.Assert.assertEquals;

import java.util.EnumMap;

import org.junit.Test;

/**
 * AthleteTest
 * 
 * @author t030633
 */
public class AthleteTest {

	//TODO tests for getCountry, getBirthDate
	
	/** Test map */
	private static EnumMap<Event, Double> TEST_MAP = new EnumMap<Event, Double>(Event.class);
	/** Test name */
	private static final String TEST_NAME = "Piitsut";

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getName()}.
	 */
	@Test
	public void canGetName() {
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(TEST_NAME, a.getName());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getResults()}.
	 */
	@Test
	public void canGetResults() {
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(TEST_MAP, a.getResults());
	}

	/**
	 * Test methods for
	 * {@link net.azib.java.students.t030633.homework.Athlete#getScore()}.
	 */
	@Test
	public void scoreForNoResults() {
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(0D, a.getScore());
	}

	@Test
	public void scoreForSingleResult() {
		TEST_MAP.put(Event.SHOT, 8.3D); // 8.3m
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(384, a.getScore());
	}

	@Test
	public void scoreForTwoResults() {
		TEST_MAP.put(Event.DISCUS, 14.2D); // 14.2m
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(550, a.getScore());
	}

	@Test
	public void scoreForThreeResults() {
		TEST_MAP.put(Event.M1500, 403D); // 6min 43sec
		Athlete a = new Athlete(TEST_NAME, null, null, TEST_MAP);
		assertEquals(666, a.getScore());
	}

}
