package net.azib.java.students.t092851.homework;


import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

/**
 * ParticipantTest
 *
 * @author Lauri
 */
public class ParticipantTest {
	
	private RandomString rndStr = new RandomString();
	private Random rnd = new Random();
	private final double[] resultset10000 = new double[] {10.395, 7.760, 18.40, 2.208, 46.17, 13.800, 56.17, 5.287, 77.19, 233.79};
	private final double[] resultset9000  = new double[] {10.827, 7.360, 16.79, 2.104, 48.19, 14.590, 51.40, 4.967, 70.67, 247.42};
	private final double[] resultset8000  = new double[] {11.278, 6.941, 15.16, 1.996, 50.32, 15.419, 46.59, 4.635, 64.09, 261.77};
	private final double[] resultset7000  = new double[] {11.756, 6.510, 13.53, 1.884, 52.58, 16.290, 41.72, 4.292, 57.45, 276.96};
	
	@Test
	public void testGetPoints() {
		assertTrue(createParticipant10000().getPoints() == 10000);
		assertTrue(createParticipant9000().getPoints()  ==  9000);
		assertTrue(createParticipant8000().getPoints()  ==  8000);
		assertTrue(createParticipant7000().getPoints()  ==  7000);
		assertTrue((new Participant()).getPoints()      ==     0);
		
		Participant participant = createParticipantRandom();
		assertTrue(participant.getPoints() <= 10000);
		assertTrue(participant.getPoints() >=  7000);
	}
	
	@Test
	public void testGettersSetters() {
		String   name      = getRandomName();
		String   country   = rndStr.getNext(2);
		String   place     = rndStr.getNext(3);
		Date     date      = new Date(rnd.nextInt());
		double[] resultset = generateRandomResultset();
		
		Participant participant = new Participant();
		participant.setName(name);
		participant.setBirthDate(date);
		participant.setCountry(country);
		participant.setPlace(place);
		giveResults(participant, resultset);
		
		assertTrue(participant.getName().equals(name));
		assertTrue(participant.getBirthDate().equals(date));
		assertTrue(participant.getCountry().equals(country));
		assertTrue(participant.getPlace().equals(place));
		for (DecathlonEvent event : DecathlonEvent.values())
			assertTrue(participant.getResult(event).equals(resultset[event.getIndex()]));
	}
	
	public Participant createParticipant10000() {
		return createParticipant(resultset10000);
	}
	
	public Participant createParticipant9000() {
		return createParticipant(resultset9000);
	}
	
	public Participant createParticipant8000() {
		return createParticipant(resultset8000);
	}
	
	public Participant createParticipant7000() {
		return createParticipant(resultset7000);
	}
	
	public Participant createParticipantRandom() {
		return createParticipant(generateRandomResultset());
	}
	
	private String getRandomName() {
		return rndStr.getNext(rnd.nextInt(20) + 1);
	}
	
	private void giveIdentity(Participant participant) {
		participant.setName(getRandomName());
		participant.setCountry(rndStr.getNext(2));
		participant.setBirthDate(new Date(rnd.nextInt()));
	}
	
	private double[] generateRandomResultset() {
		double[] resultset = new double[DecathlonEvent.countEvents()];
		double upperBound, lowerBound;
		
		for (DecathlonEvent event : DecathlonEvent.values()) {
			if (resultset10000[event.getIndex()] > resultset7000[event.getIndex()]) {
				upperBound = resultset10000[event.getIndex()];
				lowerBound = resultset7000[event.getIndex()];
			}
			else {
				lowerBound = resultset10000[event.getIndex()];
				upperBound = resultset7000[event.getIndex()];
			}
			resultset[event.getIndex()] = lowerBound + rnd.nextDouble() * (upperBound - lowerBound);
		}
		
		return resultset;
	}
	
	private void giveResults(Participant participant, double[] resultset) {
		for (DecathlonEvent event : DecathlonEvent.values())
			participant.setResult(event, resultset[event.getIndex()]);
	}
	
	private Participant createParticipant(double[] resultset) {
		Participant participant = new Participant();
		giveIdentity(participant);
		giveResults(participant, resultset);
		return participant;
	}
	
	private class RandomString {
		private static final String alphabet = " -0123456789abcdefghijklmnoprstuvõäöüžzšxyz";
		private Random random = new Random();

		public String getNext(int len) {
		  StringBuilder sb = new StringBuilder(len);
		  for (int i = 0; i < len; i++)
			  sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		  return sb.toString();
		}
	}
	
}
