package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * DatabaseInputTest
 *
 * @author Raigo
 */
public class DatabaseInputTest {

	InputAthletesFromDatabase in = new InputAthletesFromDatabase();
	
	@Test
	public void testCompetitionId()
	{	
		assertEquals(null, in.getAthletesFromDatabase(""));
	}	
}
