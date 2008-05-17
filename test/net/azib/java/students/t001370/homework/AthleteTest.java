package net.azib.java.students.t001370.homework;

import static org.junit.Assert.*;


import org.junit.Test;

/**
 * AthleteTest
 *
 * @author maksim
 */
public class AthleteTest {

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#compareTo(net.azib.java.students.t001370.homework.Athlete)}.
	 */
	@Test
	public void testCompareToEquals() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.competitionResults.setResult100mRace((float)12.13);
		b.competitionResults.setResult100mRace((float)12.13);
		
		assertTrue(a.compareTo(b) == 1);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#compareTo(net.azib.java.students.t001370.homework.Athlete)}.
	 */
	@Test
	public void testCompareToSmaller() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.competitionResults.setResult100mRace((float)12.00);
		b.competitionResults.setResult100mRace((float)12.13);
		
		assertTrue(a.compareTo(b) == -1);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#compareTo(net.azib.java.students.t001370.homework.Athlete)}.
	 */
	@Test
	public void testCompareToBigger() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.competitionResults.setResult100mRace((float)12.50);
		b.competitionResults.setResult100mRace((float)12.13);
		
		assertTrue(a.compareTo(b) == 1);
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObjectTrue() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.setName("Gaas Põhja");
		a.setCountryCode("EE");
		a.competitionResults.setResult100mRace((float)12.50);
		
		b.setName("Gaas Põhja");
		b.setCountryCode("EE");
		b.competitionResults.setResult100mRace((float)12.50);

		assertTrue("Two athlete objects should be equal", a.equals(b));
	}
	
	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObjectDifferentName() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.setName("Anna Gaasi");
		a.setCountryCode("EE");
		a.competitionResults.setResult100mRace((float)12.50);
		
		b.setName("Gaas Põhja");
		b.setCountryCode("EE");
		b.competitionResults.setResult100mRace((float)12.50);

		assertTrue("Two athlete objects should be not equal", !a.equals(b));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObjectDifferentCountryCode() {
		
		Athlete a = new Athlete();
		Athlete b = new Athlete();
		
		a.setName("Anna Gaasi");
		a.setCountryCode("RU");
		a.competitionResults.setResult100mRace((float)12.50);
		
		b.setName("Anna Gaasi");
		b.setCountryCode("EE");
		b.competitionResults.setResult100mRace((float)12.50);

		assertTrue("Two athlete objects should be not equal", !a.equals(b));
	}

	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#getName()}.
	 */
	@Test
	public void testGetSetName() {
		Athlete a = new Athlete();
		
		a.setName("Anna Gaasi");
		
		assertTrue(a.getName().equals((String)"Anna Gaasi"));
	}


	/**
	 * Test method for {@link net.azib.java.students.t001370.homework.Athlete#getCountryCode()}.
	 */
	@Test
	public void testGetSetCountryCode() {
		Athlete a = new Athlete();
		
		a.setCountryCode("EE");
		
		assertTrue(a.getCountryCode().equals((String)"EE"));
	}
}
