package net.azib.java.students.t020544;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * ConcatenatorTest
 * 
 * @author Julija Kondratjeva
 */
public class ConcatenatorTest {

	private Concatenator c;

	@Before
	public void setUp() {
		c = new Concatenator();
	}

	@Test
	public void testConcat() {

		assertEquals("concatenate() faild ", "abc123", c.concatenate("abc", "123"));

	}

	@Test
	public void testNullConcat() throws Exception {

		assertEquals("abc", c.concatenate("abc", null));
		assertEquals("gfd", c.concatenate(null, "gfd"));
		assertEquals(null, c.concatenate(null, null));

	}
}
