package net.azib.java.students.t050209;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * RegExpTest
 *
 * @author t050209
 */
public class RegExpTest {
	@Test
	public void testMatches() throws Exception {
		assertTrue("dog".matches("[a-z]{3}"));
	}
}
