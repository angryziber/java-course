package net.azib.java.students.t050720.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * RecordTest
 *
 * @author Marek
 */
public class RecordTest {

	/**
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
		System.out.println(r.getScore());
		assertEquals(10485, r.getScore());
	}

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
		System.out.println(record.getScore());
		assertEquals(0, record.getScore());
	}
}
