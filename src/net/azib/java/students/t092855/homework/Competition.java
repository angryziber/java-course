package net.azib.java.students.t092855.homework;


import java.util.*;

/**
 * Competition
 * holds athletes in a sorted collection, athletes are sorted according to total score
 *
 * @author t092855
 */
public class Competition {
	private final Collection<Athlete> competitors = new TreeSet<Athlete>(new CompetitorComparator());

	/**
	 * Get competitors
	 *
	 * @return collection of athletes that is sorted according to total score in descending order
	 */
	public Collection<Athlete> getCompetitors() {
		return competitors;
	}

	/**
	 * Add an athlete to competition
	 *
	 * @param athlete athlete
	 */
	public void addAthlete (Athlete athlete) {
		competitors.add(athlete);
	}

	/**
	 * Get the place of an athlete in the competition according to total score
	 *
	 * @param athlete athlete
	 *
	 * @return the place of the athlete in the competition according to total score. If the athlete
	 * shares a place with one or more athletes (their total score is equal), the place is output as 2-4
	 */
	public String getAthletePlace(Athlete athlete) {
		int minPlace = findMinimumPlace(athlete.getAthleteEvents().getTotalPoints());
		int maxPlace = findMaximumPlace(athlete.getAthleteEvents().getTotalPoints());

		if (minPlace == maxPlace)
			return String.valueOf(minPlace);
		else
			return String.valueOf(minPlace) + "-" + String.valueOf(maxPlace);
	}

	private int findMinimumPlace(int totalPoints) {
		Iterator<Athlete> iterator = competitors.iterator();
		int i = 1;

		while(iterator.hasNext()) {
			int currentPoints = iterator.next().getAthleteEvents().getTotalPoints();
			if (currentPoints > totalPoints)
			{
				i++;
			}
			else if (currentPoints == totalPoints) {
				break;
			}
		}
		return i;
	}

	private int findMaximumPlace(int totalPoints) {
		Iterator<Athlete> iterator = competitors.iterator();
		int i = 1;

		while(iterator.hasNext()) {
			int currentPoints = iterator.next().getAthleteEvents().getTotalPoints();
			if (currentPoints < totalPoints) {
                break;
			}
			i++;
		}
		return i - 1;
	}
}
