package net.azib.java.students.t072054.homework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ShowResults
 * 
 * @author r_vassiljev
 */

// TODO This class will be rewritten later
public class ShowResults {
	//public static void ShowResultsConsole(int[] indexes, int num_of_results) {
		 public static void main(String[] args) {
		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResults(result_map1, result_map2, result_map3);

		ArrayList<Integer> results = SortingID.SortByID(result_map1, result_map2, result_map3, 2);

		for (int i = 0; i < results.size(); i++) {

			for (int j = 0; j < 4; j++)
			{
				System.out.print(result_map1.get(results.get(i)-1)[j] + " ");
				
			}
			System.out.print(CountAthletResult.CountResultByID(result_map3, (double)results.get(i), (double)2));
			System.out.println();
		}
	}
}
