package net.azib.java.students.t092859.hometask4;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DuplicateRemoverImplTest
 *
 * @author kostya
 */
public class DuplicateRemoverImplTest {
	DuplicateRemoverImpl duplicateRemover = new DuplicateRemoverImpl();
		
	@Test
	public void DuplicateRemoving() throws Exception {
		String[] reply = duplicateRemover.removeDuplicateStrings(new String[]{"test", "test1", "test2", "test"});
		assertArrayEquals(new String[]{"test", "test1", "test2"}, reply);
	}
}
