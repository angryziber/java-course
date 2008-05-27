package net.azib.java.students.t010588.homework;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Class representing business logic of athletes points scoring, sorting and
 * placing
 *
 * @author Vjatseslav Rosin, 010588
 */
public class DecathlonSummarizer {

	/**
	 * @param athletes
	 *            list to score results and place athletes according to final
	 *            results
	 */
	public void summarize(List<Athlete> athletes) {
		scoreAthletes(athletes);

		Collections.sort(athletes, new ScoreComparator());

		placeAthletes(athletes);
	}

	/**
	 * @param athletes
	 *            list to place basing on athletes total scores
	 */
	private void placeAthletes(List<Athlete> athletes) {
		int firstPlace = 1;
		int lastPlace = 1;

		for (int i = 0; i < athletes.size(); i++) {
			Athlete athlete = athletes.get(i);

			if (i < athletes.size() - 1 && athlete.getScore() == athletes.get(i + 1).getScore()) {
				List<Athlete> sharePlaceAthletes = new LinkedList<Athlete>();
				sharePlaceAthletes.add(athlete);

				int j;
				for (j = i + 1; j < athletes.size(); j++) {
					Athlete nextAthlete = athletes.get(j);

					if (athlete.getScore() != nextAthlete.getScore()) {
						break;
					}
					sharePlaceAthletes.add(nextAthlete);
				}

				int sharedFirstPlace = firstPlace;
				int sharedLastPlace = firstPlace + sharePlaceAthletes.size() - 1;

				for (Athlete sharePlaceAthlete : sharePlaceAthletes) {
					sharePlaceAthlete.setFirstPlace(sharedFirstPlace);
					sharePlaceAthlete.setLastPlace(sharedLastPlace);
				}

				firstPlace = sharedLastPlace + 1;
				lastPlace = sharedLastPlace + 1;
				i = j - 1;
			}
			else {
				athlete.setFirstPlace(firstPlace++);
				athlete.setLastPlace(lastPlace++);
			}
		}
	}

	/**
	 * @param athletes
	 *            list to score total points
	 */
	private void scoreAthletes(List<Athlete> athletes) {
		for (Athlete athlete : athletes) {
			int score = 0;
			for (Result result : athlete.getResults()) {
				score += result.getPoints();
			}

			athlete.setScore(score);
		}
	}
}
