package net.azib.java.lessons.basic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PetTest {
	@Test
	public void renameCopiesAnImmutablePet() {
	    Pet pet = new Pet("") {};
		Pet pluto = pet.rename("Pluto");
		assertEquals("Pluto", pluto.getName());
	}
}
