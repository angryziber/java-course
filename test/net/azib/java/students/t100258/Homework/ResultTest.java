package net.azib.java.students.t100258.Homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ResultTest
 *
 * @author mihkel
 */
public class ResultTest {

	/**
	 * Test method for {@link net.azib.java.students.t100258.Homework.Result#Result(java.lang.String, java.lang.String, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.Float, java.lang.String, int, int)}.
	 */
	@Test
	public void testResult() {
		// Didn't compile!!!   
		// Mihkel: Compiled on Eclipse 3.2.2 (latest on Debian repository) without warnings. So I didn't notice the need to box/unbox things.
		Result result= new Result("Mingi Nimi" ,"0000-00-00" ,"EE" ,new Float(14.15) ,new Float(3.98) ,new Float(10.0) ,new Float(1.45) ,"70.12" ,new Float(18.65) ,new Float(29.15) ,new Float(2.15) ,new Float(32.67) ,"466.6", 0, 0);
		assertEquals("Name", "Mingi Nimi", result.name);
		assertEquals("Date", "0000-00-00", result.date);
		assertEquals("Country", "EE", result.country);
		assertEquals("Sprint 100 m", 14.15, result.sprint_100, 0.0001);
		assertEquals("Long Jump", (Object)3.98f, result.long_jump);
		assertEquals("Short Put", (Object)10.0f, result.short_put);
		assertEquals("High Jump", (Object)1.45f, result.high_jump);
		assertEquals("Sprint 400 m", "70.12", result.sprint_400);
		assertEquals("Hurdles 110 m", (Object)18.65f, result.hurdles);
		assertEquals("Discus Throw", (Object)29.15f, result.discus_throw);
		assertEquals("Pole Vault", (Object)2.15f, result.pole_vault);
		assertEquals("Jevelin Throw", (Object)32.67f, result.jevelin_throw);
		assertEquals("Race", "466.6", result.race);
		assertEquals("Total", (Object)0, result.sum);
		assertEquals("Place", (Object)0, result.place);
		
	}

}
