package net.azib.java.students.t960644.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * ResultTest
 * 
 * @author Lembit
 */
public class ResultTest {

	@Test
	public void testCalcForZero() throws Exception {
		Result result = new Result();
		assertEquals(result.calcResult(),0);
		result.setRace100(18.0);
		result.setLongJump(2.20);
		result.setShotPut(1.5);
		result.setHighJump(0.75);
		result.setRace400(82);
		result.setHurdles110(28.5);
		result.setDiscusThrow(4.0);
		result.setPoleVault(1.0);
		result.setJavelinThrow(7.0);
		result.setRace1500(480.0);
		assertEquals(result.calcResult(),0);
	}
	@Test
	public void testCalcForScore() throws Exception {
		Result result = new Result();
		result.setRace100(10.60);
		result.setLongJump(7.63);
		result.setShotPut(14.90);
		result.setHighJump(2.03);
		result.setRace400(46.23);
		result.setHurdles110(14.40);
		result.setDiscusThrow(43.40);
		result.setPoleVault(5.40);
		result.setJavelinThrow(67.01);
		result.setRace1500(269.58);
		assertEquals(result.calcResult(),8815);
		
	}

}
