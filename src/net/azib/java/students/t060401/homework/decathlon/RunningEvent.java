package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.LanguageUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RunningEvent
 * 
 * Holds data of the decathlon running event including its type, result and points
 * 
 * @author t060401
 */
public class RunningEvent implements DecathlonEvent {

	Logger log = Logger.getLogger(RunningEvent.class.getName());
	private static String MINUTES_DELIMITER = ":";
	private double performanceInSeconds = -1;
	private DecathlonEventEnum eventKey = null;

	/**
	 * @param eventKey decathlon event type
	 */
	public RunningEvent(DecathlonEventEnum eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @param eventKey decathlon event type
	 * @param performanceInSeconds event result in seconds
	 */
	public RunningEvent(DecathlonEventEnum eventKey, double performanceInSeconds) {
		this.eventKey = eventKey;
		this.performanceInSeconds = performanceInSeconds;
	}
	
	/**
	 * @param eventKey decathlon event type
	 * @param performanceInSeconds event result in seconds
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public RunningEvent(DecathlonEventEnum eventKey, String performanceInSeconds) throws IllegalArgumentException {
		this.eventKey = eventKey;
		this.performanceInSeconds = parseTime(performanceInSeconds);
	}

	/**
	 * @return returns points which are calculated according to the official decathlon points formula
	 */
	public int getPoints() {
		return calculatePoints();
	}

	/**
	 * @return returns performance in seconds
	 */
	public double getPerformance() {
		return performanceInSeconds;
	}

	/**
	 * @return returns enum type of the event
	 */
	public DecathlonEventEnum getEventKey() {
		return eventKey;
	}

	/**
	 * @param performance performance in seconds to set
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public void setPerformance(double performance) throws IllegalArgumentException {
		validateTime(performance);
		this.performanceInSeconds = performance;
	}
	
	/**
	 * @param performance performance in seconds to set
	 * @throws IllegalArgumentException
	 *             if performance value cannot be parsed or is negative
	 */
	public void setPerformance(String performanceInSeconds) throws IllegalArgumentException {
		try
		{
			this.performanceInSeconds = parseTime(performanceInSeconds);
		} catch (IllegalArgumentException e) {
			log.log(Level.WARNING, e.getMessage());
			throw e;
		}
	}
	
	private int calculatePoints() {
		double points = 0;
		double a = eventKey.getA();
		double b = eventKey.getB();
		double c = eventKey.getC();
		if (performanceInSeconds <= 0)
			points = 0;
		else
			points = a * Math.pow(b - performanceInSeconds, c);
		return (int) points;
	}
	
	private void validateTime(double time) throws IllegalArgumentException {
		if (time < 0) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.Negative"));
		}
	}

	/**
	 * Parses time string to get seconds value. Minutes and seconds should be
	 * separated with ':'. Minutes value must be postitve integer value, seconds
	 * value must be a positive integer or double value.
	 * 
	 * @param time
	 *            time string to parse
	 * @return returns seconds
	 * @throws IllegalArgumentException
	 *             if time string could not be parsed
	 */
	private double parseTime(String time) throws IllegalArgumentException {
		if (time == null || "".equals(time)) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.Empty"));
		}
		int minutes = extractMinutes(time);
		double seconds = extractSeconds(time);
		double parsedTime = seconds + (double) minutes * (double) 60;
		if (parsedTime < 0) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.Negative"));
		}
		return parsedTime;
	}

	/**
	 * Extracts minutes from time string. Minutes value is separated from
	 * seconds with ':'.
	 * 
	 * @param timeString
	 *            to parse
	 * @return returns minutes
	 * @throws IllegalArgumentException
	 */
	private int extractMinutes(String timeString) throws IllegalArgumentException {
		int minutes = 0;
		if (timeString == null || "".equals(timeString)) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.Empty"));
		}
		String[] timeArray = timeString.split(MINUTES_DELIMITER);
		if (timeArray.length == 2) {
			try {
				minutes = Integer.parseInt(timeArray[0]);
			}
			catch (NumberFormatException e) {
				throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.MinutesValue") + timeArray[0], e);
			}
		}
		return minutes;
	}

	/**
	 * Returns seconds value extracted from time string. Seconds value is
	 * separated from minutes with ':'.
	 * 
	 * @param timeString
	 *            to parse
	 * @return returns seconds
	 * @throws IllegalArgumentException
	 */
	private double extractSeconds(String timeString) throws IllegalArgumentException {
		double seconds = 0;
		if (timeString == null || "".equals(timeString)) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.Empty"));
		}
		String[] timeArray = timeString.split(MINUTES_DELIMITER);
		int lastIndex = timeArray.length - 1;
		try {
			seconds = Double.parseDouble(timeArray[lastIndex]);
		}
		catch (Exception e) {
			throw new IllegalArgumentException(LanguageUtil.getString("RunningEvent.IllegalTime.SecondsValue") + timeArray[lastIndex], e);
		}
		return seconds;
	}

	/**
	 * Separates minutes from seconds value and adds both to a string using
	 * format mm:ss.ss
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("00.00", new DecimalFormatSymbols(Locale.ENGLISH));
		String timeString = df.format(performanceInSeconds);
		int minutes = (int) performanceInSeconds / 60;
		double residue = performanceInSeconds % 60;
		if (minutes != 0)
			timeString = minutes + ":" + df.format(residue);
		return timeString;
	}
}
