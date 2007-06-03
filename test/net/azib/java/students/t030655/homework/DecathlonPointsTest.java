package net.azib.java.students.t030655.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * DecathlonPointsTest
 *
 * @author Triin Nestor
 */
public class DecathlonPointsTest {
	private DecathlonPoints points = new DecathlonPoints();
	
	/**
	 * Test method for all methods in class DecathlonPoints
	 * 
	 */
	@Test
	public void testPointsCalculation(){
		int total = 536 + 382 + 439 + 389 + 434 + 685 + 302 + 264 + 382 + 421;
		
		points.setSprint100m(12.61);
		points.setLongJump(5.00);
		points.setShotPut(9.22);
		points.setHighJump(1.50);
		points.setSprint400m(59.39);
		points.setHurdles110m(16.43);
		points.setDiscusThrow(21.60);
		points.setPoleVault(2.60);
		points.setJavelinThrow(35.81);
		points.setRace1500m(325.72);
		assertEquals(total, points.totalPoints());
		
	}

}
