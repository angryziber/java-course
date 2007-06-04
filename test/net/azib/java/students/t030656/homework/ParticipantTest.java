package net.azib.java.students.t030656.homework;

import static org.junit.Assert.*;

import net.azib.java.students.t030656.homework.Participant;

import org.junit.Test;

/**
 * ParticipantTest
 *
 * @author Sprot
 */
public class ParticipantTest {

	/**
	 * Test method for {@link net.azib.java.students.t030656.homework.Participant#compareTo(net.azib.java.students.t030656.homework.Participant)}.
	 */
	@Test
	public void testParticipant() {
		Participant pa1 = new Participant();
		Participant pa2 = new Participant();
		Participant pa3 = new Participant();
		String[] arrString1 = {"1","1","1","1","1","1","1","1","1","1"};
		String[] arrString2 = {"2","2","2","2","2","2","2","2","2","2"};
		pa1.setResults(arrString1);
		pa1.setName("tom");
		assertEquals("Failed! name", "tom", pa1.getName());
		pa1.setCountry("EE");
		assertEquals("Failed! country", "EE", pa1.getCountry());
		pa2.setResults(arrString2);
		pa3.setResults(arrString2);
		assertEquals("Failed! equal", 0, pa2.compareTo(pa3));
		assertEquals("Failed! greater", 1, pa1.compareTo(pa2));
		assertEquals("Failed! lesser", -1, pa3.compareTo(pa1));
		assertEquals("Failed! getPoints", 16320 , pa1.getPoints());
	}

}
