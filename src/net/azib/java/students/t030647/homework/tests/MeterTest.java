package net.azib.java.students.t030647.homework.tests;

import net.azib.java.students.t030647.homework.Meter;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * MeterTest
 *
 * @author Igor
 */
public class MeterTest {
	
	int c = 2;
	float b = 15;
	@Test
	public void testMeter() throws Exception {
		
		Meter a = new Meter("2.15");
		assertEquals(c, a.getMeters());
		assertEquals(b, a.getCentimeters());
		
	}
}
