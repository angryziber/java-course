package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Test;

/**
 * DecathlonInputConsoleTest
 *
 * @author maksim
 */
public class DecathlonInputConsoleTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueComa() {
		DecathlonInputConsole dic = new DecathlonInputConsole();
		
		assertTrue(dic.parseStringValue("12,12") == (float)12.12);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueDot() {
		DecathlonInputConsole dic = new DecathlonInputConsole();
		
		assertEquals(dic.parseStringValue("12.12"), (float)12.12);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueMinute() {
		DecathlonInputConsole dic = new DecathlonInputConsole();
		
		assertEquals(dic.parseStringValue("1:12.12"), (float)(60 + 12.12));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValue(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueWrongFormat() {
		DecathlonInputConsole dic = new DecathlonInputConsole();
		
		try{
			dic.parseStringValue("12_");
		}
		catch (NumberFormatException e){
			assertEquals(e.getClass().getSimpleName(), new NumberFormatException().getClass().getSimpleName());
		}
	}
	
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValueFromConsole(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueFromConsoleReadsFromInput() {
		String str="12.12";
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonInputConsole dic = new DecathlonInputConsole(new PrintStream(out), in);
		
		assertEquals(dic.parseStringValueFromConsole("12_"), (float)12.12);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#parseStringValueFromConsole(java.lang.String)}.
	 */
	@Test
	public void testParseStringValueFromConsoleDoestNotReadFromInput() {
		String str="12_60";
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonInputConsole dic = new DecathlonInputConsole(new PrintStream(out), in);
		
		assertEquals(dic.parseStringValueFromConsole("12,12"), (float)12.12);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#getAthletesDataFromConsole()}.
	 */
	@Test
	public void testGetAthletesDataFromConsoleGetAthlete() {
		String str="c" + System.getProperty("line.separator") +
				"Gaas Põhja" + System.getProperty("line.separator") +
				"12.12.1212" + System.getProperty("line.separator") +
				"EE" + System.getProperty("line.separator") +
				"12.12" + System.getProperty("line.separator") +
				"4.53" + System.getProperty("line.separator") +
				"10.12" + System.getProperty("line.separator") +
				"1,22" + System.getProperty("line.separator") +
				"1:06.44" + System.getProperty("line.separator") +
				"19.12" + System.getProperty("line.separator") +
				"25" + System.getProperty("line.separator") +
				"2.30" + System.getProperty("line.separator") +
				"36" + System.getProperty("line.separator") +
				"6:22.45" + System.getProperty("line.separator") +
				"x" + System.getProperty("line.separator");
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		DecathlonInputConsole dic = new DecathlonInputConsole(new PrintStream(out), in);
		
		assertEquals(((Athlete)dic.getAthletesDataFromConsole().toArray()[0]).competitionResults.getTotalScore(), (int)3389);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.DecathlonInputConsole#getAthletesDataFromConsole()}.
	 */
	@Test
	public void testGetAthletesDataFromConsoleExitFromConsole() {
		String str="x" + System.getProperty("line.separator");
		Scanner in = new Scanner(str);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		new DecathlonInputConsole(new PrintStream(out), in).getAthletesDataFromConsole();
		
		assertEquals("You are about to enter competition results." + System.getProperty("line.separator") +
						"Enter competitor data. To continue press 'c' or 'x' for exit!" + System.getProperty("line.separator") +
						"Exit from console!" + System.getProperty("line.separator"),
					out.toString());
	}
	
}
