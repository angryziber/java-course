package net.azib.java.students.t030647.homework.tests;

import net.azib.java.students.t030647.homework.Competitor;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * TestCompetitor
 *
 * @author Igor
 */
public class CompetitorTest {
	
	@Test
	public void testCompetitor() throws Exception {
		
		String main = "Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:72";
		int result = 4231;
		Competitor a = new Competitor("Siim Susi,01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
		assertEquals(main, a.toString());
		assertEquals(result, a.getResult());
	}
	
}
