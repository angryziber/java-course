package net.azib.java.students.t020281.homework;

import static org.junit.Assert.*;

//import java.io.ByteArrayOutputStream;
//import java.io.OutputStream;
//import java.io.PrintStream;

import org.junit.Test;

/**
 * SportsmanTest
 *
 * @author Trial
 */
public class SportsmanTest {
	
	@Test
	public void convertedToSec () {
		Sportsman Person = new Sportsman();
		double expectedValue = 325.72;
					
		double actualValue = Person.convertToSec("5:25.72");
		assertEquals(expectedValue, actualValue);
		
		expectedValue = 59.39;;
		actualValue = Person.convertToSec("59.39");
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void convertedToSantimeters () {
		
		Sportsman Person = new Sportsman();
		double expectedValue = 922;
		double actualValue = Person.convertToSanti(9.22);
		
		assertEquals(expectedValue, actualValue);
	}
	
	@Test
	public void doubleMatcherTest () {
//		Sportsman Person = new Sportsman();
		String testValue = "59.39";
		assertTrue(Sportsman.isDouble(testValue));
		
		testValue = "59,39";
		assertFalse(Sportsman.isDouble(testValue));
		
		testValue = "59.";
		assertFalse(Sportsman.isDouble(testValue));
		
		testValue = "59.aa";
		assertFalse(Sportsman.isDouble(testValue));
		
	}
	
	@Test
	public void timeMatcherTest () {
//		Sportsman Sportsman = new Sportsman();
		String testValue = "1:04.72";
		assertTrue(Sportsman.isTime(testValue));
		
		testValue = "59.39";
		assertTrue(Sportsman.isTime(testValue));
		
		testValue = "59,39";
		assertFalse(Sportsman.isTime(testValue));
		
		testValue = "a:59.";
		assertFalse(Sportsman.isTime(testValue));
		
		testValue = "59.aa";
		assertFalse(Sportsman.isTime(testValue));
		
	}
	
	@Test
	public void codeMatcherTest () {
//		Sportsman Person= new Sportsman();
		String testValue = "EE";
		assertTrue(Sportsman.isCode(testValue));
		
		testValue = "ee";
		assertFalse(Sportsman.isCode(testValue));
		
		testValue = "DEE";
		assertFalse(Sportsman.isCode(testValue));
		
		testValue = "5E";
		assertFalse(Sportsman.isCode(testValue));
		
	}
	
	@Test
	public void dateMatcherTest () {
//		Sportsman Person = new Sportsman();
		String testValue = "29.02.1982";
		assertTrue(Sportsman.isDate(testValue));
		
		testValue = "29.13.1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "32.12.1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "29.011.1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "29.aa.1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "29,11,1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "2911.1982";
		assertFalse(Sportsman.isDate(testValue));
		
		testValue = "29.aa.19824";
		assertFalse(Sportsman.isDate(testValue));
	}
	
	@Test
	public void nameMatcherTest () {
//		Sportsman Person = new Sportsman();
		String testValue = "Beata Kana";
		assertTrue(Sportsman.isName(testValue));
		
		testValue = "Василий Пупкин";
		assertTrue(Sportsman.isName(testValue));
		
		testValue = "Sihken Sähkel";
		assertTrue(Sportsman.isName(testValue));
		
		testValue = "Szőrös Szűk";
		assertTrue(Sportsman.isName(testValue));
		
		testValue = "宗弘金子 (Munehiro Kaneko)";
		assertTrue(Sportsman.isName(testValue));
		
		testValue = "Beata 5E";
		assertFalse(Sportsman.isName(testValue));
		
		testValue = "Beata 5E ";
		assertFalse(Sportsman.isName(testValue));
		
	}
	
	@Test
	public void csvStringParsed() {
		
//		ByteArrayOutputStream myOutput= new ByteArrayOutputStream();
//		Sportsman Person = new Sportsman(myOutput);
//		String expectedString = "15.05.2008 0:55:04 net.azib.java.students" +
//								".t020281.homework.Sportsman parseDataString\n" +
//								"WARNING: 400m sprint time has invalid format!" +
//								"Example: 12.69 or 1:12.69";
		
		Sportsman Person = new Sportsman();
		
		String stringToParse = "\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75";
		
		assertTrue(Person.parseDataString(stringToParse));
		
		stringToParse = "\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:k8.44,19.18,30.85,2.80,33.88,6:22.75";
		
		assertFalse(Person.parseDataString(stringToParse));
//		assertEquals(expectedString, myOutput.toString());
		
	}
	
	@Test
	public void runEventPointsCalculated(){
		double expected = 536.5887399456019;
		double actual = new Sportsman().calcRunningEvent(25.437, 18.0, 1.81, 12.61);
		double delta = 0.000000001;

		assertEquals(expected, actual, delta);
	}
	
	@Test
	public void fieldEventPointsCalculated(){
		double expected = 439.41692746061824;
		double actual = new Sportsman().calcFieldEvent(51.39, 1.5, 1.05, 9.22);
		
		
//		System.out.println(expected);
//		System.out.println(actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void resultsParsed() {
		Sportsman Person = new Sportsman();
		String results = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
		Person.parseDataString(results);
		
		assertEquals("Siim Susi", Person.getName());
		assertEquals("01.01.1976", Person.getBirthDate());
		assertEquals("EE", Person.getCountry());
		assertEquals(12.61, Person.getSprint100mEvent());
		assertEquals(500, Person.getLongJumpEvent());
		assertEquals(9.22, Person.getShotPutEvent());
		assertEquals(150, Person.getHighJumpEvent());
		assertEquals(59.39, Person.getSprint400mEvent());
		assertEquals(16.43, Person.getHurdles110mEvent());
		assertEquals(21.60, Person.getDiscusThrowEvent());
		assertEquals(260, Person.getPoleVaultEvent());
		assertEquals(35.81, Person.getJavelinThrowEvent());
		assertEquals(325.72, Person.getRace1500mEvent());
	}
	
	@Test
	public void decathlonPointsCalculated() {
		Sportsman Person = new Sportsman();
		String results = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
		Person.parseDataString(results);
		Person.calculateDecathlonPoints();
		double expected = 3846.0664996823343;
		double actual = Person.getPoints();
		
		assertEquals(expected, actual);
	}
	
}
