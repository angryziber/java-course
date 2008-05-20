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

		createMaps(result_map1, result_map2, result_map3, results_array);

		result_list = SortingID.sortByID(result_map1, result_map2, result_map3, 2);

		assertTrue(result_list.get(0) == 3);
		assertTrue(result_list.get(1) == 1);
		assertTrue(result_list.get(2) == 2);
	}
	
	public static void createMaps(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results) {

		String[] str0 = { "1", "Siim Susi", "1976-01-01", "ZA" };
		result_map1.put(0, str0);

		String[] str1 = { "2", "Beata Kana", "1982-02-29", "EE" };
		result_map1.put(1, str1);

		String[] str2 = { "3", "Erki Nool", "1970-06-25", "EE" };
		result_map1.put(2, str2);

		String[] str3 = { "1", "EE", "2005-12-01", "Training", "Tallinn" };
		result_map2.put(0, str3);

		String[] str4 = { "2", "PL", "2006-03-18", "DECATHLON4BEER", "Krakow" };
		result_map2.put(1, str4);

		String[] str5 = { "1", "1", "2", "12.61", "5", "9.22", "1.5", "59.39", "16.43", "21.6", "2.6", "35.81", "325.72" };
		result_map3.put(0, str5);

		String[] str6 = { "2", "2", "2", "13.04", "4.53", "7.79", "1.55", "64.72", "18.74", "24.2", "2.4", "28.2", "410.76" };
		result_map3.put(1, str6);

		String[] str7 = { "6", "1", "1", "14.15", "3.98", "10", "1.45", "70.12", "18.65", "29.15", "2.15", "32.67", "466.6" };
		result_map3.put(2, str7);

		String[] str8 = { "7", "3", "1", "10.94", "7.83", "12.48", "2", "49.72", "15.67", "38.3", "5.4", "55.84", "271.72" };
		result_map3.put(3, str8);

		String[] str9 = { "8", "3", "2", "10.94", "7.83", "12.48", "2", "49.72", "15.67", "38.3", "5.4", "55.84", "271.72" };
		result_map3.put(4, str9);

		results.add(2);
		results.add(1);
		results.add(3);
	}
}
