package net.azib.java.students.t103784.homework;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author      Ott Madis Ozolit <karuott321@hotmail.com>
 * @version     1.6
 * @since       2011.0520
 *
 */
public class ScoreCalculatorTest extends ScoreCalculator{
	/**
	 * Tests if athletes' scores are calculated properly.
	 *
	 * Calculates some athletes' scores and checks
	 * if the calculations were done properly.
	 */
	@org.junit.Test
    public void testScore() {
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
			calculate(athlete);
			contestants.add(athlete);
		}
		for (u = 0; u < 3; u++) {
				athlete = new Athlete();
				for (int i = 0; i < 10; i++) {
					double perf = 10;
					athlete.setPerformance(i, perf);
				}
				calculate(athlete);
				contestants.add(athlete);
		}
		int[] properScores = new int[contestants.size()];
		int[] testableScores = new int[contestants.size()];
		properScores[0] = 59361;
		properScores[1] = 59361;
		properScores[2] = 28224;
		properScores[3] = 28224;
		properScores[4] = 28224;
		for (int k = 0; k < contestants.size(); k++) {
			testableScores[k] = contestants.get(k).getScore();
		}
		for (int i = 0; i < u + o; i++) {
			assertNotNull("Contestants is null", contestants);
			assertArrayEquals("Score calculation failed", properScores, testableScores);
			System.out.println("Test success for athlete " + i + " : " + contestants.get(i).getScore());
		}
	}
}