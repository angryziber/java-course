package net.azib.java.students.t040719.lessons;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * DuplicateRemoverImplTest
 *
 * @author Romi
 */
public class DuplicateRemoverImplTest {

	/**
	 * Test method for {@link net.azib.java.students.t040719.lessons.DuplicateRemoverImpl#removeDuplicateStrings(java.lang.String[])}.
	 */
	@Test
	public void testRemoveDuplicateStrings() {
		DuplicateRemoverImpl dupRem = new DuplicateRemoverImpl();
		String[] test = new String[] {"koer","kass","kass","siga","koer"};
		String[] result = new String[] {"koer","kass","siga"};
		assertArrayEquals(result, dupRem.removeDuplicateStrings(test));
	}

}
