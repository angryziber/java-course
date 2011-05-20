package net.azib.java.students.t110013.homework.model;

import org.hamcrest.Matcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class DecathlonTest {

	@Test
	public void calculateTrackEventScore() {
        assertThat(Decathlon.SPRINT_100M.calculateTrackEventScore(13.75), is(348));
    }

	@Test
	public void calculateJumpScore() {
        assertThat(Decathlon.LONG_JUMP.calculateJumpScore(5.0), is(382));
    }

	@Test
	public void calculateThrowScore() {
        assertThat(Decathlon.SHOT_PUT.calculateThrowScore(8.64), is(404));
    }

	@Test
	public void eachEventShouldKnowHowToCalculateCorrectScore() {
		assertThat(calculateEventScores(12.61, 5.0, 9.22, 1.5, 60.39, 16.43, 21.6, 2.6, 35.81, 325.72),
				are(536, 382, 439, 389, 400, 685, 302, 264, 382, 421));
	}

	private double[] calculateEventScores(double... results) {
		double[] scores = new double[10];
		int i = 0;

		for (Decathlon event : Decathlon.values()) {
			scores[i] = event.calculateEventScore(results[i]);
			i++;
		}

		return scores;
	}

	private Matcher<double[]> are(double... expected) {
		return is(expected);
	}
}
