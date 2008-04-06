package net.azib.java.students.t020544.hometasks.task02;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DogTest
 *
 * @author Julija Kondratjeva
 */
public class DogTest {
	
	Dog d = new Dog("Doggy", 3, "John");

	/**
	 * Test method for {@link net.azib.java.students.t020544.hometasks.task02.Dog#toString()}.
	 */
	@Test
	public void testToString() {
		assertEquals("I am John's Dog Doggy, I am 3 old. Bark!", d.toString());
	}

}
