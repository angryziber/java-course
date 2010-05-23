package net.azib.java.students.t050724.homework;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;

/**
 * AthleteTest
 *
 * @author xom
 */
public class AthleteTest {
	
	Athlete athlete = new Athlete();
	
	@Test
	public void testName() throws Exception {
		athlete.setName("Name");
		assertEquals("Name", athlete.getName());
	}
	
	@Test
	public void testDate() throws Exception {
		Date d = Date.valueOf("1985-11-27");
		athlete.setDate(d);
		assertEquals(d, athlete.getDate());
	}
	
	@Test
	public void testCountry() throws Exception {
		athlete.setCountry("EE");
		assertEquals("EE", athlete.getCountry());
	}
	
	@Test
	public void testHm() throws Exception {
		double d = 12.3;
		athlete.setHm(d);
		assertEquals(d, athlete.getHm(), 0.01);
	}
	
	@Test
	public void testLongJump() throws Exception {
		double d = 12.3;
		athlete.setLongJump(d);
		assertEquals(d, athlete.getLongJump(), 0.01);
	}
	
	@Test
	public void testShotPut() throws Exception {
		double d = 12.3;
		athlete.setShotPut(d);
		assertEquals(d, athlete.getShotPut(), 0.01);
	
	}
	
	@Test
	public void testHighJump() throws Exception {
		double d = 12.3;
		athlete.setHighJump(d);
		assertEquals(d, athlete.getHighJump(), 0.01);
	}
	
	@Test
	public void testFhm() throws Exception {
		double d = 12.3;
		athlete.setFhm(d);
		assertEquals(d, athlete.getFhm(), 0.01);
	}
	
	@Test
	public void testHtmHurdles() throws Exception {
		double d = 12.3;
		athlete.setHtmHurdles(d);
		assertEquals(d, athlete.getHtmHurdles(), 0.01);
	}
	
	@Test
	public void testDiscusThrow() throws Exception {
		double d = 12.3;
		athlete.setDiscusThrow(d);
		assertEquals(d, athlete.getDiscusThrow(), 0.01);
	}
	
	@Test
	public void testPoleVault() throws Exception {
		double d = 12.3;
		athlete.setPoleVault(d);
		assertEquals(d, athlete.getPoleVault(), 0.01);
	}
	
	@Test
	public void testJavelinThrow() throws Exception {
		double d = 12.3;
		athlete.setJavelinThrow(d);
		assertEquals(d, athlete.getJavelinThrow(), 0.01);
	}
	
	@Test
	public void testTfhm() throws Exception {
		double d = 12.3;
		athlete.setTfhm(d);
		assertEquals(d, athlete.getTfhm(), 0.01);
	}
	
	public void testScore() throws Exception {
		athlete.setScore(9763);
		assertEquals(9763, athlete.getScore());
	}
	
	@Test
	public void testPlace() throws Exception {
		athlete.setPlace("12");
		assertEquals("12", athlete.getPlace());
	}

}
