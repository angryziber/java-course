package net.azib.java.students.t010588.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests if ScoreComparator compares Athlete classes right
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ScoreComparatorTest {

	private ScoreComparator comparator;

	@Before
	public void initComparator() {
		comparator = new ScoreComparator();
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t010588.homework.ScoreComparator#compare(net.azib.java.students.t010588.homework.Athlete, net.azib.java.students.t010588.homework.Athlete)}.
	 */
	@Test
	public void testCompare() {
		Athlete a1 = new Athlete();
		Athlete a2 = new Athlete();

		a1.setScore(1);
		a2.setScore(1000);

		assertEquals(1, comparator.compare(a1, a2));

		a1.setScore(2000);
		a2.setScore(2);

		assertEquals(-1, comparator.compare(a1, a2));

		a1.setScore(330);
		a2.setScore(330);

		assertEquals(0, comparator.compare(a1, a2));
	}
}
