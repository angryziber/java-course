package net.azib.java.students.t030633.homework.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import net.azib.java.students.t030633.homework.model.DecathlonChecker;
import net.azib.java.students.t030633.homework.model.Event;

import java.util.EnumMap;

import org.junit.Test;

/**
 * DecathlonCheckerTest
 * 
 * @author t030633
 */
public class DecathlonCheckerTest {

	private Checker checker = new DecathlonChecker();
	
	@Test
	public void nullCountryAvoided() {
		assertNotNull(checker.checkCountry(null));
	}

	@Test
	public void existingCountryAccepted() {
		assertEquals("EE", checker.checkCountry("EE"));
	}

	@Test
	public void notExistingCountryRemoved() {
		assertEquals("", checker.checkCountry("PP"));
	}

	@Test
	public void nullDateAvoided() {
		assertNotNull(checker.checkDate(null));
	}

	@Test
	public void testCheckName() {
		assertNotNull(checker.checkName(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void nullResultsAvoided() {
		assertNotNull(checker.checkResults(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void validResultsAccepted() {
		assertEquals(validResults(), checker.checkResults(validResults()));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void invalidResultsRemoved() {
		assertEquals(emptyResults(), checker.checkResults(invalidResults()));
	}

	private EnumMap<Event, Double> emptyResults() {
		return new EnumMap<Event, Double>(Event.class);
	}

	private EnumMap<Event, Double> validResults() {
		EnumMap<Event, Double> results = new EnumMap<Event, Double>(Event.class);
		results.put(Event.SHOT, 8.3D); // 8.3m
		results.put(Event.DISCUS, 14.2D); // 14.2m
		results.put(Event.R1500M, 403D); // 6min 43sec
		return results;
	}

	private EnumMap<Event, Double> invalidResults() {
		EnumMap<Event, Double> results = new EnumMap<Event, Double>(Event.class);
		results.put(Event.R100M, 5D);
		results.put(Event.DISCUS, 500D);
		results.put(Event.HIGH, 5D);
		results.put(Event.JAVELIN, 500D);
		results.put(Event.LONGJ, 50D);
		results.put(Event.POLE, 50D);
		results.put(Event.R110MH, 5D);
		results.put(Event.R1500M, 100D);
		results.put(Event.R400M, 10D);
		results.put(Event.SHOT, 50D);
		return results;
	}
	
}
