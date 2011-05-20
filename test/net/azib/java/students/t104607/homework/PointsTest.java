package net.azib.java.students.t104607.homework;

import org.junit.Test;
import static junit.framework.Assert.assertEquals;

/**
 * @author 104607 IASM
 */
public class PointsTest {
	@Test
	public void testGetPoints() throws Exception {
		assertEquals(1000, Points.SPRINT100M.getPoints(10.395));
		assertEquals(1000, Points.LONGJUMP.getPoints(7.76));
		assertEquals(1000, Points.SHOTPUT.getPoints(18.4));
		assertEquals(1000, Points.HIGHJUMP.getPoints(2.208));
		assertEquals(1000, Points.SPRINT400M.getPoints(46.17));
		assertEquals(1000, Points.HURDLES110M.getPoints(13.8));
		assertEquals(1000, Points.DISCUSTHROW.getPoints(56.17));
		assertEquals(1000, Points.POLEVAULT.getPoints(5.288));
		assertEquals(1000, Points.JAVELINTHROW.getPoints(77.19));
		assertEquals(1000, Points.RACE1500M.getPoints(233.79));
	}
}
