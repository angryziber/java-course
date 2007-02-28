package net.azib.java.students.t030656;

import static org.junit.Assert.*;
import org.junit.*;


/**
 * ConcantanateTest
 *
 * @author t030656
 */
public class ConcantanateTest{

/**
 * tests concantanation class
 */
	
	private Concantenator con;
	
	@Before
	public void setUp(){
		con = new Concantenator();
	}
	
	@Test
	public void testConcat() {
		assertEquals("Failed!", "abc123", con.concanate("abc", "123"));
	}

	@Test
	public void testNullsInConcat() throws Exception {
		assertEquals("abc", con.concanate("abc", null));		
		assertEquals("def", con.concanate(null, "def"));
		assertEquals(null, con.concanate(null, null));
	}
}
