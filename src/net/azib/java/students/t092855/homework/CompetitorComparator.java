package net.azib.java.students.t092855.homework;


import java.util.Comparator;

/**
 * Comparator for comparing athletes in a competition
 *
 * @author t092855
 */
class CompetitorComparator implements Comparator<Athlete> {

	/**
	 * Compares two athletes according to total score
	 *
	 * @param o1 athlete1
	 *
	 * @param o2 athlete2
	 *
	 * @return -1 if athlete1 total score is bigger than athlete2 total score.
	 *         -1 if athlete1 and athlete 2 scores are the same.
	 *         1 if athlete1 total score is smaller than athlete2 total score
	 */
		@Override
		public int compare(Athlete o1, Athlete o2) {
			Integer result1 = o1.getAthleteEvents().getTotalPoints();
			Integer result2 = o2.getAthleteEvents().getTotalPoints();

			if (result1.compareTo(result2) == 0) {
				return -1;
			}
			else
				return -result1.compareTo(result2);
		}
	}