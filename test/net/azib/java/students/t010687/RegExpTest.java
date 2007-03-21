package net.azib.java.students.t010687;

import static org.junit.Assert.*;
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
	}

}
