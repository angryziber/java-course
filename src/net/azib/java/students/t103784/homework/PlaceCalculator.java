package net.azib.java.students.t103784.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This class is used to calculate the place of the athletes.
 *
 * @author Ott Madis Ozolit <karuott321@hotmail.com>
 * @version 1.6
 * @since 2011.0520
 */
public class PlaceCalculator {
	static int lastAssigned;
	static int currentFirst;
	static int counter;
	static List<Integer> scores = new ArrayList<Integer>();

	/**
	 * Calculates the athlete's place.
	 * <p/>
	 * Sorts the list of athletes according to score,
	 * goes through the list and assigns the place
	 * accordingly. If there are athletes with the same score,
	 * they share places, e.g. 2-4.
	 *
	 * @param contestants The list of athletes supplied.
	 */
	public static void calculatePlace(List<Athlete> contestants) {

		Collections.sort(contestants, new PlaceCalculator.sortByScore());
		lastAssigned = 0;
		currentFirst = 0;
		counter = 1;
		for (int o = 0; o < contestants.size(); o++) {
			scores.add(o, contestants.get(o).getScore());
		}
		scores.add(-1);
		for (int i = 1; i < scores.size(); i++) {
			if (scores.get(i).equals(scores.get(i - 1))) {
				counter++;
			} else {
				if (counter == 1 && lastAssigned != contestants.size()) {
					contestants.get(currentFirst).setPlace(String.valueOf(lastAssigned + 1));
					lastAssigned++;
					currentFirst++;
				} else {
					String temp = String.valueOf(lastAssigned + 1) + " - " +
							String.valueOf(lastAssigned + counter);
					for (int a = lastAssigned; a < counter + lastAssigned; a++) {
						contestants.get(currentFirst).setPlace(temp);
						currentFirst++;
					}
				}
				lastAssigned = +currentFirst;
				counter = 1;
			}
		}
	}

	/**
	 * This class is used to compare the athlete's scores.
	 *
	 * @author Ott Madis Ozolit <karuott321@hotmail.com>
	 * @version 1.6
	 * @since 2011.0520
	 */
	private static class sortByScore implements Comparator<Athlete> {
		/**
		 * Compares the scores of two athletes, checks if they are equal.
		 *
		 * @param o1 Athlete 1.
		 * @param o2 Athlete 1+1.
		 * @return Returns the difference between the scores of the athletes.
		 */
		@Override
		public int compare(Athlete o1, Athlete o2) {
			if (o1.getScore() == o2.getScore()) {
			}
			return o2.getScore() - o1.getScore();
		}
	}
}
