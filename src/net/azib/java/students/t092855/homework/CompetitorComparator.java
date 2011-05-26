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
	 *         0 if athlete1 and athlete 2 are equal based on name, birthday, total points and country.
	 *         1 if athlete1 total score is smaller than athlete2 total score
	 */
		@Override
		public int compare(Athlete o1, Athlete o2) {
			Integer comparison = o2.getAthleteEvents().getTotalPoints() - o1.getAthleteEvents().getTotalPoints();
			if (comparison != 0)
				return (int) Math.signum(comparison);

			comparison = o1.getName().compareTo(o2.getName());
			if (comparison != 0)
				return (int) Math.signum(comparison);

			comparison = o1.getBirthday().compareTo(o2.getBirthday());
			if (comparison != 0)
				return (int) Math.signum(comparison);

			comparison = o1.getCountry().compareTo(o2.getCountry());
			if (comparison != 0)
				return (int) Math.signum(comparison);

			return 0;
		}
	}