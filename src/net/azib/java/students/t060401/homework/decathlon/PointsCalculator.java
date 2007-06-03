package net.azib.java.students.t060401.homework.decathlon;

import net.azib.java.students.t060401.homework.util.Constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

/**
 * PointsCalculator
 * 
 * Helper class for calculating decathlon points
 * 
 * @author t060401
 */
public class PointsCalculator {

	private static  HashMap<String, Vector<String>> formulaConstants = new HashMap<String, Vector<String>>();
	
	private static final Vector<String> FIELD_EVENTS = new Vector<String>(Arrays.asList(Constants.LONG_JUMP, Constants.SHOT_PUT,
			Constants.HIGH_JUMP, Constants.DISCUS_THROW, Constants.POLE_VAULT, Constants.JAVELIN_THROW));
	
	private static final Vector<String> RUNNING_EVENTS = new Vector<String>(Arrays.asList(Constants.SPRINT_100M, Constants.SPRINT_400M,
			Constants.HURDLES_110M, Constants.RACE_1500M));

	static {
		formulaConstants.put(Constants.SPRINT_100M, new Vector<String>(Arrays.asList("25.437", "18.0", "1.81")));
		formulaConstants.put(Constants.LONG_JUMP, new Vector<String>(Arrays.asList("0.14354", "220", "1.40")));
		formulaConstants.put(Constants.SHOT_PUT, new Vector<String>(Arrays.asList("51.39", "1.5", "1.05")));
		formulaConstants.put(Constants.HIGH_JUMP, new Vector<String>(Arrays.asList("0.8465", "75", "1.42")));
		formulaConstants.put(Constants.SPRINT_400M, new Vector<String>(Arrays.asList("1.53775", "82", "1.81")));
		formulaConstants.put(Constants.HURDLES_110M, new Vector<String>(Arrays.asList("5.74352", "28.5", "1.92")));
		formulaConstants.put(Constants.DISCUS_THROW, new Vector<String>(Arrays.asList("12.91", "4.0", "1.1")));
		formulaConstants.put(Constants.POLE_VAULT, new Vector<String>(Arrays.asList("0.2797", "100", "1.35")));
		formulaConstants.put(Constants.JAVELIN_THROW, new Vector<String>(Arrays.asList("10.14", "7.0", "1.08")));
		formulaConstants.put(Constants.RACE_1500M, new Vector<String>(Arrays.asList("0.03768", "480", "1.85")));
	}

	/**
	 * Calculates points for given field with given performance. Performance value must be given in correct units (meters for field events, seconds for running events).
	 * Long jump and pole vault results must be given in centimeters.
	 * 
	 * @param field field to calculate points for
	 * @param performance performance result
	 * @return
	 */
	public static int calculatePoints(String field, double performance) {
		double points = 0;
		Vector<String> constants = formulaConstants.get(field);
		double a = Double.parseDouble(constants.elementAt(0));
		double b = Double.parseDouble(constants.elementAt(1));
		double c = Double.parseDouble(constants.elementAt(2));
		if (isFieldEvent(field))
		{
			points = a * Math.pow(performance-b, c);
		} 
		else if (isRunningEvent(field))
		{
			if (performance <= 0)
				points = 0;
			else
				points = a * Math.pow(b - performance, c);
		}
		return (int)points;
	}

	private static boolean isRunningEvent(String field)
	{
		return RUNNING_EVENTS.contains(field);
	}
	
	private static boolean isFieldEvent(String field)
	{
		return FIELD_EVENTS.contains(field);
	}
}
