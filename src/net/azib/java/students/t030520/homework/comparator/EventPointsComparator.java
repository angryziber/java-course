package net.azib.java.students.t030520.homework.comparator;

import net.azib.java.students.t030520.homework.sportsman.SportsmanWithResults;

import java.util.Comparator;

/**
 * EventPointsComparator for comparing the sportsman's points.
 *
 * @author t030520
 */
public class EventPointsComparator implements Comparator<SportsmanWithResults> {

	/**
	 * Return -1 if obj1 is greater than obj2, 1 if obj2 greater than obj2, 0 if they are equal.
	 */
	@Override
	public int compare(SportsmanWithResults obj1, SportsmanWithResults obj2) {
		if (obj1.getPoints() == obj2.getPoints()) {
			return 0;
		}

	    return obj1.getPoints() > obj2.getPoints() ? -1 : 1;
	  }
}
