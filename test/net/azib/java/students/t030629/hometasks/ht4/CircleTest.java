package net.azib.java.students.t030629.hometasks.ht4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


/**
 * CircleTest
 *
 * @author anton_chepurov
 */
public class CircleTest {
	
	private Circle aCircle;
	
	@Before
	public void createCircle(){
		aCircle = new Circle(3);
	}
	
	@Test
	public void testEquals(){	
		assertFalse(aCircle.equals(new Circle(10)));
		assertTrue(aCircle.equals(new Circle(3)));
	}
	
	@Test
	public void referencesAfterCloneAreNotEqual(){
		assertNotSame(aCircle.clone(), aCircle);
	}
	
	@Test
	public void fieldsAfterCloneAreEqual(){
		assertTrue(aCircle.equals(aCircle.clone()));
	}
	
	@Test
	public void testAreaPrecision(){
		assertCorrectPrecision(28.27433, aCircle.area());
		assertCorrectPrecision(0, new Circle().area());
		assertCorrectPrecision(314.15926, new Circle(10).area());		
	}
	
	private void assertCorrectPrecision(double expected, double actual){
		double difference = actual - expected;
		assertTrue(Math.abs(difference) <= 0.00001);
	}
	
	@Test
	public void testToString(){
		assertEquals("Circle with radius 3.0", aCircle.toString());
		assertEquals("Circle with radius 100.0", new Circle(100).toString());		
	}
	
}
