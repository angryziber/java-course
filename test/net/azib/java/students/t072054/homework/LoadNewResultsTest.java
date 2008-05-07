package net.azib.java.students.t072054.homework;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

import java.util.LinkedHashMap;

/**
 * LoadNewResultsTest
 * 
 * @author r_vassiljev
 */
public class LoadNewResultsTest {

	/**
	 * Test method for LoadNewResults class,
	 * checks all id-s in MySQL tables
	 */
	@Test
	public void testLoadResults() {
		
		LoadNewResults lnr = new LoadNewResults();
		
		// TODO what exactly is tested here?
		Map<Integer, String[]> result_map1 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map2 = new LinkedHashMap<Integer, String[]>();
		Map<Integer, String[]> result_map3 = new LinkedHashMap<Integer, String[]>();
		
		lnr.loadResults(result_map1, result_map2, result_map3);
		
		String str[]; 
		
		for (int i = 0; i < 10; i++)
		{
			str = result_map1.get(i);
			
			boolean result = str[0].equals(String.valueOf(i+1));
			assertTrue(result);
		}
		
		for (int i=0; i < 12; i++)
		{
			str = result_map3.get(i);
			
			boolean result = str[0].equals(String.valueOf(i+1));
			assertTrue(result);
		}
		
		

	}
}
