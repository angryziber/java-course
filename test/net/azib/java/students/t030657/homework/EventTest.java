package net.azib.java.students.t030657.homework;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Karina
 * public class EventTest
 *
 */

public class EventTest  {
	@Test
	public void testEvent() {
		assertEquals("trac100m failed", 952,Event.race100m.getScore(10.60),0);
		assertEquals("longJump failed", 967,Event.longJump.getScore(7.63),0);
		assertEquals("shotPut failed",  784,Event.shotPut.getScore(14.90),0);
		assertEquals("highJump failed",  831,Event.highJump.getScore(2.03),0);
	}  
}