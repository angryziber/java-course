package net.azib.java.lessons.text;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class RegExpTest {
	@Test
	public void regexpMatches() {
		String text = "cat dog cow";
		assertTrue(text.matches("cat dog cow"));
		assertTrue(text.matches("... dog cow"));
		assertFalse(text.matches("cow"));
		assertTrue(text.matches(".*dog.*"));
		assertTrue("xcow".matches(".+cow$"));
	}

	@Test
	public void emailValidation() {
	    assertTrue("@".matches(".*@.*"));
	    assertTrue("a@b".matches(".+@.+"));
	    assertTrue("a@b.c".matches(".+@.+\\..+"));
	    assertTrue("a@b.ee".matches(".+@.+\\...+"));
	    assertTrue("a@b.name".matches(".+@.+\\..{2,4}"));
	    assertFalse("a@b.&^%".matches(".+@.+\\.[abcdefgh]{2,4}"));
	    assertTrue("a@b.name".matches(".+@.+\\.[a-z]{2,4}"));
	    assertTrue("a@abc.def-123.name".matches(".+@[a-z0-9.-]+\\.[a-z]{2,4}"));
	    assertTrue("john.smith.123@abc.def-123.name".matches("^[a-z0-9.-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"));

	}

	@Test
	public void searchForEmails() {
	    String html = "<h1>Hello, I'm <a href='mailto:anton@azib.net'>Anton</a>!</h1> - or info@codeborne.com";
		Pattern emailPattern = Pattern.compile("([a-z0-9.-]+)@(([a-z0-9.-]+)\\.([a-z]{2,4}))");
		Matcher matcher = emailPattern.matcher(html);

		assertTrue(matcher.find());
		assertEquals("anton@azib.net", matcher.group());
		assertEquals("anton", matcher.group(1));
		assertEquals("azib.net", matcher.group(2));
		assertEquals("azib", matcher.group(3));
		assertEquals("net", matcher.group(4));

		assertTrue(matcher.find());
		assertEquals("info@codeborne.com", matcher.group());
		assertFalse(matcher.find());
	}

	@Test
	public void powerOfReplacement() {
	    assertEquals("cat sheep cow", "cat dog cow".replaceAll("dog", "sheep"));
	    assertEquals("cat dog-2 cow", "cat dog cow".replaceAll("(dog)", "$1-2"));
	    assertEquals("anton@codeborne.com", "anton.keks@codeborne.com".replaceAll("([a-z]+)\\.[a-z]+(@)", "$1$2"));
	}
}
