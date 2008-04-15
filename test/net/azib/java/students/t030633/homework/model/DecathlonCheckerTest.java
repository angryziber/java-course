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
public class DecathlonCheckerTest extends SimpleCheckerTest {

	public DecathlonCheckerTest() {
		super(new DecathlonChecker());
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
		results.put(Event.LONG, 50D);
		results.put(Event.POLE, 50D);
		results.put(Event.R110MH, 5D);
		results.put(Event.R1500M, 100D);
		results.put(Event.R400M, 10D);
		results.put(Event.SHOT, 50D);
		return results;
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void nullResultsAvoided() {
		assertNotNull(new DecathlonChecker().checkResults(null));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void validResultsAccepted() {
		assertEquals(validResults(), new DecathlonChecker().checkResults(validResults()));
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.homework.model.DecathlonChecker#checkResults(EnumMap)}.
	 */
	@Test
	public void invalidResultsRemoved() {
		assertEquals(emptyResults(), new DecathlonChecker().checkResults(invalidResults()));
	}

}
