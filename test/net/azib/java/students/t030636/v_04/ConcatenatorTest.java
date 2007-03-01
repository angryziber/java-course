package net.azib.java.students.t030636.v_04;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * ConcatenatorTest
 *
 * @author Martin
 */
public class ConcatenatorTest {
	private Concatenator c;

	/**
	 * @param args
	 */
	@Before
	public void setUp() {
		c = new Concatenator();
	}
	
	@Test
	public void testConcat() {
		assertEquals( "concat() failed!", "abc123", c.concatenate("abc", "123"));
	}
	
	@Test
	public void testNullsInConcat() throws Exception {
		assertEquals("concat() failed!", "abc", c.concatenate("abc", null));
		assertEquals("concat() failed!", "def", c.concatenate(null, "def"));
		assertEquals("concat() failed!", null, c.concatenate(null, null));
		
	}
	

}
