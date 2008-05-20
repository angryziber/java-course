package net.azib.java.students.t072054.homework;

import java.util.Map;

/**
 * ResultsLoader
 * 
 * @author r_vassiljev
 */
public interface ResultsLoader {
	public void loadResultsDB(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3);

	public void loadResultsCSV(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3, String fileName);

	public void loadResultsConsole(Map<Integer, String[]> resultMap1, Map<Integer, String[]> resultMap2,
			Map<Integer, String[]> resultMap3);

}
