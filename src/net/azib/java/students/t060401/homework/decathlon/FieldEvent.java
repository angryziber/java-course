package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.LanguageUtil;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FieldEvent
 * 
 * Holds data of the decathlon field event including its type, result and points
 * 
 * @author t060401
 */
public class FieldEvent implements DecathlonEvent {

	Logger log = Logger.getLogger(FieldEvent.class.getName());
	private static String CM_UNIT = "cm";
	private double performanceInMeters = -1;
	private DecathlonEventEnum eventKey = null;

	/**
	 * @param eventKey decathlon event type
	 */
	public FieldEvent(DecathlonEventEnum eventKey) {
		this.eventKey = eventKey;
	}

	/**
	 * @param eventKey decathlon event type
	 * @param performanceInMeterss event result in meters
	 */
	public FieldEvent(DecathlonEventEnum eventKey, double performanceInMeters) {
		this.eventKey = eventKey;
		this.performanceInMeters = performanceInMeters;
	}

	/**
	 * @param eventKey decathlon event type
	 * @param performanceInMeterss event result in meters
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public FieldEvent(DecathlonEventEnum eventKey, String performanceInMeters) throws IllegalArgumentException {
		this.eventKey = eventKey;
		this.performanceInMeters = parseDistance(performanceInMeters);
	}

	/**
	 * @return returns points for the event which are calculated according to the official decathlon points formula
	 */
	public int getPoints() {
		return calculatePoints();
	}

	/**
	 * @return returns performance in meters
	 */
	public double getPerformance() {
		return performanceInMeters;
	}

	/**
	 * @return returns enum type of the event
	 */
	public DecathlonEventEnum getEventKey() {
		return eventKey;
	}

	/**
	 * @param performance performance in meters to set
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public void setPerformance(double performance) throws IllegalArgumentException {
		validateDistance(performance);
		this.performanceInMeters = performance;
	}
	
	/**
	 * @param performance performance in meters to set
	 * @throws IllegalArgumentException
	 *             if performance value is null or negative
	 */
	public void setPerformance(String performanceInMeters) throws IllegalArgumentException {
		try
		{
			this.performanceInMeters = parseDistance(performanceInMeters);
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
		if (CM_UNIT.compareToIgnoreCase(eventKey.getPerformanceUnit()) == 0) {
			points = a * Math.pow(parseMetersToCm(performanceInMeters) - b, c);
		}
		else {
			points = a * Math.pow(performanceInMeters - b, c);
		}
		return (int) points;
	}

	/**
	 * Parses distance string to get meters value. Meters value must be a
	 * positive integer or double value.
	 * 
	 * @param distance
	 * @return returns meters
	 * @throws IllegalArgumentException
	 */
	private double parseDistance(String distance) throws IllegalArgumentException {
		double meters;
		if (distance == null || "".equals(distance)) {
			throw new IllegalArgumentException(LanguageUtil.getString("FieldEvent.IllegalDistance.Empty"));
		}
		try {
			meters = Double.parseDouble(distance);
		}
		catch (NumberFormatException e) {
			throw new IllegalArgumentException(LanguageUtil.getString("FieldEvent.IllegalDistance.Format"), e);
		}
		if (meters < 0) {
			throw new IllegalArgumentException(LanguageUtil.getString("FieldEvent.IllegalDistance.Negative"));
		}
		return meters;
	}

	/**
	 * Converts meters to centimeters.
	 * 
	 * @param meters
	 * @return returns centimeters
	 */
	private int parseMetersToCm(double meters) {
		int intPart = (int) meters;
		double fracPart = meters - intPart;
		return intPart * 100 + (int) Math.round(fracPart * 100);
	}

	/**
	 * Converts double value to string with format mm.mm
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.ENGLISH));
		String distanceString = df.format(performanceInMeters);
		return distanceString;
	}
	
	private void validateDistance(double distance) throws IllegalArgumentException {
		if (distance < 0) {
			throw new IllegalArgumentException(LanguageUtil.getString("FieldEvent.IllegalDistance.Negative"));
		}
	}
}
