package net.azib.java.students.t050657.homework.model;

import java.sql.Date;

import junit.framework.TestCase;

import org.junit.Test;
/**
 * AthletTest
 *
 * @author Boriss
 */
public class AthletTest extends TestCase{
	
	@Test
	public void testEquals() {
		Athlet a = new Athlet(1, "Boriss", Date.valueOf("2003-12-12"), "EE");
		Athlet b = new Athlet(2, "Valerij", Date.valueOf("2004-12-12"), "EE");
		Athlet c = new Athlet(3, "Boriss", Date.valueOf("2003-12-12"), "EE");
		
		assertFalse(a.equals(b));
		assertFalse(c.equals(b));
		assertTrue(a.equals(c));
	}

}
