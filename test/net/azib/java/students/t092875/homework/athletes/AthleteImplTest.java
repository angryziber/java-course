package net.azib.java.students.t092875.homework.athletes;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
/**
 * AthleteImplTest
 *
 * @author Mihhail
 */
public class AthleteImplTest {

	@Test
	public void basicTest(){
		Date dob = new Date(1987,8,29);
		Map<String,String> results = new HashMap<String,String>();
		results.put("100m", "20.0");
		Athlete athlete = new Athlete("Mihhail",dob,"EE",results);
		assertTrue("20.0".equals(athlete.getEventResult("100m")));
		assertTrue("EE".equals(athlete.getOrigin()));
		assertTrue("Mihhail".equals(athlete.getName()));
		Date dob2 = new Date(1987,8,29);
		assertEquals(0,dob2.compareTo(athlete.getDateOfBirth()));
		athlete.setResult(200.21);
		assertEquals(200.21, athlete.getResult(), 0.00);
	}
}
