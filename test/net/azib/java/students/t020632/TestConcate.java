package net.azib.java.students.t020632;

import static org.junit.Assert.*;
import org.junit.Before;

import org.junit.Test;

/**
 * TestConcate
 *
 * @author t020632
 */
public class TestConcate {

	/**
	 * @param args
	 */
	
	private Concatenator020632 c;
	
	@Before
	public void setUp(){
		c = new Concatenator020632();
	}
	
	@Test
	public void testConcat() {
		
		assertEquals("concate() fails", "abc123", c.concate("abc", "123"));

	}
	
	@Test
	public void testname() throws Exception {
		
		assertEquals("abc", c.concate("abc", null));
	}

}
