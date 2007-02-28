package net.azib.java.students.t010687;
//import junit.framework.TestCase;
import static org.junit.Assert.*;

import junit.framework.TestResult;

import org.junit.Before;
import org.junit.Test;
/**
 * ConcatenatorTest
 *
 * @author t010687
 */
public class ConcatenatorTest {
	
	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		// TODO Auto-generated method stub
		Concatenator TestConc = new Concatenator();
		
		assert "abc123".equals(TestConc.Concat("abc", "123"));
	}*/
	@Before
	public void testStmhBefore() {
		
	}
	@Test
	public void testConcat() {
		Concatenator TestConc = new Concatenator();
		assertEquals("concat() failed", "abc123", TestConc.Concat("abc", "123"));
	}
	
	@Test
	public void testNullConcat(){
		Concatenator TestConc = new Concatenator();
		assertEquals("testNullConcat() failed", "abc", TestConc.Concat("abc",null));
		assertEquals("testNullConcat() failed", "abc", TestConc.Concat(null,"abc"));
		assertEquals("testNullConcat() failed", null, TestConc.Concat(null,null));
	}
	
	
}
