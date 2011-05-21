package net.azib.java.students.t092855.homework;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * CompetitionTest
 * Unit tests for {@link net.azib.java.students.t092855.homework.Competition}
 *
 * @author t092855
 */
public class CompetitionTest {
	private final String name1 = "Number Üks";
	private final String name2 = "Number Kaks";
	private final String name3 = "Number Kolm";

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Competition#addAthlete(Athlete)}
	 * and {@link net.azib.java.students.t092855.homework.Competition#getCompetitors()}
	 */
	@Test
	public void athletesAreAddedAndSorted() {
		double[] resultsLow = {9.58, 8.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
		double[] resultsMedium = {9.2, 9.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};
		double[] resultsHigh = {9.0, 10.22, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.00};

		Athlete athlete1 = new Athlete();
		Athlete athlete2 = new Athlete();
		Athlete athlete3 = new Athlete();
		athlete1.setDecathlonEvent(new DecathlonEvents(resultsMedium));
		athlete1.setName(name1);
		athlete2.setDecathlonEvent(new DecathlonEvents(resultsLow));
		athlete2.setName(name2);
		athlete3.setDecathlonEvent(new DecathlonEvents(resultsHigh));
		athlete3.setName(name3);

		Competition competition = new Competition();
		competition.addAthlete(athlete2);
		competition.addAthlete(athlete1);
		competition.addAthlete(athlete3);

		Iterator iterator = competition.getCompetitors().iterator();
		assertEquals(name3, ((Athlete) iterator.next()).getName());
		assertEquals(name1, ((Athlete) iterator.next()).getName());
		assertEquals(name2, ((Athlete) iterator.next()).getName());
	}

	/**
	 * Unit test for {@link net.azib.java.students.t092855.homework.Competition#addAthlete(Athlete)}
	 * and {@link net.azib.java.students.t092855.homework.Competition#getCompetitors()}
	 */
	@Test
	public void athletesAreAddedAndSortedWithMocking() {

		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(5003);

		DecathlonEvents decathlonEvents2 = mock(DecathlonEvents.class);
		when(decathlonEvents2.getTotalPoints()).thenReturn(5002);

		DecathlonEvents decathlonEvents3 = mock(DecathlonEvents.class);
		when(decathlonEvents3.getTotalPoints()).thenReturn(5001);

		Athlete athleteMock1 = mock(Athlete.class);
		when(athleteMock1.getName()).thenReturn(name1);
		when(athleteMock1.getAthleteEvents()).thenReturn(decathlonEvents1);

		Athlete athleteMock2 = mock(Athlete.class);
		when(athleteMock2.getName()).thenReturn(name2);
		when(athleteMock2.getAthleteEvents()).thenReturn(decathlonEvents2);

		Athlete athleteMock3 = mock(Athlete.class);
		when(athleteMock3.getName()).thenReturn(name3);
		when(athleteMock3.getAthleteEvents()).thenReturn(decathlonEvents3);

		Competition competition = new Competition();
		competition.addAthlete(athleteMock2);
		competition.addAthlete(athleteMock3);
		competition.addAthlete(athleteMock1);

		Iterator iterator = competition.getCompetitors().iterator();
		assertEquals(name1, ((Athlete) iterator.next()).getName());
		assertEquals(name2, ((Athlete) iterator.next()).getName());
		assertEquals(name3, ((Athlete) iterator.next()).getName());
	}
}
