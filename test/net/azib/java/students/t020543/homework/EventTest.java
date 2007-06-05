package net.azib.java.students.t020543.homework;

import static org.junit.Assert.*;

import org.junit.Test;


/**
 * Test for enum <b>{@link Event}</b> methods
 * @author t020543
 * */
public class EventTest {

	private IEvent runningEvent = Event.SPRINT100;
	private IEvent fieldEvent = Event.JAVELIN_THROW;

	/**
	 * Tests enum {@link Event} <i>calculateEvent()</i> method with a particular input
	 * @author t020543
	 * */
	@Test
	public void testCalculateEvent() {
	
	try{
		assertTrue( (runningEvent.calculateEvent(10.10) == 1072) && 
					(fieldEvent.calculateEvent(84.34) == 1110)&&
					(runningEvent.calculateEvent(0) == 0) &&
					(fieldEvent.calculateEvent(0) == 0));
		System.out.println("TEST: Event enum : calculateEvent() => OK");
	}
		catch(AssertionError e){
			System.out.println("ERROR! Event enum : calculateEvent() FAILED!");
		}
	}
	
	/**
	 * Tests enum <b>{@link Event}</b> <i>CompareWorldRecord()</i> method
	 * @author t020543
	 * */
	@Test
	public void testCompareWorldRecord() {
		try{
			assertTrue(runningEvent.compareWorldRecord(8.0) && fieldEvent.compareWorldRecord(100));
			assertFalse(runningEvent.compareWorldRecord(20.0) || fieldEvent.compareWorldRecord(50));
			System.out.println("TEST: Event enum : compareWorldRecord() => OK");
		}
			catch(AssertionError e){
				System.out.println("ERROR! Event enum : compareWorldRecord() FAILED!");
			}
	}
}
