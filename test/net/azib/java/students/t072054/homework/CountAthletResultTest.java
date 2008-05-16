package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
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
	 * 
	 * 
	 * 
	 * Test method for CountResultByID
	 */
	@Test
	public void testCountResultByIDCase() {
		
		LoadNewResults lnr = new LoadNewResults();
		
		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResultsDB(result_map1, result_map2, result_map3);
		
		double result = CountAthletResult.CountResultByID(result_map3, 1, 2);
		
		assertTrue(result > 4238 && result < 4239);
		
		//System.out.println(CountAthletResult.CountResultByID(result_map3, 1, 2));
	}
		
	@Test
	public void testCompare() {
		
		LoadNewResults lnr = new LoadNewResults();
		
		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResultsDB(result_map1, result_map2, result_map3);
		
		double result1 = CountAthletResult.CountResultByID(result_map3, 8, 1);
		double result2 = CountAthletResult.CountResult(10.94, 7.83, 12.48, 2, 49.72, 15.67,
				38.3, 5.4, 55.84, 271.72);
		
		assertTrue(result1 == result2);
	}
		
}
