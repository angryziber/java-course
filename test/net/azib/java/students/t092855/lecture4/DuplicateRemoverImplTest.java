package net.azib.java.students.t092855.lecture4;


import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DuplicateRemoverImplTest {

	@Test
	public void removeDuplicateStringsFromTwoStringArrays() {
		String[] original = {"Dog", "Cat", "Dog", "Alligator", "Parrot", "Alligator", "Dog"};
		String[] expected = {"Dog", "Cat", "Alligator", "Parrot"};
		assertArrayEquals(expected, new DuplicateRemoverImpl().removeDuplicateStrings(original));
	}

	@Test
	public void arrayWithOneElement() {
		String[] original = {"Dog"};
		String[] expected = {"Dog"};
		assertArrayEquals(expected, new DuplicateRemoverImpl().removeDuplicateStrings(original));
	}

	@Test
	public void arrayWithTwoEqualElements() {
		String[] original = {"Dog", "Dog"};
		String[] expected = {"Dog"};
		assertArrayEquals(expected, new DuplicateRemoverImpl().removeDuplicateStrings(original));
	}

	@Test
	public void emptyArray() {
		String[] original = {""};
		String[] expected = {""};
		assertArrayEquals(expected, new DuplicateRemoverImpl().removeDuplicateStrings(original));
	}


}
