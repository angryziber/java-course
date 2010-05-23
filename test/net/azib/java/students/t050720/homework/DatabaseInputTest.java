package net.azib.java.students.t050720.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test database input
 *
 * @author Marek
 */
public class DatabaseInputTest {
	
	/**
	 * Test reading database connection properties
	 */
	@Test
	public void testReadProps()
	{
		try {
			DatabaseInput dbi=new DatabaseInput("2");
			assertEquals(true, dbi!=null);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
	}
	
	/**
	 * Test actual reading from database.
	 */
	@Test
	public void testData() {
		ArrayList<Record> records = new ArrayList<Record>();
		try {
			DatabaseInput dbi= new DatabaseInput("1");
			dbi.readInto(records);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		assertEquals(false, records.isEmpty());
		
	}
}
