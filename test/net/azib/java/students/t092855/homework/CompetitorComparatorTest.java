package net.azib.java.students.t092855.homework;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	public void CompetitorComparatorDifferentTotalPoints() {
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
		assertEquals(-1, comparator.compare(athlete2, athlete1));
	}

	/**
	 * Unit test for {@link CompetitorComparator#compare(Athlete, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void CompetitionComparatorEqualAthletes() throws ParseException {
		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(6525);
		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete1.getName()).thenReturn("Siim Piim");
		when(athlete1.getCountry()).thenReturn("EE");
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967");
		when(athlete1.getBirthday()).thenReturn(date);

		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete2.getName()).thenReturn("Siim Piim");
		when(athlete2.getCountry()).thenReturn("EE");
		when(athlete2.getBirthday()).thenReturn(date);

		assertEquals(0, new CompetitorComparator().compare(athlete1, athlete2));
	}

	/**
	 * Unit test for {@link CompetitorComparator#compare(Athlete, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void CompetitionComparatorDifferentName() throws ParseException {
		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(6525);
		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete1.getName()).thenReturn("Siim Piim");
		when(athlete1.getCountry()).thenReturn("EE");
		Date date = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967");
		when(athlete1.getBirthday()).thenReturn(date);

		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete2.getName()).thenReturn("Karl-Filipp Tamm");
		when(athlete2.getCountry()).thenReturn("EE");
		when(athlete2.getBirthday()).thenReturn(date);

		assertEquals(1, new CompetitorComparator().compare(athlete1, athlete2));
		assertEquals(-1, new CompetitorComparator().compare(athlete2, athlete1));
	}

	/**
	 * Unit test for {@link CompetitorComparator#compare(Athlete, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void CompetitionComparatorDifferentDate() throws ParseException {
		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(6525);
		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete1.getName()).thenReturn("Siim Piim");
		when(athlete1.getCountry()).thenReturn("EE");
		Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967");
		when(athlete1.getBirthday()).thenReturn(date1);

		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete2.getName()).thenReturn("Siim Piim");
		when(athlete2.getCountry()).thenReturn("EE");
		Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse("03.05.1965");
		when(athlete2.getBirthday()).thenReturn(date2);

		assertEquals(1, new CompetitorComparator().compare(athlete1, athlete2));
		assertEquals(-1, new CompetitorComparator().compare(athlete2, athlete1));
	}

		/**
	 * Unit test for {@link CompetitorComparator#compare(Athlete, Athlete)}
	 * @throws java.text.ParseException if date parsing fails
	 */
	@Test
	public void CompetitionComparatorDifferentCountry() throws ParseException {
		DecathlonEvents decathlonEvents1 = mock(DecathlonEvents.class);
		when(decathlonEvents1.getTotalPoints()).thenReturn(6525);
		Athlete athlete1 = mock(Athlete.class);
		when(athlete1.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete1.getName()).thenReturn("Siim Piim");
		when(athlete1.getCountry()).thenReturn("LV");
		Date date1 = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967");
		when(athlete1.getBirthday()).thenReturn(date1);

		Athlete athlete2 = mock(Athlete.class);
		when(athlete2.getAthleteEvents()).thenReturn(decathlonEvents1);
		when(athlete2.getName()).thenReturn("Siim Piim");
		when(athlete2.getCountry()).thenReturn("EE");
		Date date2 = new SimpleDateFormat("dd.MM.yyyy").parse("12.11.1967");
		when(athlete2.getBirthday()).thenReturn(date2);

		assertEquals(1, new CompetitorComparator().compare(athlete1, athlete2));
		assertEquals(-1, new CompetitorComparator().compare(athlete2, athlete1));
	}
}
