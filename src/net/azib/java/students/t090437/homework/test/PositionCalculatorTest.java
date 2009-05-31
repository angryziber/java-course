package net.azib.java.students.t090437.homework.test;

import net.azib.java.students.t090437.homework.Competitor;
import net.azib.java.students.t090437.homework.PositionCalculator;

import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * PositionTest
 *
 * @author Ronald
 */
public class PositionCalculatorTest {
	@Test
	public void testIfPositionsAreCalculatedCorrectly() {
		SortedSet<Competitor> competitors = new TreeSet<Competitor>();
		Competitor comp1, comp2, comp3, comp4;
		
		comp1 = new Competitor();
		comp1.setScore(100);
		competitors.add(comp1);
		
		comp2 = new Competitor();
		comp2.setScore(50);
		comp2.setName("Jåger");
		competitors.add(comp2);
		
		comp3 = new Competitor();
		comp3.setScore(50);
		comp3.setName("Karu");
		competitors.add(comp3);
		
		PositionCalculator.calcPositions(competitors);
		
		Assert.assertTrue(comp2.getPosition().toString()
				.equals(comp3.getPosition().toString()));
		
		comp4 = new Competitor();
		comp4.setScore(40);
		comp4.setName("Ilves");
		competitors.add(comp4);
		
		PositionCalculator.calcPositions(competitors);
		
		Assert.assertNotNull(comp4.getPosition());
		
	}
	
	@Test
	public void testIfWorksWithEmptySet() {
		SortedSet<Competitor> competitors = new TreeSet<Competitor>();
		
		try {
			PositionCalculator.calcPositions(competitors);
		} catch(Exception exc) {
			Assert.assertTrue(false);
		}
	}
}
