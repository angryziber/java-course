package net.azib.java.students.t092855.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * CompetitionTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.Competition}
 *
 * @author t092855
 */
public class CompetitionTest {
	private final Athlete athlete1 = new Athlete();
	private final Athlete athlete2 = new Athlete();
	private final Athlete athlete3 = new Athlete();
	private final double[] resultsLow = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final double[] resultsMedium = {9.2, 9.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final double[] resultsHigh = {9.0, 10.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
	private final String name1 = "Number Üks";
	private final String name2 = "Number Kaks";
	private final String name3 = "Number Kolm";

	/**
	 * Unit test initialization for {@link net.azib.java.students.t092855.homework.Competition}
	 */
	@Before
	public void initAthletes() {
		athlete1.setDecathlonEvent(new DecathlonEvents(resultsMedium));
		athlete1.setName(name1);
		athlete2.setDecathlonEvent(new DecathlonEvents(resultsLow));
		athlete2.setName(name2);
		athlete3.setDecathlonEvent(new DecathlonEvents(resultsHigh));
		athlete3.setName(name3);
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Competition#addAthlete(Athlete)}
	 * and {@link net.azib.java.students.t092855.homework.Competition#getCompetitors()}
	 */
	@Test
	public void athletesAreAddedAndSorted() {
		Competition competition = new Competition();
		competition.addAthlete(athlete2);
		competition.addAthlete(athlete1);
		competition.addAthlete(athlete3);

		Iterator iterator = competition.getCompetitors().iterator();
		assertEquals(name3, ((Athlete) iterator.next()).getName());
		assertEquals(name1, ((Athlete) iterator.next()).getName());
		assertEquals(name2, ((Athlete) iterator.next()).getName());
	}
}
