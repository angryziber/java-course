package net.azib.java.students.t092855.homework;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * CompetitorComparatorTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.CompetitorComparator}
 *
 * @author t092855
 */
public class CompetitorComparatorTest {

	/**
	 * Unit test for {@link CompetitorComparator#compare(Athlete, Athlete)}
	 */
	@Test
	public void CompetitorComparatorWorks() {
		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(8001);
		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);

		DecathlonEvents decathlonEvents2 = mock(DecathlonEvents.class);
		when(decathlonEvents2.getTotalPoints()).thenReturn(8002);
		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents2);

		CompetitorComparator comparator = new CompetitorComparator();
		assertEquals(1, comparator.compare(athlete1, athlete2));
	}
}
