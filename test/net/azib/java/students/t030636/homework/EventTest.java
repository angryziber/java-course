package net.azib.java.students.t030636.homework;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * EventTest
 *
 * @author Martin
 */
public class EventTest {
	/**
	 * Test method for {@link net.azib.java.students.t030636.homework.Event#returnPointsForTheEvent(double)}.
	 */
	@Test
	public void testReturnPointsForTheEvent() {
		double [] res = {11.22, 687, 16.17, 89, 43.32, 13.66, 56.02, 441, 101.46, 461.89};
		int [] score ={812, 783, 862, 35, 1148, 1019, 997, 734, 1378, 8};
		for (Event event : Event.values()) {
			assertEquals(score[event.ordinal()], event.returnPointsForTheEvent(res[event.ordinal()]));
		}
	}
}
