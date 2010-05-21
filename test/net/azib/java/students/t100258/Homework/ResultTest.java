package net.azib.java.students.t100258.Homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ResultTest
 *
 * @author mihkel
 */
public class ResultTest {

	/**
	 * Test method for {@link net.azib.java.students.t100258.Homework.Result#Result(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, int)}.
	 */
	@Test
	public void testResult() {
		Result result= new Result("Mingi Nimi" ,"0000-00-00" ,"EE" ,new Float(14.15) ,new Float(3.98) ,new Float(10.0) ,new Float(1.45) ,"70.12" ,new Float(18.65) ,new Float(29.15) ,new Float(2.15) ,new Float(32.67) ,"466.6", 0, 0);
		assertEquals("Name", "Mingi Nimi", result.name);
		assertEquals("Date", "0000-00-00", result.date);
		assertEquals("Country", "EE", result.country);
		assertEquals("Sprint 100 m", 14.15, result.sprint_100);
		assertEquals("Long Jump", 3.98, result.long_jump);
		assertEquals("Short Put", 10.0, result.short_put);
		assertEquals("High Jump", 1.45, result.high_jump);
		assertEquals("Sprint 400 m", "70.12", result.sprint_400);
		assertEquals("Hurdles 110 m", 18.65, result.hurdles);
		assertEquals("Discus Throw", 29.15, result.discus_throw);
		assertEquals("Pole Vault", 2.15, result.pole_vault);
		assertEquals("Jevelin Throw", 32.67, result.jevelin_throw);
		assertEquals("Race", "466.6", result.race);
		assertEquals("Total", 0, result.sum);
		assertEquals("Place", 0, result.place);
		
	}

}
