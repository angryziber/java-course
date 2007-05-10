package net.azib.java.students.t020556.homework.test;

import static org.junit.Assert.*;

import net.azib.java.students.t020556.homework.DecathlonResultDataBaseReader;

import org.junit.Before;
import org.junit.Test;

/**
 * DecathlonResultDataBaseReaderTest
 *
 * @author agu
 */
public class DecathlonResultDataBaseReaderTest {
	
	DecathlonResultDataBaseReader dbr = new DecathlonResultDataBaseReader();

	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#initConnection(
	 * 			java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Before
	@Test
	public void testInitConnection() {
		dbr.initConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		assertNotNull(dbr.readResults());
	}
	
	/**
	 * Test method for 
	 * {@link net.azib.java.students.t020556.homework.
	 * 		DecathlonResultDataBaseReader#releaseConnection()}.
	 */
	public void testReleaseConnection(){
		dbr.releaseConnection();
		assertNull(dbr.readResults());
	}

}
