package net.azib.java.students.t040750.homework.parser;

import org.junit.Test;

import static org.junit.Assert.*;


/**
 * HelperTest
 *
 * @author karpo
 */
public class HelperTest {

	@Test
	public void testIsValidCountry() throws Exception {
		assertTrue(Helper.isValidCountry("EE"));
		assertFalse(Helper.isValidCountry("XX"));
	}
	
	@Test
	public void testLoadResponce() throws Exception {
		/*
		String input = "h\\r\\n a\\r\\n grd\\r\\nn\\r\\ny\\r\\n";
		Scanner s = new Scanner(input).useDelimiter("\\n");
		String result = Helper.loadResponce(s, "");
		assertEquals("n\\r", result);
		*/
	}
}
