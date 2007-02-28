package net.azib.java.students.t030655.Lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * ConcatenatorTest
 *
 * @author Triin
 */
public class ConcatenatorTest {
	private Concatenator c;
	
	// this is a simple test case
	
	@Before
	public void setUp(){
		c = new Concatenator();
	}
	
	@Test	
	public void testConcat() {

		assertEquals("concatenate() failed!", "abc123", c.concatenate("abc", "123"));
	}
	@Test
	public void testNullsInConcat() throws Exception {

		assertEquals("abc", c.concatenate("abc", null));
		assertEquals("def", c.concatenate(null, "def"));
		assertEquals(null, c.concatenate(null, null));
	}

}
