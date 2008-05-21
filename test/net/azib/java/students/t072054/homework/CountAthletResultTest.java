package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * CountAthletResultTest
 * 
 * @author r_vassiljev
 */
public class CountAthletResultTest {

	/**
	 * Tests the correctness of result for one athlete Test method for
	 * {@link net.azib.java.students.t072054.hometask1.CountAthletResult}.
	 * 
	 */
	@Test
	public void testCountResultByIDCase() {

		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> resultMap1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResultsDB(resultMap1, resultMap2, resultMap3);

		double result = CountAthletResult.countResultByID(resultMap3, 1, 2);

		assertTrue(result == 4239);
	}

	/**
	 * Tests different ways to calculate results and compares them Test method
	 * for {@link net.azib.java.students.t072054.hometask1.CountAthletResult}.
	 * 
	 */
	@Test
	public void testCompare() {

		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> resultMap1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> resultMap3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResultsDB(resultMap1, resultMap2, resultMap3);

		double result1 = CountAthletResult.countResultByID(resultMap3, 8, 1);
		double result2 = CountAthletResult.countResult(10.94, 7.83, 12.48, 2, 49.72, 15.67, 38.3, 5.4, 55.84, 271.72);

		assertTrue(result1 == result2);
	}

}
