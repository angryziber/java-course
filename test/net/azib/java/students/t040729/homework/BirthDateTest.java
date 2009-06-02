package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * BirthDateTest
 * 
 * @author ValleTon
 */
public class BirthDateTest {

	@Test
	public void testBirthDate() throws Exception{
		BirthDate birthDate = new BirthDate("17.01.1984","dd.MM.yyyy");
		assertEquals("17.01.1984",birthDate.toString());
	}
	
	@Test
	public void testNullAndEmptyBirthDate() throws Exception{
		BirthDate birthDate = new BirthDate("","dd.MM.yyyy");
		assertEquals("",birthDate.toString());
		birthDate = new BirthDate(null,"dd.MM.yyyy");
		assertEquals("",birthDate.toString());
	}

	@Test
	public void testCustomDateFormat() throws Exception{
		BirthDate birthDate = new BirthDate("17.01.1984","dd.MM.yyyy");
		assertEquals("1984-01-17",birthDate.getCustomDate("yyyy-MM-dd"));
	}
	
	@Test
	public void testProvidedInvalidDateFormat(){
		try {
			@SuppressWarnings("unused")
			BirthDate birthDate = new BirthDate("17.01.1984","hello");
			fail("Illegal date format not catched.");
		}
		catch (Exception e) {
		}
	}
	
	@Test
	public void testInvalidDate(){
		try {
			@SuppressWarnings("unused")
			BirthDate birthDate = new BirthDate("1701.1984","dd.MM.yyyy");
			fail("Illegal date format not catched.");
		}
		catch (Exception e) {
		}
	}
}
