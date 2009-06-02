package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * NameTest
 * 
 * @author ValleTon
 */
public class NameTest {

	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.Name#toString()}.
	 */
	@Test
	public void testToString2() {
		Name n = new Name("Beata","Kana");
		assertEquals("Beata Kana",n.toString());
	}
	
	@Test
	public void testToString() throws Exception {
		Name n = new Name("Beata Kana");
		assertEquals("Beata Kana",n.toString());
	}
	
	@Test
	public void testEmptyName(){
		try {
			@SuppressWarnings("unused")
			Name n = new Name("");
			fail("Empty name should not be allowed!");
		}
		catch (Exception e) {
		}
	}
}
