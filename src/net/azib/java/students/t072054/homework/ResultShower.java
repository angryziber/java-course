package net.azib.java.students.t072054.homework;

import java.util.ArrayList;
import java.util.Map;

/**
 * ResultShower
 * 
 * @author r_vassiljev
 */
public interface ResultShower {

	public String showResultsConsole(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent);

	public String showResultsCSV(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent, String fileName);

	public void showResultsXML(Map<Integer, String[]> result_map1, Map<Integer, String[]> result_map2,
			Map<Integer, String[]> result_map3, ArrayList<Integer> results, double numEvent, String fileName) throws Exception;
}
