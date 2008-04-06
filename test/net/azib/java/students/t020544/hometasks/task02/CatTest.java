package net.azib.java.students.t020544.hometasks.task02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CatTest
 * 
 * @author Julija Kondratjeva
 */
public class CatTest {

	Cat c = new Cat("Kitty", 2, "black");

	/**
	 * Test method for
	 * {@link net.azib.java.students.t020544.hometasks.task02.Cat#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("I am black Cat Kitty, I am 2 old. Mau!", c.toString());
	}

}
