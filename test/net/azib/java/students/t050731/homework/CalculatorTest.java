package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * CalculatorTest
 *
 * @author Raigo
 */
public class CalculatorTest {

	@Test
	public void test100m()
	{
		CalculateTrackScores track = CalculateTrackScores.valueOf("SPRINT_100M");
		assertEquals(1000, track.calculateTrackScore(10.395));
	}
	
	@Test
	public void testLongJump()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("LONG_JUMP");
		assertEquals(1000, field.calculateFieldScore(776));
	}
	
	@Test
	public void testShotPut()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("SHOT_PUT");
		assertEquals(1000, field.calculateFieldScore(18.4));
	}
	
	@Test
	public void testHighJump()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("HIGH_JUMP");
		assertEquals(1061, field.calculateFieldScore(227));
	}
	
	@Test
	public void test400m()
	{
		CalculateTrackScores track = CalculateTrackScores.valueOf("SPRINT_400M");
		assertEquals(1000, track.calculateTrackScore(46.17));
	}
	
	@Test
	public void testHurdles()
	{
		CalculateTrackScores track = CalculateTrackScores.valueOf("HURDLES");
		assertEquals(1000, track.calculateTrackScore(13.8));
	}
	
	@Test
	public void testDiscusThrow()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("DISCUS_THROW");
		assertEquals(1000, field.calculateFieldScore(56.17));
	}
	
	@Test
	public void testPoleVault()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("POLE_VAULT");
		assertEquals(1152, field.calculateFieldScore(576));
	}
	
	@Test
	public void testJavelinThrow()
	{
		CalculateFieldScores field = CalculateFieldScores.valueOf("JAVELIN_THROW");
		assertEquals(1000, field.calculateFieldScore(77.19));
	}
	
	@Test
	public void testRace()
	{
		CalculateTrackScores track = CalculateTrackScores.valueOf("SPRINT_1500M");
		assertEquals(1000, track.calculateTrackScore(233.79));
	}
}
