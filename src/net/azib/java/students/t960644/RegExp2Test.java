package net.azib.java.students.t960644;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

/**
 * RegExp2Test
 *
 * @author Lembit
 */
public class RegExp2Test {
	
	@Test
	public void testMatches() throws Exception{
		assertTrue("dog".matches("[a-z]{3}"));
		assertFalse("koer".matches("[a-z]{3}"));
		assertFalse("a dog".matches("dog"));
		
	}
	@Test
	public void testReplace() throws Exception {
		assertEquals("dag","dog".replaceAll("o", "a"));
		assertEquals("HXllX, WXrld!","Hello, World!".replaceAll("[aeo]", "X"));
		assertEquals("dXm","daem".replaceAll("[aeo]+", "X"));
		assertEquals("a dog","a dog".replaceAll("^dog$",""));
		assertEquals("","dog".replaceAll("^dog$",""));
		assertEquals("beautiful","a beautiful dog".replaceAll("^a (\\w+) dog$","$1"));
	}
/*	@Test
	public void testSplit() throws Exception {
		"Hello abc def".split("\\s+");
		assertEquals
	}*/
	@Test
	public void testDirect() throws Exception {
		Pattern p = Pattern.compile("abc");
		Matcher m = p.matcher("babc");
		assertTrue(m.find());
		assertEquals("abc",m.group());
		assertEquals(1,m.start());
	}

}
