package net.azib.java.students.t030636.v_05;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * RegexpStuff
 *
 * @author Martin
 */
public class RegexpStuff {
	
	@Test
	public void testMatches() throws Exception {
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("dogless".matches("[a-z]{3}"));
		assertFalse("a dog".matches("dog"));
	}
	
	@Test
	public void testReplace() throws Exception {
		assertEquals("dag", "dog".replaceAll("o", "a"));
		assertEquals("HXllX, WXrld!", "Hello, World!".replaceAll("[aoe]+", "X"));
		assertEquals("dam", "dZg".replaceAll("d.g", "dam"));
	}
	
	@Test
	public void testSplit() throws Exception {
		String[] s = "Hello abc def".split("\\s+");
		assertEquals(3, s.length);
	}
	
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("abc");
		Matcher m = p.matcher("babc");
		assertTrue(m.find());
		assertEquals("abc", m.group());
		assertEquals(1, m.start());
	}

}
