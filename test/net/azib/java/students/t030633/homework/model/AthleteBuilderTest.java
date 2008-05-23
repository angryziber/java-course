package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.junit.Test;

/**
 * DecathlonAthleteBuilderTest
 * 
 * @author t030633
 */
public class AthleteBuilderTest {

	private static final String NAME = "Testname";
	private static final Date DATE = new Date();
	private static final String COUNTRY = "CZ";

	private static final EnumMap<Event, Double> EMPTY_RESULTS = new EnumMap<Event, Double>(Event.class);
	private static final EnumMap<Event, Double> RESULTS = new EnumMap<Event, Double>(Event.class);
	static {
		RESULTS.put(Event.DISCUS, 10D);
	}
	
	private AthleteBuilder builderUnderTest = new AthleteBuilder();

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder}.
	 */
	@Test
	public void basicBuildCompletes() {
		Athlete a = builderUnderTest.name(NAME).date(DATE).country(COUNTRY).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(EMPTY_RESULTS, a.getResults());
		assertEquals(0, a.getScore());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonAthleteBuilder}.
	 */
	@Test
	public void buildWithResultsCompletes() {
		Athlete a = builderUnderTest.name(NAME).date(DATE).country(COUNTRY).addResult(Event.DISCUS, 10D).build();
		assertEquals(NAME, a.getName());
		assertEquals(DATE, a.getBirthDate());
		assertEquals(COUNTRY, a.getCountry());
		assertEquals(RESULTS, a.getResults());
		assertEquals(Event.DISCUS.points(10D), a.getScore());
	}

	/* 
	 * Also test some package local methods.
	 */

	@Test
	public void addsValidResults() {
		assertEquals(666D, new AthleteBuilder().calculate(validResults()));
	}
	
	@Test
	public void addsZeroResults() {
		assertEquals(0D, new AthleteBuilder().calculate(zeroResults()));
	}
	
	@Test
	public void existingCountryAccepted() {
		assertEquals("EE", new AthleteBuilder().checkCountry("EE"));
	}

	@Test
	public void notExistingCountryRemoved() {
		assertEquals("", new AthleteBuilder().checkCountry("PP"));
	}
	
	private Map<Event, Double> validResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.SHOT, 8.3D); // 8.3m
		map.put(Event.DISCUS, 14.2D); // 14.2m
		map.put(Event.R1500M, 403D); // 6min 43sec
		return map;
	}
	
	private Map<Event, Double> zeroResults() {
		EnumMap<Event, Double> map = new EnumMap<Event, Double>(Event.class);
		map.put(Event.LONGJ, 0D);
		map.put(Event.HIGH, 0D);
		map.put(Event.POLE, 0D);
		return map;
	}
	
}
