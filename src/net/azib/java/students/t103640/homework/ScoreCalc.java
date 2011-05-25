package net.azib.java.students.t103640.homework;

import java.util.ArrayList;
import java.util.Collections;

public class ScoreCalc {

    public ArrayList<Athlete> calculateScore(ArrayList<Athlete> inputData) {
        for (Athlete athlete : inputData) {
            int score = 0;

            Events currentEvent = Events.HUNDREDSPRINT;

            score = currentEvent.eventScore(athlete.getHundredMSprint());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getLongJump());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getShotPut());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getHighJump());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getFourHundredMSprint());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getHundredAndTenHurdles());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getDiscusThrow());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getPoleVault());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getJavelinThrow());

            currentEvent = currentEvent.next();
            score += currentEvent.eventScore(athlete.getKilometerAndHalfRace());


            athlete.setScore(score);

        }

       inputData = getPlaces(inputData);

        return inputData;
    }

   private ArrayList<Athlete> getPlaces(ArrayList<Athlete> athletes) {

		Collections.sort(athletes, Collections.reverseOrder());

		ArrayList<Integer> difScores = new ArrayList<Integer>();

		for (Athlete ath : athletes) {

			if (!difScores.contains(ath.getScore())) {
				difScores.add(ath.getScore());
			}

		}

		ArrayList<Integer> scoreCount = new ArrayList<Integer>();

       for (Integer difScore : difScores) {
           scoreCount.add(0);
       }

		for (Athlete ath : athletes) {

			if (difScores.contains(ath.getScore())) {
				scoreCount.set(difScores.indexOf(ath.getScore()), scoreCount.get(difScores.indexOf(ath.getScore())) + 1);
			}
		}

		int a = 0;
		for (int i = 0; i < difScores.size(); i++) {
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

