package net.azib.java.students.t020544;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * DogTest
 * 
 * @author Julija Kondratjeva
 */
public class DogTest {
	
	private Dog dog;
	
	@Before
	public void setUp() {
		dog = new Dog("Deik", (byte) 3);
	}
	

	/**
	 * Test method for {@link net.azib.java.students.t020544.Animal#getName()}.
	 */
	@Test
	public void testGetName() {
		assertEquals("testGetName() failed", "Deik", dog.getName());
	}

	/**
	 * Test method for {@link net.azib.java.students.t020544.Animal#growUp()}.
	 */
	@Test
	public void testGrowUp() {
		dog.growUp();
		assertEquals("testGrowUp() failed", (byte)4, dog.getAge());
	}

	/**
	 * Test method for {@link net.azib.java.students.t020544.Animal#getAge()}.
	 */
	@Test
	public void testGetAge() {
		assertEquals("testGetAge() failed",(byte)3, dog.getAge());
	}
	/**
	 * Test method for {@link net.azib.java.students.t020544.Animal#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		assertEquals("testGetAge() failed",2126211, dog.hashCode());
	}
	

}
