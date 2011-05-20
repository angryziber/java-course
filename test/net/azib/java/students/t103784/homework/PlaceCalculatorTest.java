package net.azib.java.students.t103784.homework;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

public class PlaceCalculatorTest extends PlaceCalculator{
	@org.junit.Test
    public void testPlace() {
		List<Athlete> contestants = new ArrayList<Athlete>();
		Athlete athlete;
		int o;
		int u;
		for (o = 0; o < 2; o++) {
			athlete = new Athlete();
			for (int i = 0; i < 10; i++) {
				double perf = 20;
				athlete.setPerformance(i, perf);
			}
			ScoreCalculator.calculate(athlete);
			contestants.add(athlete);
		}
		for (u = 0; u < 3; u++) {
				athlete = new Athlete();
				for (int i = 0; i < 10; i++) {
					double perf = 10;
					athlete.setPerformance(i, perf);
				}
				ScoreCalculator.calculate(athlete);
				contestants.add(athlete);
		}
		calculatePlace(contestants);
		String[] properPlaces = new String[contestants.size()];
		properPlaces[0] = "1 - 2";
		properPlaces[1] = "1 - 2";
		properPlaces[2] = "3 - 5";
		properPlaces[3] = "3 - 5";
		properPlaces[4] = "3 - 5";
		for (int i = 0; i < u + o; i++) {
			assertNotNull("Contestants is null", contestants);
			assertArrayEquals("Place calculation failed", properPlaces[i].getBytes(), contestants.get(i).getPlace().getBytes());
			System.out.println("Test success for athlete " + i + " : " + contestants.get(i).getPlace());
		}
	}
}