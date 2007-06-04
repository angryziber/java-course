package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import net.azib.java.students.t020556.homework.DecathlonResultDataBaseReader;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * DecathlonResultDataBaseReaderTest
 *
 * @author agu
 */
public class DecathlonResultDataBaseReaderTest {
	
	private static DecathlonResultDataBaseReader dbr = new DecathlonResultDataBaseReader();

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#initConnection(
	 * 			java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@BeforeClass
	public static void testInitConnection() {
		dbr.initConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		assertNotNull(dbr.readResults());
	}
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#getCompetitions()}
	 * 
	 * and
	 * 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#setCompetitionId(Number)}
	 */
	@Test
	public void testCompetitions(){
		try {
			ResultSet rs = dbr.getCompetitions();
			assertNotNull(rs);
			assertTrue(rs.last());
			
			int lastCompetition = rs.getInt("id");
			
			dbr.setCompetitionId(lastCompetition + 1);
			assertTrue(dbr.readResults().size() == 0);
			
			dbr.setCompetitionId(lastCompetition);
			assertTrue(dbr.readResults().size() > 0);
		}
		catch (SQLException e) {
			fail("Unable to iterate through competitions");
		}
	}

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#releaseConnection()}.
	 */
	@AfterClass
	public static void testReleaseConnection(){
		dbr.releaseConnection();
		assertTrue(dbr.readResults().size() == 0);
	}

}
