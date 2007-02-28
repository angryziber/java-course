package net.azib.java.lessons.misc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * ConcatenatorTest
 *
 * @author anton
 */
public class ConcatenatorTest {
	
	private Concatenator c;

	@Before
	public void setUp() {
		c = new Concatenator();		
	}

	@Test
	public void testConcat() {
		assertEquals("abc123", c.concatenate("abc", "123"));
	}
	
	@Test
	public void testNullsInConcat() throws Exception {
		assertEquals("abc", c.concatenate("abc", null));
		assertEquals("def", c.concatenate(null, "def"));
		assertEquals(null, c.concatenate(null, null));
	}
	

}
