package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

/**
 * HTMLOutputTest
 * 
 * @author Raigo
 */
public class HTMLOutputTest {
	OutputAthletesToHTML out = new OutputAthletesToHTML();

	@Test
	public void testOutputString() {
		ArrayList<Athlete> a = new ArrayList<Athlete>();

		Date date = Date.valueOf("2000-12-12");
		Athlete athlete = new Athlete("la cuccaracha", date, "EE", 12.2, 480, 10.14, 120, 68.44, 18.12, 30.1, 250, 33.33, 389.66,
				3499);
		a.add(athlete);
		assertEquals("", out.createHTMLOutput(a, ""));
		assertEquals("test.html", out.createHTMLOutput(a, "test.html"));
	}

}
