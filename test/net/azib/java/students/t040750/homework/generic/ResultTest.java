package net.azib.java.students.t040750.homework.generic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResultTest {

	/**
	 * Test the default constructor.
	 * @throws Exception
	 */
	@Test
	public void testConstructor() throws Exception {
		Result result = new Result();
		
		assertEquals(0.0f, result.run100m);
		assertEquals(0.0f, result.longJump);
		assertEquals(0.0f, result.shotPut);
		assertEquals(0.0f, result.highJump);
		assertEquals(0.0f, result.run400m);
		assertEquals(0.0f, result.hurdles110m);
		assertEquals(0.0f, result.discus);
		assertEquals(0.0f, result.poleVault);
		assertEquals(0.0f, result.javelin);
		assertEquals(0.0f, result.run1500m);
		
	}
	
	/**
	 * Test getters and setters.
	 * @throws Exception
	 */
	@Test
	public void testGettersSetters() throws Exception {
		Result result = new Result();
		
		result.setRun100m(10.94f);
		result.setLongJump(7.83f);
		result.setShotPut(12.48f);
		result.setHighJump(2.0f);
		result.setRun400m(49.72f);
		result.setHurdles110m(15.67f);
		result.setDiscus(38.3f);
		result.setPoleVault(5.4f);
		result.setJavelin(55.84f);
		result.setRun1500m(271.72f);
		
		
		assertEquals(10.94f, result.getRun100m());
		assertEquals(7.83f, result.getLongJump());
		assertEquals(12.48f, result.getShotPut());
		assertEquals(2.0f, result.getHighJump());
		assertEquals(49.72f, result.getRun400m());
		assertEquals(15.67f, result.getHurdles110m());
		assertEquals(38.3f, result.getDiscus());
		assertEquals(5.4f, result.getPoleVault());
		assertEquals(55.84f, result.getJavelin());
		assertEquals(271.72f, result.getRun1500m());
		
	}
}
