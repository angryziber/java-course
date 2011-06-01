package net.azib.java.students.t092855.homework;

/**
 * DecathlonEvents
 * Holds results of decathlon events and the sum of all event points.
 *
 * @author t092855
 */
public class DecathlonEvents {
	private int totalPoints = 0;
	private double[] decathlonResults = new double[10];

	/**
	 * DecathlonEvents constructor
	 * Sets all results and calculates total points
	 *
	 * @param results must be in the correct order as defined in {@link DecathlonEvent}
	 */
	public DecathlonEvents (double[] results) {
		setDecathlonResultsAndCalculatePoints(results);
	}

	private void setDecathlonResultsAndCalculatePoints(double[] results) {
		decathlonResults = results;
		totalPoints = calculateTotalPoints();
	}

	/**
	 * Get decathlon results
	 *
	 * @return array of results in the order as defined in {@link DecathlonEvent}
	 */
	public double[] getDecathlonResults() {
		return decathlonResults;
	}

	/**
	 * Get the sum of all points of decathlon events
	 *
	 * @return total points
	 */
	public int getTotalPoints() {
		return totalPoints;
	}

	private int calculateTotalPoints() {
		int result = 0;
		int i = 0;

		for (DecathlonEvent event : DecathlonEvent.values()) {
			result += event.calculatePoints(decathlonResults[i++]);
		}

		return result;
	}

	/**
	 * Validates the decathlon result and converts to number. <br>
	 *
	 * @param result Must comply to the following patterns: mm:ss.cc or ss.cc or ss, <br>
	 *         where mm - minutes, ss - seconds, cc - centiseconds
	 *
	 * @return result in numeric format if it complies to the pattern <br>
	 *     -1.0 if pattern validation fails
	 */
	public static double validateAndConvertResult(String result) {
		String[] components = result.split(":");

		if (components.length == 2) {
			try {
				return Double.parseDouble(components[0]) * 60.0 + Double.parseDouble((components[1]));
			}
			catch (NumberFormatException e) {
				return -1.0;
			}
		}
		if (components.length == 1) {
			try {
				return Double.parseDouble((components[0]));
			}
			catch (NumberFormatException e) {
				return -1.0;
			}
		}
		return -1.0;
	}
}
