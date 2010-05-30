package net.azib.java.students.t092851.homework;


import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;


/**
 * DecathlonDataTest
 *
 * @author Lauri
 */
public class DecathlonDataTest {
	
	private final ParticipantTest athleteFactory = new ParticipantTest();
	static private final int max_count = 100; 
	
	
	@Test
	public void testInsert() {
		DecathlonData data = new DecathlonData();
		long lastPoints = Long.MAX_VALUE;
		int  counter = 0;
		
		// Add new participants to competition
		for (int i = 0; i < max_count - 2; i ++)
			data.insert(athleteFactory.createParticipantRandom());
		
		// At least two athletes have equal number of points
		data.insert(athleteFactory.createParticipant8000());
		data.insert(athleteFactory.createParticipant8000());
		
		// Check that participants are sorted by score in descending order
		for (Participant participant : data) {
			assertTrue(lastPoints >= participant.getPoints());
			lastPoints = participant.getPoints();
			counter++;
		}
		
		// The same number of participants are in list as entered
		assertTrue(max_count == counter);
	}
	
	
	@Test
	public void testRankParticipants() {

		// Case1 - no place sharing 
		{
			DecathlonData data = new DecathlonData();
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant9000());
			data.insert(athleteFactory.createParticipant10000());
			data.insert(athleteFactory.createParticipant7000());
			data.rankParticipants();
			Iterator<Participant> iterator = data.iterator();
			assertTrue(iterator.next().getPlace().equals("1"));
			assertTrue(iterator.next().getPlace().equals("2"));
			assertTrue(iterator.next().getPlace().equals("3"));
			assertTrue(iterator.next().getPlace().equals("4"));
		}
		
		// Case2 - place sharing at the beginning 
		{
			DecathlonData data = new DecathlonData();
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant9000());
			data.insert(athleteFactory.createParticipant9000());
			data.insert(athleteFactory.createParticipant9000());
			data.rankParticipants();
			Iterator<Participant> iterator = data.iterator();
			assertTrue(iterator.next().getPlace().equals("1-3"));
			assertTrue(iterator.next().getPlace().equals("1-3"));
			assertTrue(iterator.next().getPlace().equals("1-3"));
			assertTrue(iterator.next().getPlace().equals("4"));
		}
		
		// Case3 - place sharing at the end 
		{
			DecathlonData data = new DecathlonData();
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant9000());
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant8000());
			data.rankParticipants();
			Iterator<Participant> iterator = data.iterator();
			assertTrue(iterator.next().getPlace().equals("1"));
			assertTrue(iterator.next().getPlace().equals("2-4"));
			assertTrue(iterator.next().getPlace().equals("2-4"));
			assertTrue(iterator.next().getPlace().equals("2-4"));
		}
		
		// Case4 - place sharing in the middle 
		{
			DecathlonData data = new DecathlonData();
			data.insert(athleteFactory.createParticipant7000());
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant9000());
			data.rankParticipants();
			Iterator<Participant> iterator = data.iterator();
			assertTrue(iterator.next().getPlace().equals("1"));
			assertTrue(iterator.next().getPlace().equals("2-3"));
			assertTrue(iterator.next().getPlace().equals("2-3"));
			assertTrue(iterator.next().getPlace().equals("4"));
		}
		
		// Case4 - all shared 
		{
			DecathlonData data = new DecathlonData();
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant8000());
			data.insert(athleteFactory.createParticipant8000());
			data.rankParticipants();
			Iterator<Participant> iterator = data.iterator();
			assertTrue(iterator.next().getPlace().equals("1-4"));
			assertTrue(iterator.next().getPlace().equals("1-4"));
			assertTrue(iterator.next().getPlace().equals("1-4"));
			assertTrue(iterator.next().getPlace().equals("1-4"));
		}
	}
}
