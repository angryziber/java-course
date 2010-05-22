package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Test for the console input class. 
 * This test is not that good a unit test as it requires an user to hit Enter to complete, and simply
 * tests for object creation/addition. Could be done better with simulating console input.
 *
 * @author Marek
 */
public class ConsoleInputTest {

	/**
	 * Test method for {@link net.azib.java.students.t050720.homework.ConsoleInput#readInto(java.util.ArrayList)}.
	 */
	@Test
	public void testReadInto() {
		ArrayList<Record> records = new ArrayList<Record>();
		ConsoleInput ci=new ConsoleInput();
		try {
			ci.readInto(records);
		}
		catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown!");
		}
		
		assertEquals(false, records.isEmpty());
	}

}
