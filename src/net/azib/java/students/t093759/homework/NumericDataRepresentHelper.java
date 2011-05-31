package net.azib.java.students.t093759.homework;

import java.text.DecimalFormat;

/**
 * Class provides some functionality for minutes and seconds representation as a String etc.
 *
 * @author dionis
 *         5/31/112:43 AM
 */
public class NumericDataRepresentHelper {
	private static NumericDataRepresentHelper instance;
	private static final DecimalFormat decimalSecondsFormat = new DecimalFormat("00.00");
	private static final DecimalFormat decimalMeterFormat = new DecimalFormat("0.00");

	public static NumericDataRepresentHelper getInstance() {
		if (instance == null)
			instance = new NumericDataRepresentHelper();
		return instance;
	}

	/**
	 * Represent minutes and seconds using strict format.
	 *
	 * @param seconds Seconds.
	 * @return Formatted string in "format minutes:seconds.milliseconds".
	 */
	public String representMinuteAndSeconds(double seconds) {
		return new StringBuilder(10).append((int) seconds / 60).append(':')
				.append(representSeconds(seconds)).toString();
	}

	/**
	 * Represent seconds using strict format.
	 *
	 * @param seconds Seconds.
	 * @return Formatted string in "format seconds.milliseconds".
	 */
	public String representSeconds(double seconds) {
		return decimalSecondsFormat.format(seconds % 60);
	}

	/**
	 * Represent meters using strict format.
	 *
	 * @param meters Meters.
	 * @return Formatted string in "format meters.centimeters".
	 */
	public String representMeters(double meters) {
		return decimalMeterFormat.format(meters);
	}
}
