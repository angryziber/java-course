package net.azib.java.students.t072054.homework;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * DecathlonCalculatorTest
 * 
 * @author r_vassiljev
 */
public class DecathlonCalculatorTest {

	@Test
	public void commandLineParsingTest1() {

		String[] a = new String[3];
		a[0] = "-console";
		a[1] = "-xml";
		a[2] = "results.xml";

		assertEquals(DecathlonCalculator.commandLineParsing(a), "null results.xml 1 4 null");
	}

	@Test
	public void commandLineParsingTest3() {

		String[] a = new String[3];
		a[0] = "-csv";
		a[1] = "my_input.csv";
		a[2] = "-console";

		assertEquals(DecathlonCalculator.commandLineParsing(a), "my_input.csv null 2 1 null");
	}
	
	@Test
	public void commandLineParsingTest2() {

		String[] a = new String[4];
		a[0] = "-db";
		a[1] = "2";
		a[2] = "-html";
		a[3] = "/tmp/results.html";

		assertEquals(DecathlonCalculator.commandLineParsing(a), "null /tmp/results.html 3 5 2");
	}

	@Test
	public void getIDEventTest() {
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		String[] str1 = new String[5];
		String[] str2 = new String[5];
		
		str1[0] = "5";
		str1[1] = "EE";
		str1[2] = "2005-02-03";
		str1[3] = "First";
		str1[4] = "Tallinn";
		
		str2[0] = "10";
		str2[1] = "SW";
		str2[2] = "2006-01-23";
		str2[3] = "Second";
		str2[4] = "Stokholm";
		
		result_map2.put(0, str1);
		result_map2.put(1, str2);
		
		assertEquals(DecathlonCalculator.getEventID(result_map2, "First"), 5);
		assertEquals(DecathlonCalculator.getEventID(result_map2, "Second"), 10);
	}
}
