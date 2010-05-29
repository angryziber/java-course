package net.azib.java.students.t100258.homework;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t100258.homework.Result;

import org.junit.Test;

/**
 * ResultTest
 *
 * @author mihkel
 */
public class ResultTest {

	/**
	 * Test method for {@link net.azib.java.students.t100258.homework.Result#Result(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, int, int)}.
	 */
	@Test
	public void testResult() {
		Result result= new Result("Mingi Nimi" ,"0000-00-00" ,"EE" ,new Float(14.15) ,new Float(3.98) ,new Float(10.0) ,new Float(1.45) ,"70.12" ,new Float(18.65) ,new Float(29.15) ,new Float(2.15) ,new Float(32.67) ,"466.6", 0, 0);
		assertEquals("Name", "Mingi Nimi", result.name);
		assertEquals("Date", "0000-00-00", result.date);
		assertEquals("Country", "EE", result.country);
		assertEquals("Sprint 100 m", 14.15f, result.sprint_100, 0.001);
		assertEquals("Long Jump", 3.98f, result.long_jump, 0.001);
		assertEquals("Short Put", 10.0f, result.short_put, 0.001);
		assertEquals("High Jump", 1.45f, result.high_jump, 0.001);
		assertEquals("Sprint 400 m", "70.12", result.sprint_400);
		assertEquals("Hurdles 110 m", 18.65f, result.hurdles, 0.001);
		assertEquals("Discus Throw", 29.15f, result.discus_throw, 0.001);
		assertEquals("Pole Vault", 2.15f, result.pole_vault, 0.001);
		assertEquals("Jevelin Throw", 32.67f, result.jevelin_throw, 0.001);
		assertEquals("Race", "466.6", result.race);
		assertEquals("Total", 0, result.sum);
		assertEquals("Place", 0, result.place);
		
	}

}
