package net.azib.java.students.t092877.lecture3;


import net.azib.java.students.t092877.lecture3.Dog;
import net.azib.java.students.t092877.lecture3.Pet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetTest {

	@Test
	public void testHasAnOwner() {
		boolean hasAnOwner = true;
		Pet dog = new Dog("Dog", 6, "male", "Canidae", "least concern", "Snipe", hasAnOwner, "Alaskan Malamute");

		assertEquals("has an owner", dog.hasAnOwner());
	}
}
