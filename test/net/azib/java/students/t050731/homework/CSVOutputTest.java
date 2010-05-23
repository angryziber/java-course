package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.Test;

/**
 * CSVOutputTest
 *
 * @author Raigo
 */
public class CSVOutputTest {

	OutputAthletesToCSV out = new OutputAthletesToCSV();
	
	@Test
	public void testOutputString()
	{	
		ArrayList<Athlete> a= new ArrayList<Athlete>();
		
		Date date = Date.valueOf("2000-12-12");
		Athlete athlete = new Athlete("la cuccaracha", date, "EE", 12.2, 480, 10.14, 120, 68.44, 18.12, 30.1, 250, 33.33, 389.66,
				3499);
		a.add(athlete);
		assertEquals("", out.createCSVOutput(a, ""));
		assertEquals("test.txt", out.createCSVOutput(a, "test.txt"));
	}
}
