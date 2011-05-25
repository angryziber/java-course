package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.io.File;
import java.sql.SQLException;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DBReaderTest {

	/**
	 * Tests if data is valid in db.properties class and if it is being read correctly
	 * @throws SQLException when something goes wrong with properties
	 */

	@Test
	public void DBPropertiesTest() throws SQLException {
        assertTrue(new File(DBReader.class.getResource("db.properties").getPath()).exists());


		Properties prop = new DBReader().getProperties();

		  assertEquals("jdbc:mysql://java.azib.net:3306/decathlon", prop.getProperty("url"));
		  assertEquals("java", prop.getProperty("username"));
		  assertEquals("java", prop.getProperty("password"));
    }
}
