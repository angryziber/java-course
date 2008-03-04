package net.azib.java.students.t030633.hometasks;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * DuplicateRemoverImplTest
 * 
 * @author t030633
 */
public class DuplicateRemoverImplTest {

	/**
	 * Test method for
	 * {@link net.azib.java.students.t030633.hometasks.DuplicateRemoverImpl#removeDuplicateStrings(java.lang.String[])}.
	 */
	@Test
	public void testRemoveDuplicateStrings() {
		
		DuplicateRemoverImpl dupRem = new DuplicateRemoverImpl();
		String[] stringsIn = new String[] { "pong", "ping", "ping", "ping", "pong" };
		String[] stringsOut = new String[] { "pong", "ping" };

		assertArrayEquals(stringsOut, dupRem.removeDuplicateStrings(stringsIn));
		
	}

}
