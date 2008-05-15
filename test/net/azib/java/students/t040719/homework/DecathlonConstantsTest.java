package net.azib.java.students.t040719.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * DecathlonConstantsTest
 *
 * @author romi
 */
public class DecathlonConstantsTest {
	
	@Test
	public void testGetName(){
		assertEquals("Discus throw",DecathlonConstants.DISCUS_THROW.getName());
		assertEquals("1500 m race",DecathlonConstants.FIFTEENHUNDRED_M.getName());
		assertEquals("400 m sprint",DecathlonConstants.FOUR_HUNDRED_M.getName());
		assertEquals("High jump",DecathlonConstants.HIGH_JUMP.getName());
		assertEquals("100 m sprint",DecathlonConstants.HUNDRED_M.getName());
		assertEquals("110 m hurdles",DecathlonConstants.HUNDRED_TEN_M_HURDLES.getName());
		assertEquals("Javelin throw",DecathlonConstants.JAVELIN_THROW.getName());
		assertEquals("Long jump",DecathlonConstants.LONG_JUMP.getName());
		assertEquals("Pole vault",DecathlonConstants.POLE_VAULT.getName());
		assertEquals("Shot put",DecathlonConstants.SHOT_PUT.getName());
	}
	
	@Test
	public void testGetUnit(){
		assertEquals("m",DecathlonConstants.DISCUS_THROW.getUnit());
		assertEquals("min:sec",DecathlonConstants.FIFTEENHUNDRED_M.getUnit());
		assertEquals("min:sec",DecathlonConstants.FOUR_HUNDRED_M.getUnit());
		assertEquals("m",DecathlonConstants.HIGH_JUMP.getUnit());
		assertEquals("sec",DecathlonConstants.HUNDRED_M.getUnit());
		assertEquals("sec",DecathlonConstants.HUNDRED_TEN_M_HURDLES.getUnit());
		assertEquals("m",DecathlonConstants.JAVELIN_THROW.getUnit());
		assertEquals("m",DecathlonConstants.LONG_JUMP.getUnit());
		assertEquals("m",DecathlonConstants.POLE_VAULT.getUnit());
		assertEquals("m",DecathlonConstants.SHOT_PUT.getUnit());
	}
	
	@Test
	public void testGetNext(){
		assertTrue(DecathlonConstants.getOrdinal(0).next() == DecathlonConstants.getOrdinal(1));
		assertTrue(DecathlonConstants.getOrdinal(9).next() == DecathlonConstants.getOrdinal(0));
	}
	
	@Test
	public void testCalculateRunningEventPoints(){
		assertEquals("1294", Integer.toString((int)DecathlonConstants.getOrdinal(4).calculateEventPoints(40.69f)));
	}

	@Test
	public void testCalculateFieldEventPoints(){
		assertEquals("792", Integer.toString((int)DecathlonConstants.getOrdinal(2).calculateEventPoints(15.04f)));
	}
	
	@Test
	public void testGetOrdinal(){
		assertTrue(DecathlonConstants.getOrdinal(0) == DecathlonConstants.HUNDRED_M);
		assertTrue(DecathlonConstants.getOrdinal(9) == DecathlonConstants.FIFTEENHUNDRED_M);
	}
}
