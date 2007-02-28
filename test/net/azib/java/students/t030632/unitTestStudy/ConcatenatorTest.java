package net.azib.java.students.t030632.unitTestStudy;

import static org.junit.Assert.*;

import net.azib.java.lessons.misc.Concatenator;

import org.junit.Test;

/**
 * ConcatenatorTest
 * 
 * @author Toni
 */
public class ConcatenatorTest {

	/**
	 * @param args
	 */
	@Test
	public void testConcat() {
		Concatenator c = new Concatenator();
		assertEquals("concat() faled", "abc123",c.concatenate("abc", "123"));
	}

}
