package net.azib.java.bowling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * BowlingTest
 *
 * @author anton
 */
public class BowlingTest {
	Bowling bowling = new Bowling();

	@Test
	public void zeroGame() throws Exception {
		assertScoreIs(0);
	}
	
	@Test
	public void oneShotGame() throws Exception {
		bowling.makeShot(5);
		assertScoreIs(5);
	}

	@Test
	public void twoShotGame() throws Exception {
		bowling.makeShot(5);
		bowling.makeShot(3);
		assertScoreIs(8);
	}
	
	@Test
	public void tenShotGame() throws Exception {
		bowling.makeShot(5, 1, 1, 5, 6, 7, 1, 1, 2, 3);
		assertScoreIs(32);
	}
	
	@Test
	public void strikeGame() throws Exception {
		bowling.makeShot(10);
		bowling.makeShot(3, 2);
		assertScoreIs(20);
	}
	
	@Test
	public void lastStrikeIntermediateScore() throws Exception {
		bowling.makeShot(10, 4, 1, 10);
		assertScoreIs(30);
	}
	
	@Test
	public void askForScoreTwice() throws Exception {
		bowling.makeShot(1);
		assertScoreIs(1);
		assertScoreIs(1);
	}
	
	private void assertScoreIs(int score) {
		assertEquals(score, bowling.getScore());
	}
}
