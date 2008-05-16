package net.azib.java.students.t072054.homework;

import java.util.Map;

/**
 * ResultsLoader
 * 
 * @author r_vassiljev
 */
public interface ResultsLoader {
	public void loadResultsDB(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3);

	public void loadResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, String fileName);

	public void loadResultsConsole(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3);

}
