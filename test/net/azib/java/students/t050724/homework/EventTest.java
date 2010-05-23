package net.azib.java.students.t050724.homework;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * EventTest
 *
 * @author xom
 */
public class EventTest {
	
	@Test
	public void testHm() throws Exception {
		Event event1 = Event.valueOf("HM");
		
		assertEquals(1000, event1.eventScore(10.395));
	}
	
	@Test
	public void testLongJump() throws Exception {
		Event event1 = Event.valueOf("LONGJUMP");
		
		assertEquals(1000, event1.eventScore(776));
	}
	
	@Test
	public void testShotPut() throws Exception {
		Event event1 = Event.valueOf("SHOTPUT");
		
		assertEquals(1000, event1.eventScore(18.4));
	
	}
	
	@Test
	public void testHighJump() throws Exception {
		Event event1 = Event.valueOf("HIGHJUMP");
		
		assertEquals(1244, event1.eventScore(245));
	}
	
	@Test
	public void testFhm() throws Exception {
		Event event1 = Event.valueOf("FHM");
		
		assertEquals(1000, event1.eventScore(46.17));
	}
	
	@Test
	public void testHtmHurdles() throws Exception {
		Event event1 = Event.valueOf("HTMHURDLES");
		
		assertEquals(1000, event1.eventScore(13.8));
	}
	
	@Test
	public void testDiscusThrow() throws Exception {
		Event event1 = Event.valueOf("DISCUSTHROW");
		
		assertEquals(1000, event1.eventScore(56.17));
	}
	
	@Test
	public void testPoleVault() throws Exception {
		Event event1 = Event.valueOf("POLEVAULT");
		
		assertEquals(1277, event1.eventScore(614));
	}
	
	@Test
	public void testJavelinThrow() throws Exception {
		Event event1 = Event.valueOf("JAVELINTHROW");
		
		assertEquals(1000, event1.eventScore(77.19));
	}
	
	@Test
	public void testTfhm() throws Exception {
		Event event1 = Event.valueOf("TFHM");
		
		assertEquals(1000, event1.eventScore(233.79));
	}
	

}
