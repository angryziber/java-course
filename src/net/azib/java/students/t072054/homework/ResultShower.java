package net.azib.java.students.t072054.homework;

import java.util.ArrayList;
import java.util.Map;

/**
 * ResultShower
 *
 * @author r_vassiljev
 */
public interface ResultShower {
	
	public void ShowResultsConsole(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent);
	
	public void ShowResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent, String fileName);
	
	public void ShowResultsXML(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent, String fileName) throws Exception;
}
