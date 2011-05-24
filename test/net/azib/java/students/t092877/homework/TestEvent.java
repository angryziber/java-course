package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.model.Event;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Units tests for Event class
 * User: Artjom Kruglenkov
 * Date: 24.05.2011
 */
public class TestEvent {

	/**
	 * Tests score computation for a track event
	 */
	@Test
	public void testGetScoreForTrackEvent() {

		// Tomas Dvorak result for sprint on 100 meters event (in seconds)
		double rawResult = 10.62;

		// expected 947 points
		int expectedScore = 947;
		assertEquals(expectedScore, Event.SPRINT_ON_100_METERS.getScore(rawResult));
	}

	/**
	 * Tests score computation for a non-track event
	 */
	@Test
	public void testGetScoreForNonTrackEvent() {

		// Tomas Dvorak result for javelin throw event (in meters)
		double rawResult = 68.53;

		// expected 867
		int expectedScore = 867;
		assertEquals(expectedScore, Event.JAVELIN_THROW.getScore(rawResult));
	}
}
