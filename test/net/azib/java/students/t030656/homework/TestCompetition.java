package net.azib.java.students.t030656.homework;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import net.azib.java.students.t030656.homework.Competition;
import net.azib.java.students.t030656.homework.Participant;

import org.junit.Test;

/**
 * TestCompetition
 *
 * @author Sprot
 */
public class TestCompetition {

	/**
	 * Test method for {@link net.azib.java.students.t030656.homework.Competition#getName()}.
	 */
	@Test
	public void testGetName() {
		Competition comp = new Competition();
		comp.setName("Nagano");
		assertEquals("Failed! getName", "Nagano", comp.getName());
	}

	/**
	 * Test method for {@link net.azib.java.students.t030656.homework.Competition#getParticipants()}.
	 */
	@Test
	public void testGetParticipants() {
		Competition comp = new Competition();
		Participant pa = new Participant();
		pa.setName("Katse Jängku");
		comp.addParticipant(pa);
		List<Participant> participants = null;
		participants = new ArrayList<Participant>();
		participants.add(pa);
		assertEquals("Failed! get Participant", participants, comp.getParticipants());
	}

}
