package net.azib.java.students.t020544.hometasks.task03;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DuplicateRemoverImplTest
 *
 * @author Julija Kondratjeva
 */
public class DuplicateRemoverImplTest {
	
	DuplicateRemoverImpl d = new DuplicateRemoverImpl();
	private String[] arrIn = new String[] { "one", "two", "three", "one", "two" };
	private String[] arrOut = new String[] { "one", "two", "three" };
	

	/**
	 * Test method for {@link net.azib.java.students.t020544.hometasks.task03.DuplicateRemoverImpl#removeDuplicateStrings(java.lang.String[])}.
	 */
	@Test
	public void testRemoveDuplicateStrings() {
		assertArrayEquals(arrOut, d.removeDuplicateStrings(arrIn));
	}

}
