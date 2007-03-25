package net.azib.java.lessons.text;

import static org.junit.Assert.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;


/**
 * RegexpTest
 *
 * @author anton
 */
public class RegexpTest {

	@Test
	public void testMatches() throws Exception {
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("koer".matches("[a-z]{3}"));
		assertFalse("a dog".matches("dog"));
	}
	
	@Test
	public void testReplace() throws Exception {
		assertEquals("dag", "dog".replaceAll("o", "a"));
		assertEquals("HXllX, WXrld!", "Hello, World!".replaceAll("[aoe]+", "X"));
		assertEquals("dXXm", "daem".replaceAll("[aoe]", "X"));
		assertEquals("dam", "dZg".replaceAll("d.g", "dam"));
		assertEquals("a dog", "a dog".replaceAll("^dog$", ""));
		assertEquals("", "dog".replaceAll("^dog$", ""));
		assertEquals("beautiful", "a beautiful dog".replaceAll("^a (\\w+) dog$", "$1"));
	}
	
	@Test
	public void testSplit() throws Exception {
		String[] s = "Hello abc def".split("\\s+");
		assertEquals(3, s.length);
	}
	
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("[\\w.]+@[\\w.]+\\.[a-z]{2,4}");
		Matcher m = p.matcher("Hello, my email is anton@azib.net!");
		assertTrue(m.find());
		assertEquals("anton@azib.net", m.group());
		assertFalse(m.find());
	}
	
}
