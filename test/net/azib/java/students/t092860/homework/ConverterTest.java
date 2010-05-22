package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * ConverterTest
 */
public class ConverterTest {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
    }
    
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#stringToTime(java.lang.String)}.
	 * @throws Exception 
	 */
	@Test
	public final void testStringToTime() throws Exception{
		String in1 = "10:10:10.1010";
		String in2 = "00:1010";
		String in3 = "10.00";
		double out1 = 0;
		double out2 = 0;
		double out3 = 0;
		
		out1 = Converter.stringToTime(in1);
		out2 = Converter.stringToTime(in2);
		out3 = Converter.stringToTime(in3);
		
		assertTrue(out1 == 36610.101);
		assertTrue(out2 == 1010.0);
		assertTrue(out3 == 10.0);
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#stringToTime(java.lang.String)}. 
	 * @throws Exception 
	 */
	@Test (expected = Exception.class)
	public final void testStringToTimeException1() throws Exception{
		Converter.stringToTime("10:10:10:10.1010");	
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#stringToTime(java.lang.String)}. 
	 * @throws Exception 
	 */
	@Test (expected = Exception.class)
	public final void testStringToTimeException2() throws Exception{
		Converter.stringToTime("asdasd");
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#distanceToString(java.lang.String)}.
	 */
	@Test
	public final void distanceToString(){	
		String out = Converter.distanceToString(320.51);		
		assertTrue(out.compareTo("320.51") == 0);
	}

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.Converter#athleteToString(net.azib.java.students.t092860.homework.Athlete)}.
	 * @throws Exception 
	 */
	@Test
	public final void testAthleteToString() throws Exception {
		Athlete athlete = TestData.GetAthlete();		
		String result = Converter.athleteToString(athlete);		
		String expected = "Name,reede, 20. Oktoober 2000,EE,90.00,20.45,20.45,20.45,90.00,90.00,20.45,20.45,20.45,90.00";
		assertTrue(result.compareTo(expected) == 0);
	}

}
