package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests the Record class.
 *
 * @author Marek
 */
public class RecordTest {

	/**
	 * Some random results and score.
	 * Test method for {@link net.azib.java.students.t050720.homework.Record#getScore()}.
	 */
	@Test
	public void testGetScore() {
		Record r=new Record();
		r.setAthlete("Marek Pärnaste");
		r.setBirthDate("07.10.1987");
		r.setCountry("EE");
		r.setDiscus_throw((float) 55.87);
		r.setHigh_jump((float) 2.27);
		r.setHurdles_110m((float) 13.47);
		r.setJavelin_throw((float) 79.80);
		r.setLong_jump((float) 8.22);
		r.setPole_vault((float) 5.76);
		r.setRace_100m((float) 10.22);
		r.setRace_400m((float) 45.68);
		r.setRace_1500m((float) 238.70);
		r.setShot_put((float) 19.17);
		assertEquals(10485, r.getScore());
	}

	/**
	 * All event results are 0, therefore the total score should be 0 too.
	 */
	@Test
	public void testGetScoreZero() {
		Record record=new Record();
		record.setAthlete("Somebody äöä");
		record.setDiscus_throw(0);
		record.setHigh_jump(0);
		record.setHurdles_110m(0);
		record.setJavelin_throw(0);
		record.setLong_jump(0);
		record.setPole_vault(0);
		record.setRace_100m(0);
		record.setRace_1500m(0);
		record.setRace_400m(0);
		record.setShot_put(0);
		assertEquals(0, record.getScore());
	}
	
	/**
	 * All event scores are not numbers (which is effectively 0 as far as score calculation is concerned), therefore the total score should be 0
	 */
	@Test
	public void testNan()
	{
		Record record=new Record();
		record.setAthlete("ää&&\"\\");
		record.setDiscus_throw(Float.NaN);
		record.setHigh_jump(Float.NaN);
		record.setRace_100m(Float.NaN);
		record.setRace_1500m(Float.NaN);
		record.setRace_400m(Float.NaN);
		record.setHigh_jump(Float.NaN);
		record.setHurdles_110m(Float.NaN);
		record.setPole_vault(Float.NaN);
		record.setLong_jump(Float.NaN);
		record.setJavelin_throw(Float.NaN);

		assertEquals(0,record.getScore());
	}
	
	/**
	 * Tests infinity.
	 */
	@Test
	public void testInfinity()
	{
		Record record=new Record();
		record.setAthlete("ää&&\"\\");
		record.setDiscus_throw(Float.NEGATIVE_INFINITY);
		record.setHigh_jump(Float.NEGATIVE_INFINITY);
		record.setRace_100m(Float.NEGATIVE_INFINITY);
		record.setRace_1500m(Float.NEGATIVE_INFINITY);
		record.setRace_400m(Float.NEGATIVE_INFINITY);
		record.setHigh_jump(Float.NEGATIVE_INFINITY);
		record.setHurdles_110m(Float.NEGATIVE_INFINITY);
		record.setPole_vault(Float.NEGATIVE_INFINITY);
		record.setLong_jump(Float.NEGATIVE_INFINITY);
		record.setJavelin_throw(Float.NEGATIVE_INFINITY);

		assertEquals(0,record.getScore());
	}
}
