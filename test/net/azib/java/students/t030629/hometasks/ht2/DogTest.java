package net.azib.java.students.t030629.hometasks.ht2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DogTest
 *
 * @author anton_chepurov
 */
public class DogTest {
	
	@Test
	public void testCanFly(){
		
		assertEquals("Flying Dog found", false, new Dog("Rizoletto", (byte) 33, 4).canFly());
		assertEquals("Flying Dog found", false, new Dog("Rizy", (byte) 1, 4).canFly());
		assertEquals("Flying Dog found", false, new Dog("", (byte) 0, 3).canFly());
		
	}

	@Test
	public void testGetAnimalClass(){
		
		assertEquals("A Dog does not belongs to MAMMAL AnimalClass", AnimalClass.MAMMAL, new Dog("Rizoletto", (byte) 33, 4).getAnimalClass());
		assertEquals("A Dog does not belongs to MAMMAL AnimalClass", AnimalClass.MAMMAL, new Dog("", (byte) 0, 3).getAnimalClass());		
		
	}
	
	@Test
	public void testGetAdditionalInfo(){
		
		assertEquals("A fast running 3-legged Dog found. Inform the sport commune :-)",
				"Runs slow. May bite though!", 
				new Dog("Rizoletto", (byte) 33, 3).getAdditionalInfo());
		assertEquals("A slow running 4-legged Dog found.",
				"Runs fast! Be careful!", 
				new Dog("Rizoletto", (byte) 33, 4).getAdditionalInfo());
		
	}

}
