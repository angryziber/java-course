package net.azib.java.students.t104607;
// @author 104607 IASM

import org.junit.Test;

import static org.junit.Assert.*;

public class DuplicateRemoverImplTest {
	@Test
	public void testRemoveDuplicateStrings() throws Exception {
		String[] stringArray = {"dog","cat","frog","dog"};
		DuplicateRemoverImpl remover = new DuplicateRemoverImpl();
		String[] result = remover.removeDuplicateStrings(stringArray);
		assertEquals(3,result.length);
	}
}
