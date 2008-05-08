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
	public static void ShowResultsConsole(ArrayList<Integer> results, double numEvent){
	//public static void main(String[] args) {
		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResults(result_map1, result_map2, result_map3);

		//ArrayList<Integer> results = SortingID.SortByID(result_map1, result_map2, result_map3, numEvent);

		// Print competitions data
		System.out.println("Competitions data:");
		for (int i = 0; i < result_map2.size(); i++) {
			for (int j = 0; j < 5; j++)
				System.out.println(result_map2.get(i)[j]);
			System.out.println();
		}
		System.out.println();

		// Print athletes data
		System.out.println("Results:");
		System.out.println(" ... "); // TODO Here will be the description of columns
		for (int i = 0; i < results.size(); i++) {

			System.out.print((i + 1) + " ");
			for (int j = 0; j < 4; j++) {
				System.out.print(result_map1.get(results.get(i) - 1)[j] + " ");

			}
			System.out.print(CountAthletResult.CountResultByID(result_map3, (double) results.get(i), numEvent));
			System.out.println();

			// Print athlete data from results table
			for (int k = 0; k < result_map3.size(); k++) {
				if (Double.parseDouble(result_map3.get(k)[1]) == (double) results.get(i)) {
					for (int j = 2; j < 13; j++)
						System.out.print(result_map3.get(k)[j] + " ");
					
					System.out.println();
				}
			}
			System.out.println();
		}

	}
}
