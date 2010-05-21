package net.azib.java.students.t092875.homework.athletes;

import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * AthletesTest
 *
 * @author Mihhail
 */
public class AthletesTest {
	@Test
	public void basicTest(){
		Date dob = new Date(0);
		String[] results = {"50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20","50.20"};
		Athlete a = new Athlete("Mihhail Arhipov",dob,"ET",results);
		a.setPlace("1");
		a.setResult(2000);
		Date dob2 = new Date(0);
		assertEquals("Mihhail Arhipov", a.getName());
		assertEquals("ET", a.getOrigin());
		assertEquals(dob2, a.getDateOfBirth());
		assertEquals(2000, a.getResult());
		assertEquals("1", a.getPlace());
		
		assertEquals("50.20", a.getEventResult(0));
		assertEquals("50.20", a.getEventResult(1));
		assertEquals("50.20", a.getEventResult(2));
		assertEquals("50.20", a.getEventResult(3));
		assertEquals("50.20", a.getEventResult(4));
		assertEquals("50.20", a.getEventResult(5));
		assertEquals("50.20", a.getEventResult(6));
		assertEquals("50.20", a.getEventResult(7));
		assertEquals("50.20", a.getEventResult(8));
		assertEquals("50.20", a.getEventResult(9));
	}
}
