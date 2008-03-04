package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DogTest
 * 
 * @author t030633
 */
public class DogTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Dog#makeSound()}.
	 */
	@Test
	public void testMakeSound() {
		Animal dog = new Dog();
		String sound = "Woof!";
		assertEquals(sound, dog.makeSound());
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.Animal#toString()}.
	 */
	@Test
	public void testToString() {
		Animal dog = new Dog("Laika", 1);
		String string = "I am a Dog, my name is Laika and i go: Woof!";
		assertEquals(string, dog.toString());
	}

}
