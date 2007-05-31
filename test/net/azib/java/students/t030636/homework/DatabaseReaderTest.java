package net.azib.java.students.t030636.homework;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * DatabaseReaderTest
 *
 * @author Martin
 */
public class DatabaseReaderTest {
	DatabaseReader dbr = new DatabaseReader();
	
	@Test
	public void testInitializeConnection() throws Exception {
		dbr.initializeConnection("jdbc:mysql://srv.azib.net/decathlon", "java", "java");
		assertNotNull(dbr.readDatabase("1"));
	}
}


