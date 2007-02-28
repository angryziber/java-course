package net.azib.java.students.t020648;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import net.azib.java.students.t020648.Concatenator;

/**
 * ConcatenatorTest
 *
 * @author t020648
 */
public class ConcatenatorTest{
	
	Concatenator c = null;
	 
	@Before
	public void setUp(){
		c = new Concatenator();
	}
	
	@Test 
	 public void testConcat() {		
		assertEquals("concat() failed!", "abc123", c.concat("abc", "123"));
	}	

	@Test
	public void testNullsConcat(){
		assertEquals("concat() failed!", "nullnull" , c.concat(null, null));
	}
	 
}
