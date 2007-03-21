package net.azib.java.students.t030656;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;



/**
 * RegexpTest
 *
 * @author t030656
 */
public class RegexpTest {

	@Test
	public void testMatches() throws Exception{
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("koer".matches("[a-z]{3}"));
	}
	
	@Test
	public void testReplace() throws Exception {
		assertEquals("dag", "dog".replaceAll("o", "a"));

	}
	
	@Test
	public void testSplit() throws Exception {
		String[] s = "Hello abc def".split("\\s+");
		assertEquals(3, s.length);	
	}
	
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("a(.)c");
		Matcher m = p.matcher("babc");
		
		assertTrue(m.find());
		assertEquals("abc", m.group());
		assertEquals("b", m.group(1));
		assertEquals(1, m.start());
		
		
	}
	
}

