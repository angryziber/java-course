package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * CompetitorTest
 *
 * @author Triin Nestor
 */
public class CompetitorTest {
	private Competitor comp = new Competitor();
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.Competitor#setName}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getName}.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testPlace() throws Exception {
		String place = "1. ";
		
		comp.setPlace(place);
		assertEquals(place, comp.getPlace());
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.Competitor#setCompetitor}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getName}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getDateOfBirth}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getCountry}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getResults}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getTotalPoints}.
	 * {@link net.azib.java.students.t030655.homework.Competitor#getString}.
	 * 
	 */
	@Test
	public void testCompetitor(){
		String strComp = "\"Beata Kana\",29.02.1982,ZA," +
				"13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";
		String name = "\"Beata Kana\"";
		String dob = "29.02.1982";
		String country = "ZA";
		double[] results = {
				13.04,
				4.53,
				7.79,
				1.55,
				64.72,
				18.74,
				24.2,
				2.4,
				28.2,
				410.76
		};
		int points = 3199;
				
		String competitor = points + "," + name + "," + dob + "," + country;
		for(int i=0; i<10; i++){
			competitor = competitor + "," + results[i];
		}
		
		comp.setCompetitor(strComp);
		double[] actResults = comp.getResults();
		assertEquals(name, comp.getName());
		assertEquals(dob, comp.getDateOfBirth());
		assertEquals(country, comp.getCountry());
		for(int i=0; i<10; i++){
			assertEquals(results[i], actResults[i]);
		}
		assertEquals(points, comp.getTotalPoints());
		assertEquals(competitor, comp.getString());
	}
	
	/**
	 * Test method for
	 * {@link net.azib.java.students.t030655.homework.Competitor#compareTo}.
	 * 
	 */
	@Test
	public void testCompareTo(){
		comp.setCompetitor("\"Василий Пупкин\",21.10.1980,UA," +
				"13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");
		Competitor comp2 = new Competitor();
		comp2.setCompetitor("\"Василий Пупкин\",21.10.1980,UA," +
				"0.00,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01");
		assertTrue(comp.compareTo(comp2) == 1);
	}

}
