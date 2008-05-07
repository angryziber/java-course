package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * SortingIDTest
 * 
 * @author r_vassiljev
 */
public class SortingIDTest {

	/**
	 * Test method for SortingID
	 * Checks results of SortingID function 
	 */

	@Test
	public void sortingTest() {
		// TODO this doesn't test anything yet
		ArrayList<Integer> results;
		ArrayList<Integer> answers = new ArrayList<Integer>();
		
		// Creating list of correct answers
		answers.add(6);
		answers.add(7);
		answers.add(8);
		answers.add(10);
		answers.add(0);
		answers.add(11);
		answers.add(4);
		answers.add(9);
		answers.add(2);
		answers.add(1);
		answers.add(3);
		answers.add(5);
		
		LoadNewResults lnr = new LoadNewResults();

		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();

		lnr.loadResults(result_map1, result_map2, result_map3);
		
		results = SortingID.SortByID(result_map1, result_map2, result_map3);
		
		for (int i = 0; i < results.size(); i++)
		{
			//System.out.println(results.get(i));
//			assertTrue(answers.get(i) == results.get(i));
		}
	}

}
