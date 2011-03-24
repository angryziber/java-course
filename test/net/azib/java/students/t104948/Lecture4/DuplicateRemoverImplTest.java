package net.azib.java.students.t104948.Lecture4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DuplicateRemoverImplTest {
	@Test
	public void someLetters(){
		String[] expectedValues = {"A", "B", "C", "D"};
	    String[] testValues = {"A", "B", "B", "A", "C", "B", "D", "A", "D"};
	    String[] actualValues = new DuplicateRemoverImpl().removeDuplicateStrings(testValues);
		int i = 0;
		for(String expected: expectedValues){
			assertEquals(expected, actualValues[i++]);
		}
	}

	@Test
	public void someWords(){
		String[] expectedValues = {"sky", "car", "dog", "fish"};
	    String[] testValues = {"sky", "car", "dog", "dog", "sky", "car", "dog", "fish", "fish"};
		String[] actualValues = new DuplicateRemoverImpl().removeDuplicateStrings(testValues);
	    int i = 0;
		for(String expected: expectedValues){
			assertEquals(expected, actualValues[i++]);
		}
	}

}
