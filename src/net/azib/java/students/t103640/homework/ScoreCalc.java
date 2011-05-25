package net.azib.java.students.t103640.homework;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreCalc {
	final int inCentimeters = 100;

	/**
	 * This method calculates the score of every athlete by using Enum Events and it also calculates the places
	 * of athltes.
	 * @param inputData - ArrayList of athletes whom score must be calculated
	 * @return  - ArrayList of athltes with scores and places
	 */

    public ArrayList<Athlete> calculateScore(ArrayList<Athlete> inputData) {

	    for (Athlete athlete : inputData) {

            Events currentEvent = Events.HUNDREDSPRINT;

           int score = currentEvent.eventScore(athlete.getHundredMSprint());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getLongJump()* inCentimeters);

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getShotPut());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getHighJump()* inCentimeters);

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getFourHundredMSprint());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getHundredAndTenHurdles());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getDiscusThrow());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getPoleVault()* inCentimeters);

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getJavelinThrow());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getKilometerAndHalfRace());


            athlete.setScore(score);

        }

       inputData = getPlaces(inputData);

        return inputData;
    }

	 protected ArrayList<Athlete> getPlaces(ArrayList<Athlete> athletes) {

		Collections.sort(athletes, Collections.reverseOrder());

		ArrayList<Integer> scoresThatDiffer = new ArrayList<Integer>();

		for (Athlete athlete : athletes) {

			if (!scoresThatDiffer.contains(athlete.getScore())) {
				scoresThatDiffer.add(athlete.getScore());
			}

		}

		ArrayList<Integer> scoreCount = new ArrayList<Integer>();

       for (Integer d : scoresThatDiffer) {
           scoreCount.add(0);
       }

		for (Athlete ath : athletes) {

			if (scoresThatDiffer.contains(ath.getScore())) {
				scoreCount.set(scoresThatDiffer.indexOf(ath.getScore()), scoreCount.get(scoresThatDiffer.indexOf(ath.getScore())) + 1);
			}
		}

		int a = 0;
		for (int i = 0; i < scoresThatDiffer.size(); i++) {

			String place = (a + 1) + "-" + (a + scoreCount.get(i));
			int tempBound = a + scoreCount.get(i);

            for (int position = a; position < tempBound; position++) {

					if (scoreCount.get(i) > 1) {
					athletes.get(position).setPlace(place);
					}
					else
					athletes.get(position).setPlace(Integer.valueOf(position + 1).toString());

				a++;
			}
		}
		return athletes;
   }
}

