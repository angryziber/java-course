package net.azib.java.students.t093759.homework;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dionis
 *         6/4/11 9:17 PM
 */
public class AthletePlaceComputeHelperTest {

	public static final AthletePlaceComputeHelper ATHLETE_PLACE_COMPUTE_HELPER = AthletePlaceComputeHelper.getInstance();
	private Athlete athleteA;
	private Athlete athleteB;
	private Athlete athleteC;
	private Athlete athleteD;

	@Test
	public void helperIsASingleton() {
		assertTrue(AthletePlaceComputeHelper.getInstance() == AthletePlaceComputeHelper.getInstance());
	}

	@Test
	public void listOfAthletesWithDifferentResults() {
		List<Athlete> athletes = setUpListOfMockedAthletesByProvidingTheirPoints(4, 3, 2, 1);
		Map<Athlete, String> placesForAthletes = ATHLETE_PLACE_COMPUTE_HELPER.computePlacesFor(athletes);
		assertThat(placesForAthletes.get(athleteA), is("1"));
		assertThat(placesForAthletes.get(athleteB), is("2"));
		assertThat(placesForAthletes.get(athleteC), is("3"));
		assertThat(placesForAthletes.get(athleteD), is("4"));
	}

	@Test
	public void allHaveTheSamePoints() {
		List<Athlete> athletes = setUpListOfMockedAthletesByProvidingTheirPoints(1, 1, 1, 1);
		Map<Athlete, String> placesForAthletes = ATHLETE_PLACE_COMPUTE_HELPER.computePlacesFor(athletes);
		assertThat(placesForAthletes.get(athleteA), is("1-4"));
		assertThat(placesForAthletes.get(athleteB), is("1-4"));
		assertThat(placesForAthletes.get(athleteC), is("1-4"));
		assertThat(placesForAthletes.get(athleteD), is("1-4"));
	}
	@Test
	public void halfToHalfPoints() {
		List<Athlete> athletes = setUpListOfMockedAthletesByProvidingTheirPoints(2, 2, 1, 1);
		Map<Athlete, String> placesForAthletes = ATHLETE_PLACE_COMPUTE_HELPER.computePlacesFor(athletes);
		assertThat(placesForAthletes.get(athleteA), is("1-2"));
		assertThat(placesForAthletes.get(athleteB), is("1-2"));
		assertThat(placesForAthletes.get(athleteC), is("3-4"));
		assertThat(placesForAthletes.get(athleteD), is("3-4"));
	}
	@Test
	public void athletesShareThreePlacesFromFour() {
		List<Athlete> athletes = setUpListOfMockedAthletesByProvidingTheirPoints(2, 1, 1, 1);
		Map<Athlete, String> placesForAthletes = ATHLETE_PLACE_COMPUTE_HELPER.computePlacesFor(athletes);
		assertThat(placesForAthletes.get(athleteA), is("1"));
		assertThat(placesForAthletes.get(athleteB), is("2-4"));
		assertThat(placesForAthletes.get(athleteC), is("2-4"));
		assertThat(placesForAthletes.get(athleteD), is("2-4"));
	}

	private List<Athlete> setUpListOfMockedAthletesByProvidingTheirPoints(int athleteAPoints, int athleteBPoints, int athleteCPoints, int athleteDPoints) {
		athleteA = mock(Athlete.class);
		when(athleteA.computePoints()).thenReturn(athleteAPoints);

		athleteB = mock(Athlete.class);
		when(athleteB.computePoints()).thenReturn(athleteBPoints);

		athleteC = mock(Athlete.class);
		when(athleteC.computePoints()).thenReturn(athleteCPoints);

		athleteD = mock(Athlete.class);
		when(athleteD.computePoints()).thenReturn(athleteDPoints);

		List<Athlete> athletes = new ArrayList<Athlete>();
		athletes.add(athleteA);
		athletes.add(athleteB);
		athletes.add(athleteC);
		athletes.add(athleteD);

		for (Athlete athlete1 : athletes) {
			for (Athlete athlete2 : athletes) {
				when(athlete1.compareTo(athlete2)).thenCallRealMethod();
			}
		}

		return athletes;
	}
}
