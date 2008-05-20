package net.azib.java.students.t072054.homework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * SortingIDTest
 * 
 * @author r_vassiljev
 */
public class SortingIDTest {

	/**
	 * Checks that sorting is correct Test method for
	 * {@link net.azib.java.students.t072054.homework.SortingID}.
	 */
	@Test
	public void testSortingID() {

		ArrayList<Integer> result_list;

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		ArrayList<Integer> results_array = new ArrayList<Integer>();

		ShowResultsTest.createMaps(result_map1, result_map2, result_map3, results_array);

		result_list = SortingID.sortByID(result_map1, result_map2, result_map3, 2);

		assertTrue(result_list.get(0) == 3);
		assertTrue(result_list.get(1) == 1);
		assertTrue(result_list.get(2) == 2);
	}
}
