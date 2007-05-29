package net.azib.java.students.t020632.homework;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert
.*;

/**
 * TestEvent is a test class for Event class
 *
 * @author Marek Soobik t020632
 */
public class TestEvent {

	EventFactory factory;
	Event event;
	
	
	@Before
	public void setUp() throws Exception {
		factory = new EventFactory();
	}

	
	/**
	 * Tests whether the points calculation works correctly
	 * 
	 * @throws Exception
	 */
	@Test
	public void testCalculate() throws Exception {
		float [] results = new float [] {9.77F, 895F, 23.12F, 245F, 43.18F, 12.91F, 74.08F, 615F, 98.48F, 206.0F};
		int [] scores = new int [] {1154, 1312, 1295, 1244, 1156, 1120, 1383, 1281, 1331, 1218};
		int i = 0;
		
		for(EventInfo info : EventInfo.values()){
			event = factory.createEvent(info);
			event.setResult(results[i]);
			System.out.println(event.getResult());
			assertEquals(event.calculate(), scores[i]);
			System.out.println(event.calculate());
			i++;
		}
	}
	
	@After
	public void tearDown() throws Exception {
		factory = null;
	}

}
