package net.azib.java.students.t050545.homework;

import net.azib.java.students.t050545.homework.sport.PointSystem;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * PointTest
 *
 * @author libricon
 */
public class PointTest {
	
	@Test
	public void testGetScores() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 776f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 220.8f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 528.5f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		PointSystem points = new PointSystem(arrayScore);
		assertEquals(arrayScore[4], points.getResults()[4]);
		assertEquals(arrayScore[9], points.getResults()[9]);
	}
	
	@Test
	public void testGetScore() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 776f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 220.8f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 528.5f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		PointSystem points = new PointSystem(arrayScore);
		assertEquals(1000, points.getScores()[4],10);
		assertEquals(1000, points.getScores()[9],10);
	}
	
	
	
	@Test
	public void testGetScoreReturns10000() throws Exception {
		float[] arrayScore = new float[10];
		arrayScore[0] = 10.395f;
		arrayScore[1] = 776f;
		arrayScore[2] = 18.4f;
		arrayScore[3] = 220.8f;
		arrayScore[4] = 46.17f;
		arrayScore[5] = 13.8f;
		arrayScore[6] = 56.17f;
		arrayScore[7] = 528.5f;
		arrayScore[8] = 77.19f;
		arrayScore[9] = 233.79001f;
		PointSystem points = new PointSystem(arrayScore);
		assertEquals(" Hurra  ", 10000, points.getScore(), 10);
	}
	
}
