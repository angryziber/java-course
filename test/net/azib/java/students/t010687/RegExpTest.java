package net.azib.java.students.t010687;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;




/**
 * RegExpTest
 *
 * @author t010687
 */
public class RegExpTest {
	@Test
	public void testMatches() throws Exception {
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("koer".matches("[a-z]{3}"));
	}
	@Test
	public void testname() throws Exception {
		assertEquals("dag","dog".replaceAll("o","a"));
		assertEquals("dXg","daeg".replaceAll("[aoe]+","X"));
	}
	@Test
	public void testSplit() throws Exception {
		String[] s = "Hello abc def".split("\\s+");
		assertEquals(3,s.length);
	}
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("abc");
		Matcher m = p.matcher("babc");
		assertTrue(m.find());
		assertEquals("abc", m.group());
		assertEquals("b", m.group());
		//assertEquals(1, m.start());
		
	}
}
