package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DogTest
 *
 * @author Romi
 */
public class DogTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Dog#toString()}.
	 */
	@Test
	public void testToString() {
		Dog dog = new Dog("Miki","Alaskan Malamut",(byte)2,78);
		String s = "Animal: Dog\nBreed: Alaskan Malamut\nName: Miki\nAge: 2\nBarking loudness: 78 dB";
		assertEquals(s, dog.toString());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Dog#getBarkingLoudness()}.
	 */
	@Test
	public void testGetBarkingLoudness() {
		Dog dog = new Dog("Miki","Alaskan Malamut",(byte)2,78);
		int i = 78;
		assertEquals(i, dog.getBarkingLoudness());
	}

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.Dog#changeBarkingLoudness(int)}.
	 */
	@Test
	public void testChangeBarkingLoudness() {
		Dog dog = new Dog("Miki","Alaskan Malamut",(byte)2);
		assertEquals(true, dog.changeBarkingLoudness(78));
	}

}
