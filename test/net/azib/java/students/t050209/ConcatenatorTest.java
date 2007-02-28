package net.azib.java.students.t050209;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*import junit.framework.TestCase;  JUnit 3 jaoks*/

/**
 * ConcatenatorTest
 *
 * @author t050209
 */
/*public class ConcatenatorTest {
	public static void main(String[] args) {
		Concatenator c = new Concatenator();
		
		assert "abc123".equals(c.concatenate("abc", "123"));
	}
}*/

/* JUnit 3  - Run as JUnit Test, maini ju pole*/
/*public class ConcatenatorTest extends TestCase{
	public void testConcat() {
		Concatenator c = new Concatenator();
		
		assertEquals("concatenate() failed", "abc123", c.concatenate("abc", "123"));
	}*/

public class ConcatenatorTest{
	private Concatenator c;
	
	@Before
	public void setUp() {
		c = new Concatenator(); 
	}
	
	@Test
	public void testConcat() {		
		assertEquals("concatenate() failed", "abc123", c.concatenate("abc", "123"));
	}
	
/*	@Test  Test suure tähega, siis Ctrl+Space
	public void testname() throws Exception {
		
	}*/
	
	@Test
	public void testNullsInConcat() throws Exception {		
		assertEquals("concatenate() failed", "abc", c.concatenate("abc", null));
		assertEquals("concatenate() failed", "def", c.concatenate(null, "def"));
		assertEquals("concatenate() failed", null, c.concatenate(null, null));
	}
}