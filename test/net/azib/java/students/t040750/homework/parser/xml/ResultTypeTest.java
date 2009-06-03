package net.azib.java.students.t040750.homework.parser.xml;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResultTypeTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void testProperties() throws Exception {
		ResultType resultType = new ResultType();
		
		assertEquals(0.0f, resultType.run100M);
		assertEquals(0.0f, resultType.longJump);
		assertEquals(0.0f, resultType.shotPut);
		assertEquals(0.0f, resultType.highJump);
		assertEquals(0.0f, resultType.run400M);
		assertEquals(0.0f, resultType.hurdles110M);
		assertEquals(0.0f, resultType.discus);
		assertEquals(0.0f, resultType.poleVault);
		assertEquals(0.0f, resultType.javelin);
		assertEquals(0.0f, resultType.run1500M);
		
		resultType.setRun100M(10.94f);
		resultType.setLongJump(7.83f);
		resultType.setShotPut(12.48f);
		resultType.setHighJump(2.0f);
		resultType.setRun400M(49.72f);
		resultType.setHurdles110M(15.67f);
		resultType.setDiscus(38.3f);
		resultType.setPoleVault(5.4f);
		resultType.setJavelin(55.84f);
		resultType.setRun1500M(271.72f);
		
		assertEquals(10.94f, resultType.getRun100M());
		assertEquals(7.83f, resultType.getLongJump());
		assertEquals(12.48f, resultType.getShotPut());
		assertEquals(2.0f, resultType.getHighJump());
		assertEquals(49.72f, resultType.getRun400M());
		assertEquals(15.67f, resultType.getHurdles110M());
		assertEquals(38.3f, resultType.getDiscus());
		assertEquals(5.4f, resultType.getPoleVault());
		assertEquals(55.84f, resultType.getJavelin());
		assertEquals(271.72f, resultType.getRun1500M());
		
	}
}
