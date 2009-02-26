package net.azib.java.lessons.basic;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DogTest
 *
 * @author anton
 */
public class DogTest {
	@Test
	public void createdWithCorrectName() throws Exception {
		Dog d = new Dog("Muku", 0);
		assertEquals("Muku", d.name);
	}
}
