package net.azib.java.students.t050657;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//import junit.framework.TestCase;  JUnit 3 testCase!!!

/**
 * ConcatenatorTest
 *
 * @author t050657
 */
public class ConcatenatorTest{
	
	private Concatenator c;
	
	/*			// written 
	public static void main(String[] args) {
		Concatenator c = new Concatenator();
		
		assert "aaa123".equals(c.concat("aaa", "123"))
			: "concat() failed";
	}
	*/
	
	/*			// JUnit 3 testCase !!!
	public void testConcat() {
		Concatenator c = new Concatenator();
		assertEquals("concat() failed", "aaa123", c.concat("aaa", "123")); 
	}
	*/
	
	@Before
	public void setUp() {
		c = new Concatenator();
	}
	
	@Test
	public void testConcat() {
		assertEquals("concat() failed", "aaa123", c.concat("aaa", "123"));
	}
	
	@Test
	public void testNullConcat() throws Exception {
		assertEquals("concat() failed", "aaa", c.concat("aaa", null));
		assertEquals("concat() failed", "aaa", c.concat(null, "aaa"));
		assertEquals("concat() failed", null, c.concat(null, null));
	}

}
