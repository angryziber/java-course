package net.azib.java.students.t072054.homework;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * WriteCorrectPlaceTest
 *
 * @author r_vassiljev
 */
public class WriteCorrectPlaceTest {
	
	@Test
	public void checkScore() {
		WriteCorrectPlace wcp = new WriteCorrectPlace(11);
		
		
		wcp.addScore(1, 4343);
		wcp.addScore(2, 4545);
		wcp.addScore(3, 2323);
		wcp.addScore(4, 4343);
		wcp.addScore(5, 4545);
		wcp.addScore(6, 4343);
		wcp.addScore(7, 1212);
		wcp.addScore(8, 1212);
		wcp.addScore(9, 4545);
		wcp.addScore(10, 4343);
		
		assertEquals(wcp.returnPlace(1212), "9-10");
		assertEquals(wcp.returnPlace(4343), "4-5-6-7");
		assertEquals(wcp.returnPlace(4545), "1-2-3");
		assertEquals(wcp.returnPlace(2323), "8");
		
	}
}
