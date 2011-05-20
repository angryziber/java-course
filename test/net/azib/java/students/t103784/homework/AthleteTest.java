package net.azib.java.students.t103784.homework;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class AthleteTest extends Athlete {
	/**
	 * Tests if the athlete class is acting properly.
	 * <p/>
	 * Fills an athlete up with information and checks
	 * if its getters and setters are working properly.
	 */
	@org.junit.Test
	public void testAthlete() {
		String name = "Juhan Mihkel";
		String birthDate = "1.2.1980";
		String country = "US";
		double[] performance = {10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0, 10.0};
		int score = 28224;
		String place = "1";

		setName(name);
		setBirthDate(birthDate);
		setCountry(country);
		for (int i = 0; i < 10; i++) {
			setPerformance(i, performance[i]);
		}
		MockScoreCalculator.calculate(this);
		List<Athlete> contestants = new ArrayList<Athlete>();
		contestants.add(this);
		MockPlaceCalculator.calculatePlace(contestants);

		assertArrayEquals("Name failed", name.getBytes(), getName().getBytes());
		assertArrayEquals("Date of Birth failed", birthDate.getBytes(), getBirthDate().getBytes());
		assertArrayEquals("Country failed", country.getBytes(), getCountry().getBytes());
		for (int i = 0; i < 10; i++) {
			assertEquals("Performance at " + i + " failed", performance[i], getPerformance(i), 0);
		}
		assertEquals("Score failed", score, getScore());
		assertArrayEquals("Place failed", place.getBytes(), getPlace().getBytes());
	}

	class MockPlaceCalculator extends PlaceCalculator {

	}

	class MockScoreCalculator extends ScoreCalculator {

	}
}
