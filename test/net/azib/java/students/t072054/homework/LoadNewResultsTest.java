package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Map;

import java.util.LinkedHashMap;

/**
 * LoadNewResultsTest
 * 
 * @author r_vassiljev
 */
public class LoadNewResultsTest {

	/**
	 * Test method for LoadNewResults class, checks all id-s in MySQL tables
	 * Test method for
	 * {@link net.azib.java.students.t072054.homework.LoadNewResults.LoadResultsDB}.
	 */
	@Test
	public void testLoadResultsDB() {

		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> resultMap1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResultsDB(resultMap1, resultMap2, resultMap3);

		String str[];

		for (int i = 0; i < 10; i++) {
			str = resultMap1.get(i);

			boolean result = str[0].equals(String.valueOf(i + 1));
			assertTrue(result);
		}

		for (int i = 0; i < 2; i++) {
			str = resultMap2.get(i);

			boolean result = str[0].equals(String.valueOf(i + 1));
			assertTrue(result);
		}

		for (int i = 0; i < 12; i++) {
			str = resultMap3.get(i);

			boolean result = str[0].equals(String.valueOf(i + 1));
			assertTrue(result);
		}

	}

	/**
	 * Test method for convertTime function, converts some initial data to
	 * needed result and compares with it Test method for
	 * {@link net.azib.java.students.t072054.homework.LoadNewResults.convertTime}.
	 */
	@Test
	public void convertTime() {
		String notConverted = "3:23.59";
		String converted;

		LoadNewResults lnr = new LoadNewResults();

		converted = lnr.convertTime(notConverted);
		System.out.println(converted.toCharArray());
		assertTrue(converted.equals("203.59"));
	}
}
