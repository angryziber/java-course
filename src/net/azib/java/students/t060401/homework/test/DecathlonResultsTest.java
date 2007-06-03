package net.azib.java.students.t060401.homework.test;

import static org.junit.Assert.*;

import net.azib.java.students.t060401.homework.decathlon.DecathlonResults;

import org.junit.Before;
import org.junit.Test;

/**
 * DecathlonResultsTest
 * 
 * @author t060401
 */
public class DecathlonResultsTest {

	DecathlonResults results;

	@Before
	public void createAthlete() {
		results = new DecathlonResults();
	}

	@Test
	public void testSetSprint100m() throws Exception {
		try{
			results.setSprint100m("");
			fail("IllegalArgumentException should have been thrown when parameter is empty");
		} 
		catch (IllegalArgumentException e)
		{
			
		}
		assertEquals("", -1.0 , results.getSprint100m());
		
		results.setSprint100m("12.61");
		double expected = 12.61;
		assertEquals("", expected , results.getSprint100m());
		
		results.setSprint100m("8");
		expected = 8;
		assertEquals("", expected , results.getSprint100m());
	}
	
	@Test
	public void testSetSprint400m() throws Exception {
		try{
			results.setSprint400m("");
			fail("IllegalArgumentException should have been thrown when parameter is empty");
		} 
		catch (IllegalArgumentException e)
		{
			
		}
		
		try{
			results.setSprint400m("-7");
			fail("IllegalArgumentException should have been thrown when parameter is negative");
		} 
		catch (IllegalArgumentException e)
		{
			//expected
		}
		assertEquals("", -1.0 , results.getSprint400m());
		
		results.setSprint400m("12.61");
		double expected = 12.61;
		assertEquals("", expected , results.getSprint400m());
		
		results.setSprint400m("8");
		expected = 8;
		assertEquals("", expected , results.getSprint400m());
		
		results.setSprint400m("1:18.04");
		expected = 78.03999999999999;
		assertEquals("", expected , results.getSprint400m());
	}
}
