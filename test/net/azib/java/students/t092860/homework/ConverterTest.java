package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * ConverterTest
 *
 * @author armin
 */
public class ConverterTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#stringToTime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public final void testStringToTime(){
		String in1 = "10:10:10.1010";
		String in2 = "00:1010";
		String in3 = "10.00";
		String in4 = "10:10:10:10.1010";
		String in5 = "asdasd";
		double out1 = 0;
		double out2 = 0;
		double out3 = 0;
		
		try {
			out1 = Converter.stringToTime(in1);
			out2 = Converter.stringToTime(in2);
			out3 = Converter.stringToTime(in3);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		assertTrue(out1 == 36610.1015625);
		assertTrue(out2 == 1010.0);
		assertTrue(out3 == 10.0);
		
		try {
			Converter.stringToTime(in4);
			Converter.stringToTime(in5);
		}
		catch (Exception e) {
			assertNotNull(e.getMessage());
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#athleteToString(net.azib.java.students.t092860.homework.Athlete)}.
	 */
	@Test
	public final void testAthleteToString() {
		
		//System.out.print(out);
	}

}
