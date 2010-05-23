package net.azib.java.students.t050724.homework;

import java.util.ArrayList;
import java.util.Collections;

/**
 * ScoreCalculator
 * 
 * @author xom
 */
public class ScoreCalculator {

	/**
	 * Calculates and sets score value for Athlete object. In addition, sets the
	 * place value, according to score.
	 * 
	 * @param athletes
	 *            ArrayList of athletes without score and place
	 * @return ArrayList of athletes with score and place
	 */
	protected ArrayList<Athlete> calculateScore(ArrayList<Athlete> athletes) {

		for (Athlete athlete : athletes) {

			int score = 0;

			Event event1 = Event.valueOf("HM");
			score += event1.eventScore(athlete.getHm());

			Event event2 = Event.valueOf("LONGJUMP");
			score += event2.eventScore(athlete.getLongJump() * 100);

			Event event3 = Event.valueOf("SHOTPUT");
			score += event3.eventScore(athlete.getShotPut());

			Event event4 = Event.valueOf("HIGHJUMP");
			score += event4.eventScore(athlete.getHighJump() * 100);

			Event event5 = Event.valueOf("FHM");
			score += event5.eventScore(athlete.getFhm());

			Event event6 = Event.valueOf("HTMHURDLES");
			score += event6.eventScore(athlete.getHtmHurdles());

			Event event7 = Event.valueOf("DISCUSTHROW");
			score += event7.eventScore(athlete.getDiscusThrow());

			Event event8 = Event.valueOf("POLEVAULT");
			score += event8.eventScore(athlete.getPoleVault() * 100);

			Event event9 = Event.valueOf("JAVELINTHROW");
			score += event9.eventScore(athlete.getJavelinThrow());

			Event event10 = Event.valueOf("TFHM");
			score += event10.eventScore(athlete.getTfhm());

			athlete.setScore(score);
		}

		athletes = setPositions(athletes);

		return athletes;
	}

	private ArrayList<Athlete> setPositions(ArrayList<Athlete> aths) {

		Collections.sort(aths, Collections.reverseOrder());

		ArrayList<Integer> difScores = new ArrayList<Integer>();

		for (Athlete ath : aths) {

			if (!difScores.contains(ath.getScore())) {
				difScores.add(ath.getScore());
			}

		}

		ArrayList<Integer> scoreCount = new ArrayList<Integer>();

		for (int i = 0; i < difScores.size(); i++) {
			scoreCount.add(0);
		}

		for (Athlete ath : aths) {

			if (difScores.contains(ath.getScore())) {
				scoreCount.set(difScores.indexOf(ath.getScore()), scoreCount.get(difScores.indexOf(ath.getScore())) + 1);
			}
		}

		int a = 0;
		for (int i = 0; i < difScores.size(); i++) {
			String place = (a + 1) + "-" + (a + scoreCount.get(i));
			int tempBound = a + scoreCount.get(i);
			for (int y = a; y < tempBound; y++) {
				if (scoreCount.get(i) > 1) {
					aths.get(y).setPlace(place);
				}
				else
					aths.get(y).setPlace(Integer.valueOf(y + 1).toString());
				a++;
			}
		}
		return aths;
	}

}
