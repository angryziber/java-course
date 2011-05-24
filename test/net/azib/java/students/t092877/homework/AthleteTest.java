package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.model.Event;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Units tests for Athlete class
 * User: Artjom Kruglenkov
 * Date: 24.05.2011
 */
public class AthleteTest {

	/**
	 * Tests total score computation
	 */
	@Test
	public void testGetTotalScore() {

		// Tomas Dvorak rawResults for decathlon competition
		String resultsStr = "10.62 807 16.57 200 47.74 13.80 45.51 500 68.53 275.13";

		String[] rawResults = resultsStr.split("\\s+");

		int totalScoreExpected = 8902;
		int totalScoreActual = 0;

		int i = 0;
		for (Event event : Event.values()) {
			totalScoreActual += event.getScore(Double.parseDouble(rawResults[i]));
			i++;
		}

		assertEquals(totalScoreExpected, totalScoreActual);
	}


	/**
	 * Tests compareTo() method implementation
	 */
	@Test
	public void testCompareTo() {

		// Tomas Dvorak results for decathlon competition (first place)
		String tomasResultsStr = "10.62 807 16.57 200 47.74 13.80 45.51 500 68.53 275.13";

		String[] tomasRawResults = tomasResultsStr.split("\\s+");

		// Erki Nool results for decathlon competition(second place)
		String erkiResultsStr = "10.60 763 14.90 203 46.23 14.40 43.40 540 67.01 269.58";

		String[] erkiRawResults = erkiResultsStr.split("\\s+");

		int tomasTotalScoreExpected = 8902;
		int tomasTotalScoreActual = 0;
		int erkiTotalScoreExpected = 8815;
		int erkiTotalScoreActual = 0;

		int i = 0;
		for (Event event : Event.values()) {

			tomasTotalScoreActual += event.getScore(Double.parseDouble(tomasRawResults[i]));
			erkiTotalScoreActual += event.getScore(Double.parseDouble((erkiRawResults[i])));
			i++;
		}

		assertEquals(erkiTotalScoreExpected, erkiTotalScoreActual);
		assertEquals(tomasTotalScoreExpected, tomasTotalScoreActual);
		assertTrue(tomasTotalScoreActual > erkiTotalScoreActual);
	}
}
