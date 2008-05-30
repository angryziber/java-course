package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.junit.Test;

/**
 * DecathlonInputCSVTest
 *
 * @author maksim
 */
public class DecathlonInputCSVTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValue() {
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueComa() {
		DecathlonInputCSV dic = new DecathlonInputCSV();
		
		assertTrue(dic.parseStringValue("12,12") == (float)12.12);

	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueDot() {
		DecathlonInputCSV dic = new DecathlonInputCSV();
		
		assertTrue(dic.parseStringValue("12.12") == (float)12.12);

	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueMinute() {
		DecathlonInputCSV dic = new DecathlonInputCSV();
		
		assertEquals(dic.parseStringValue("1:12.12"), (float)(60 + 12.12));

	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueWrongFormat() {
		DecathlonInputCSV dic = new DecathlonInputCSV();
		
		try{
			dic.parseStringValue("12_");
		}
		catch (NumberFormatException e){
			assertEquals(e.getClass().getSimpleName(), new NumberFormatException().getClass().getSimpleName());
		}

	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseStringValueFromCSV(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueFromCSVWrongFormat() {
		String str="12_";
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonInputCSV dic = new DecathlonInputCSV(new PrintStream(out), in);
		
		dic.parseStringValueFromCSV(str);
			
		assertEquals(Errors.ERROR_RESULT_NUMBER_FORMAT_IS_WRONG.getErrorText() + "(" + str + ")" + System.getProperty("line.separator"),
				out.toString());
	}
	
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputCSV#parseCSVData(java.lang.String)}.
	 */
	@Test
	public void testParseCSVData() {
		String str="\"Gaas Põhja\",12.12.1212,EE,12.12,4.53,10.12,1.22,1:06.44,19.12,25,2.30,36,6:22.45";
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		DecathlonInputCSV dic = new DecathlonInputCSV(new PrintStream(out), in);
		
		Athlete a = dic.parseCSVData(str);
		
		assertEquals("Gaas Põhja", a.getName());
//		assertEquals("12.12.1212", 
//				((SimpleDateFormat)DateFormat.getDateInstance(DateFormat.MEDIUM)).format(a.getBirthday()));
		assertEquals("12.12.1212", new SimpleDateFormat("dd.MM.yyyy").format(a.getBirthday()));
		assertEquals("EE", a.getCountryCode());
		assertEquals((float)12.12, a.competitionResults.getResult100mRace());
		assertEquals((float)4.53, a.competitionResults.getResultLongJump());
		assertEquals((float)10.12, a.competitionResults.getResultShotPut());
		assertEquals((float)1.22, a.competitionResults.getResultHighJump());
		assertEquals((float)(60 + 6.44), a.competitionResults.getResult400mSprint());
		assertEquals((float)19.12, a.competitionResults.getResult110mHurdles());
		assertEquals((float)25, a.competitionResults.getResultDiscusThrow());
		assertEquals((float)2.30, a.competitionResults.getResultPoleVault());
		assertEquals((float)36, a.competitionResults.getResultJavelinThrow());
		assertEquals((float)(6 * 60 + 22.45), a.competitionResults.getResult1500mRace());
	}

}
