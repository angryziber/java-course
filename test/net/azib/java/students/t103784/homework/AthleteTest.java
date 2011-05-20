package net.azib.java.students.t103784.homework;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AthleteTest {

	@org.junit.Test
	public void testAthlete() {
        Athlete athlete = new Athlete();

		String name = "Juhan Mihkel";
		String birthDate = "1.2.1980";
		String country = "US";
		double[] performance = {10.0,10.0,10.0,10.0,10.0,10.0,10.0,10.0,10.0,10.0};
		int score = 28224;
		String place = "1";

		athlete.setName(name);
		athlete.setBirthDate(birthDate);
		athlete.setCountry(country);
		for (int i = 0; i < 10; i++) {
			athlete.setPerformance(i, performance[i]);
		}
		ScoreCalculator.calculate(athlete);
		List<Athlete> contestants = new ArrayList<Athlete>();
		contestants.add(athlete);
		PlaceCalculator.calculatePlace(contestants);

		assertArrayEquals("Name failed", name.getBytes(), athlete.getName().getBytes());
		assertArrayEquals("Date of Birth failed", birthDate.getBytes(), athlete.getBirthDate().getBytes());
		assertArrayEquals("Country failed", country.getBytes(), athlete.getCountry().getBytes());
		for (int i = 0; i < 10; i++) {
			assertEquals("Performance at " + i + " failed", performance[i], athlete.getPerformance(i), 0);
		}
		assertEquals("Score failed", score, athlete.getScore());
		assertArrayEquals("Place failed", place.getBytes(), athlete.getPlace().getBytes());
	}
}
