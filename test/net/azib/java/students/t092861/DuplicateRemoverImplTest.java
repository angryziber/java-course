/**
 * 
 */
package net.azib.java.students.t092861;

import static org.junit.Assert.*;

import net.azib.java.students.t092861.lecture4.DuplicateRemoverImpl;

import org.junit.Test;

/**
 * @author Stanislav / 092861
 *
 */
public class DuplicateRemoverImplTest {
	DuplicateRemoverImpl dri = new DuplicateRemoverImpl();


	@Test
	public void removeDuplicateStringsFromArray() {
		String[] actual = {"D", "B", "B", "Aa", "Ab", "A", "A"};
		String[] expected = {"D", "B", "Aa", "Ab", "A"};
		assertArrayEquals(expected, dri.removeDuplicateStrings(actual));
	}
	
	@Test
	public void removeDuplicateStringsFromArrayOfOneString() {
		String[] actual = {"D"};
		String[] expected = {"D"};
		assertArrayEquals(expected, dri.removeDuplicateStrings(actual));
	}
	
	@Test
	public void removeDuplicateStringsFromArrayOfSameStrings() {
		String[] actual = {"Be", "Be"};
		String[] expected = {"Be"};
		assertArrayEquals(expected, dri.removeDuplicateStrings(actual));
	}
	
	@Test
	public void removeDuplicateStringsFromArrayOfNoStrings() {
		String[] actual = {};
		String[] expected = {};
		assertArrayEquals(expected, dri.removeDuplicateStrings(actual));
	}
	
	

}
