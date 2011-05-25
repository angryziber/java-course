package net.azib.java.students.t103640.homework;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ScoreCalcTest {

	@Test
	public void testEventScoreCalc(){
	 assertEquals(1000, Events.HUNDREDSPRINT.eventScore(10.395));
	 assertEquals(1000, Events.LONGJUMP.eventScore(776));
	 assertEquals(1000, Events.SHOTPUT.eventScore(18.4));
	 assertEquals(1000, Events.HIGHJUMP.eventScore(220.8));
	 assertEquals(1000, Events.HUNDREDANDTMHURDLES.eventScore(13.8));
	 assertEquals(1000, Events.DISCUSTHROW.eventScore(56.17));
	 assertEquals(1000, Events.POLEVAULT.eventScore(528.9));
	 assertEquals(1000, Events.JAVELINTHROW.eventScore(77.19));
	 assertEquals(1000, Events.KILOMETERANDHALF.eventScore(233.79));
	}

	@Test
	public void testPlaceSetting(){
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		Athlete ath = new Athlete();
		Athlete ath2 = new Athlete();
		ath.setScore(1000);
		athletes.add(ath);
		ath2.setScore(1000);
		athletes.add(ath2);

		ScoreCalc scoreC = new ScoreCalc();

		scoreC.getPlaces(athletes);

		for (Athlete athlete : athletes) {
			assertEquals("1-2", athlete.getPlace());
		}

		ArrayList<Athlete> athletes2 = new ArrayList<Athlete>();
		ath.setScore(1002);
		athletes2.add(ath);
		athletes2.add(ath2);
		scoreC.getPlaces(athletes2);

		int i=1;
		for (Athlete athlete : athletes2) {
			assertEquals(i, Integer.parseInt(athlete.getPlace()));
			i++;
		}
	}
}
