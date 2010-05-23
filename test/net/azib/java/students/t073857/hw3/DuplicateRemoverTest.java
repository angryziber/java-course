package net.azib.java.students.t073857.hw3;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/**
 * DuplicateRemoverTest
 *
 * @author Joonas Vali
 */
public class DuplicateRemoverTest {
	@Test
	public void testOverall() throws Exception {
		String[] s = {"oo", "aaa", "bbb", "ccc", "aaa", "fff", "ggg", "ggg", "aaa", "bbb"};
		s = new DuplicateRemoverImpl().removeDuplicateStrings(s);
		String[] exp = {"oo", "aaa", "bbb", "ccc", "fff", "ggg"};
		assertArrayEquals("String array mismatch:", exp, s);		
	}

}
