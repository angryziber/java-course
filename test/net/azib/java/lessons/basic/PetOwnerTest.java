package net.azib.java.lessons.basic;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.*;

public class PetOwnerTest {
	private PetOwner petOwner = new PetOwner();
	private Pet pet = mock(Pet.class);

	@Test
	public void petOwnerDoesntHavePets() {
	    assertEquals(0, petOwner.getPetCount());
	}

	@Test
	public void ownerOfOnePet() {
		petOwner.buy(pet);
		assertEquals(1, petOwner.getPetCount());
		assertSame(pet, petOwner.getPet(1));
	}

	@Test
	public void ownerNamesAPet() {
		when(pet.rename(anyString())).thenReturn(pet);

		petOwner.buy(pet, "Pluto");

		verify(pet).rename("Pluto");
		assertSame(pet, petOwner.getPet(1));
	}
}
