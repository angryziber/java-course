package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * EventTest
 * 
 * @author ValleTon
 */
public class EventTest {

	@Test
	public void testCalculatePoints() {
		float[] records = {9.69f,8.95f,23.12f,2.45f,43.18f,12.87f,74.08f,6.14f,98.48f,206f};
		short[] bestScores = {1174,1312,1295,1244,1156,1126,1383,1277,1331,1218};
		
		for (Event e : Event.values()){
			assertEquals(bestScores[e.ordinal()],e.calculatePoints(records[e.ordinal()]));
		}
	}

	@Test
	public void testIsTrackEvent(){
		boolean[] expected = {true,false,false,false,true,true,false,false,false,true};
		for (Event e : Event.values()){
			assertTrue(expected[e.ordinal()]==e.isTrackEvent());
		}
	}
}
