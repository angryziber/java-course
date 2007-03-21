package net.azib.java.students.t050657;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * RegexStuffTest
 *
 * @author t050657
 */
public class RegexStuffTest {

	@Test
	public void testMatches() throws Exception{
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("koer".matches("[a-z]{3}"));
		assertFalse("a dog foo".matches("^dog$"));
	}
	
	@Test
	public void testReplase() throws Exception {
		assertEquals("dag", "dog".replace('o', 'a'));
		assertEquals("dXXXg", "daeog".replaceAll("[eoa]", "X"));
	}
	
	@Test
	public void testSplit() throws Exception {
		String[] s = "Hello abc test".split("\\s+");
		assertEquals(s.length, 3);
	}
	
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("a(.)c");
		Matcher m = p.matcher("babc");
		assertTrue(m.find());
		assertEquals("abc", m.group());
		assertEquals(1, m.start());
		System.out.println(m.find());
	}
	
	
}
