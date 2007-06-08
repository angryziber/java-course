package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.decathlon.Athlete;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEvent;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum;
import net.azib.java.students.t060401.homework.decathlon.DecathlonResults;
import net.azib.java.students.t060401.homework.decathlon.RunningEvent;
import net.azib.java.students.t060401.homework.util.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import junit.framework.TestCase;

/**
 * AthleteTest
 *
 * @author Astrid Pärn
 */
public class AthleteTest extends TestCase {

	Athlete athlete;
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		athlete = new Athlete();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#setBirthTime(java.util.Date)}.
	 */
	public void testSetBirthTimeDate() {
		try {
			athlete.setBirthTime(DateUtil.getDate("12.12.1990"));
		} catch (IllegalArgumentException e){
			fail("12.12.1990 should be accepted as valid date");
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#setBirthTime(java.lang.String)}.
	 */
	public void testSetBirthTimeString() {
		try {
			athlete.setBirthTime("02.04.1983");
		} catch (IllegalArgumentException e){
			fail("02.04.1983 should be accepted as valid date");
		}
		try {
			athlete.setBirthTime("02.22.1983");
			fail("Date with illegal month should not be valid");
		} catch (IllegalArgumentException e){
			//expected
		}
		try {
			athlete.setBirthTime("tt.04.1983");
			fail("Date containing characters should not be accepted as valid date");
		} catch (IllegalArgumentException e){
			//excpected
		}

		Calendar date = Calendar.getInstance();
		date.add(Calendar.YEAR, 2);
		
		try {
			String dateInFuture = getDateAsString(date);
			athlete.setBirthTime(dateInFuture);
			fail("Date in future should not be valid");
		}
		catch (Exception e) {
			//expected
			System.out.println(e);
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#setCountry(java.lang.String)}.
	 */
	public void testSetCountry() {
		try {
			athlete.setCountry("aaa");
			fail("Country code should have 2 characters");
		} catch (IllegalArgumentException e){
			//excpected
		}
		try {
			athlete.setCountry("ET");
		} catch (IllegalArgumentException e){
			fail("'ET' should be valid country code");
		}
		try {
			athlete.setCountry("YY");
			fail("There should be no such country as 'YY'");
		} catch (IllegalArgumentException e){
			//excpected
		}
		try {
			athlete.setCountry(null);
			fail("Country code should not be empty");
		} catch (IllegalArgumentException e){
			//excpected
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#setName(java.lang.String)}.
	 */
	public void testSetName() {
		try {
			athlete.setName("Tina2");
			fail("Numbers should not be accepted in athlete name");
		} catch (IllegalArgumentException e){
			//expected
		}
		try {
			athlete.setName("Tina");
		} catch (IllegalArgumentException e){
			fail("Letters should be accepted in athlete's name");
		}
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#isComplete()}.
	 */
	public void testIsComplete() {
		assertFalse(athlete.isComplete());
		athlete = new Athlete("Tom", "12.12.1983", Locale.getISOCountries()[0]);
		DecathlonResults results = new DecathlonResults();
		DecathlonEventEnum [] eventTypes = DecathlonEventEnum.values();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], 1);
			results.put(event);
		}
		athlete.setDecathlonResults(results);
		assertTrue("If all the athlete's data is set, the athlete object should be complete",athlete.isComplete());
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#compareTo(java.lang.Object)}.
	 */
	public void testCompareTo() {
		setAthlete();
		Athlete anotherAthlete = new Athlete("Tom", "12.12.1983", Locale.getISOCountries()[0]);
		DecathlonEventEnum [] eventTypes = DecathlonEventEnum.values();
		DecathlonResults results = new DecathlonResults();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], i);
			results.put(event);
		}
		anotherAthlete.setDecathlonResults(results);
		
		assertEquals("Athletes points values should be equal: " +athlete.getPoints()+"="+anotherAthlete.getPoints()+" ", 0, athlete.compareTo(anotherAthlete));

		DecathlonResults results1 = new DecathlonResults();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], i+1);
			results1.put(event);
		}
		anotherAthlete.setDecathlonResults(results1);
		
		assertEquals("Athletes points values should not be equal: " +athlete.getPoints()+"="+anotherAthlete.getPoints()+" ", 3976, athlete.compareTo(anotherAthlete));
		assertEquals("Athletes points values should not be equal: " +athlete.getPoints()+"="+anotherAthlete.getPoints()+" ", -3976, anotherAthlete.compareTo(athlete));
	}

	/**
	 * Test method for {@link net.azib.java.students.t060401.homework.decathlon.Athlete#toVector()}.
	 */
	public void testToVector() {
		setAthlete();
		java.util.Vector<String> athleteVector = athlete.toVector();
		System.out.println(athleteVector);
		assertEquals("10636", athleteVector.get(0));
		assertEquals("Tom", athleteVector.get(1));
		assertEquals("12.12.1983", athleteVector.get(2));
		assertEquals("AD", athleteVector.get(3));
		assertEquals("00.00", athleteVector.get(4));
		assertEquals("01.00", athleteVector.get(5));
		assertEquals("02.00", athleteVector.get(6));
		assertEquals("03.00", athleteVector.get(7));
		assertEquals("04.00", athleteVector.get(8));
		assertEquals("05.00", athleteVector.get(9));
		assertEquals("06.00", athleteVector.get(10));
		assertEquals("07.00", athleteVector.get(11));
		assertEquals("08.00", athleteVector.get(12));
		assertEquals("09.00", athleteVector.get(13));
	}

	private void setAthlete() {
		athlete = new Athlete("Tom", "12.12.1983", Locale.getISOCountries()[0]);
		DecathlonResults results = new DecathlonResults();
		DecathlonEventEnum [] eventTypes = DecathlonEventEnum.values();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], i);
			results.put(event);
		}
		athlete.setDecathlonResults(results);
	}
	
	private String getDateAsString(Calendar date) {
		Date time = date.getTime();
		String dateString = null;
		dateString = DateUtil.getDateAsString(time);
		return dateString;
	}
}
