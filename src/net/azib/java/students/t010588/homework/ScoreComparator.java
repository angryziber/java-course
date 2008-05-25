package net.azib.java.students.t010588.homework;

import java.util.Comparator;

/**
 * Compares two athletes by number of total points scored
 *
 * @author Vjatseslav Rosin, 010588
 */
public class ScoreComparator implements Comparator<Athlete> {

	public int compare(Athlete o1, Athlete o2) {
		return Integer.valueOf(o2.getScore()).compareTo(Integer.valueOf(o1.getScore()));
	}
}
