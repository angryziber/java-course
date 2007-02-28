package net.azib.java.students.t011047;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ConcatenatorTest
 * 
 * @author t011047
 */
public class ConcatenatorTest {
	// this is a simple test case
	@Test
	public void testConcat() {
		Concatenator c = new Concatenator();
		assertEquals("concat() failed!", "abc123", c.concat("abc", "123"));
	}
}