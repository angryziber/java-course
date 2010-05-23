package net.azib.java.students.t050731.homework;

import java.util.Comparator;

/**
 * ScoreComparator
 * 
 * Implements the comparator for camparing athlete scores
 * 
 * @author Raigo
 */
class ScoreComparator implements Comparator<Athlete> {
	public int compare(Athlete athlete1, Athlete athlete2) {
		if (athlete1.getTotalScore() > athlete2.getTotalScore())
			return -1;
		else if (athlete1.getTotalScore() < athlete2.getTotalScore())
			return 1;
		else
			return 0;
	}
}