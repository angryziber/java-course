package net.azib.java.students.t040750.homework.main;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * DecathlonPropertiesTest
 *
 * @author karpo
 */
public class DecathlonPropertiesTest {

	private DecathlonProperties props;
	
	/**
	 * Already tests the constructor
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		props = new DecathlonProperties(DecathlonDemo.class.getResourceAsStream("db.properties"));
	}

	@Test
	public void testGetProperty() throws Exception {
		assertEquals("com.mysql.jdbc.Driver", props.getProperty("driver"));
	}
	
}
