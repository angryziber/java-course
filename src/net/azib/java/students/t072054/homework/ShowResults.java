package net.azib.java.students.t072054.homework;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ShowResults
 * 
 * @author r_vassiljev
 */

// TODO This class will be rewritten later
public class ShowResults {
	public static void ShowResultsAll(int[] indexes, int num_of_results) {
		// public static void main(String[] args) {
		LoadNewResults lnr = new LoadNewResults();
		
		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();
		
		lnr.loadResults(result_map1, result_map2, result_map3);

		try {
			for (int i = 0; i < num_of_results; i++) {
				for (int j = 0; j < indexes[i]; j++) {
					lnr.rs1.next();
				}

				System.out.println(lnr.rs1.getString(1));
				System.out.println(lnr.rs1.getString(2));
				System.out.println();
				
				lnr.rs1.first();
			}
		}
		catch (SQLException e) {
			// Auto-generated catch block
			e.printStackTrace();
		}
		
		lnr.connClose();
	}
}
