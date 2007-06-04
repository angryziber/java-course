package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * DecathlonDatabaseReaderTest
 *
 * @author Triin Nestor
 */
public class DecathlonDatabaseReaderTest {
	private static DecathlonDatabaseReader dbReader = new DecathlonDatabaseReader();
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonDatabaseReader#setConnection}
	 * {@link net.azib.java.students.t030655.homework.DecathlonDatabaseReader#readDatabase}
	 * 
	 */
	@Test
	public void testSetConnection(){
		dbReader.setConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		assertNotNull(dbReader.readDatabase());
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonDatabaseReader#displayCompetitions()}
	 * {@link net.azib.java.students.t030655.homework.DecathlonDatabaseReader#setCompetitionId(int)}
	 * 
	 */
	@Test
	public void testCompetitionId (){
		dbReader.setCompetitionId(2);
		assertNotNull(dbReader.readDatabase());
		
		dbReader.setCompetitionId(5);
		assertTrue(dbReader.readDatabase().size() == 0);
		
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.DecathlonDatabaseReader#closeConnection()}
	 * 
	 */
	@Test
	public void testCloseConnection(){
		dbReader.closeConnection();
		assertNull(dbReader.readDatabase());
	}

}
