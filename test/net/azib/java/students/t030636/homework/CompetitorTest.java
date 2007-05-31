package net.azib.java.students.t030636.homework;

import net.azib.java.students.t030636.homework.Competitor;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * CompetitorTest
 *
 * @author Martin
 */
public class CompetitorTest {
	private Competitor comp = new Competitor();
	private Competitor comp2 = new Competitor();
	/**
	 * Test for the competitor toString() method
	 * @see net.azib.java.students.t030636.homework.Competitor
	 */
	@Test
	public void testToString() {
		comp.name = "SzÅ‘rĆ¶s SzÅ±k";
		comp.score = 3495;
		comp.results [0] = "13.75";
		comp.results [1] = "4.84";
		comp.results [2] = "10.12";
		comp.results [3] = "1.50";
		comp.results [4] = "1:08.44";
		comp.results [5] = "19.18";
		comp.results [6] = "30.85";
		comp.results [7] = "2.80";
		comp.results [8] = "33.88";
		comp.results [9] = "6:22.75";
		comp.nationality = "HU";
		comp.born = "3.04.1972";
		String compare = "3495 points for: SzÅ‘rĆ¶s SzÅ±k,3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
		assertEquals(comp.toString(), compare);
	}
	/**
	 * Test for the competitor compareTo() and equals() methods
	 * @see net.azib.java.students.t030636.homework.Competitor
	 */
	@Test
	public void testEquals() {
		comp.score = 125;
		comp2.score = 125;
		assertTrue(comp.equals(comp2));
		assertEquals(comp.compareTo(comp2),0);
		comp2.score = comp2.score -1;
		assertFalse(comp2.equals(comp));
		assertEquals(comp.compareTo(comp2), -1);
	}
}

