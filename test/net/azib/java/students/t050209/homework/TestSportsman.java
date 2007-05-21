package net.azib.java.students.t050209.homework;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
/**
 * TestSportsman
 *
 * @author kaupo
 */
public class TestSportsman {

	@Test
	public void testSetSportsmanName() throws Exception {
		Sportsman sm = new Sportsman();
		sm.setSportsmanName("Jaan Tamm");
		assertEquals("Assert failed. Not Equal", "Jaan Tamm", sm.getSportsmanName());
	}
	
	@Test
	public void testSetSportsmanDayOfBirth() throws Exception {
		Sportsman sm = new Sportsman();
		sm.setSportsmanDateOfBirth("01.07.1985");
		assertEquals("Assert failed. Not Equal", "01.07.1985", sm.getSportsmanDateOfBirth());
	}
	
	@Test
	public void testSetSportsmanCountry() throws Exception {
		Sportsman sm = new Sportsman();
		sm.setSportsmanCountry("US");
		assertEquals("Assert failed. Not Equal", "US", sm.getSportsmanCountry());
	}
	
	@Test
	public void testSetSportsmanResults() throws Exception {
		List<Double> results = new LinkedList<Double>();
		Sportsman sm = new Sportsman();
		double[] list = {10.94, 7.83, 12.48, 2.0, 49.72, 15.67, 38.3, 5.40, 55.84, 271.72};
		for(int i = 0; i < 10; i++){
			results.add(list[i]);
		}
		sm.setSportsmanResults(results);
		
		for(int i = 0; i < 10; i++)
		{
			assertEquals("Assert failed. Not Equal", list[i], sm.getSportsmanResults().get(i));
		}
	}
	
	@Test
	public void testCalculateAndStoreSportsmanScore() throws Exception {
		List<Double> results = new LinkedList<Double>();
		Sportsman sm = new Sportsman();
		double[] list = {10.94, 7.83, 12.48, 2.0, 49.72, 15.67, 38.3, 5.40, 55.84, 271.72};
		for(int i = 0; i < 10; i++){
			results.add(list[i]);
		}
		sm.setSportsmanResults(results);
		sm.calculateAndStoreSportsmanScore();
		assertEquals("Assert failed. Not Equal", 8002, sm.getSportsmanScore());
	}
}
