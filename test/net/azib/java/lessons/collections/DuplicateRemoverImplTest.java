package net.azib.java.lessons.collections;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * DuplicateRemoverImplTest
 *
 * @author anton
 */
public class DuplicateRemoverImplTest {
	
	private DuplicateRemover remover;

	@Before
	public void init() {
		remover = new DuplicateRemoverImpl();
	}
	
	private void assertResult(String[] expected, String ...input) {
		String[] result = remover.removeDuplicateStrings(input);
		assertArrayEquals(expected, result);
	}

	@Test
	public void happyPath() throws Exception {
		assertResult(new String[] {"a", "b"}, "a", "b", "b");
	}
	
	@Test
	public void outputInSameOrderAsInput() throws Exception {
		assertResult(new String[] {"a", "c", "b"}, "a", "c", "b", "a", "b");
	}
	
	@Test
	public void emptyInput() throws Exception {
		assertResult(new String[0]);
	}
	
}
