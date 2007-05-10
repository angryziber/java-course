package net.azib.java.students.t020556.homework;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * DecathlonEvent class which contains enumerations to dechtlon events. Events divide into 
 * two categories: Running and Field events.
 *
 * @author Agu Aarna
 * 
 * @version 1
 */
public enum DecathlonEvent {
	//events
	RACE_100M(25.437, 18, 1.81, "100m race", false),
	LONG_JUMP(0.14354, 220, 1.40, "long jump", true),
	SHOT_PUT(51.39, 1.5, 1.05, "shot put", true),
	HIGH_JUMP(0.8465, 75, 1.42, "high jump", true),
	RACE_400M(1.53775, 82, 1.81, "400m race", false),
	HURDLES_110M(5.74352, 28.5, 1.92, "110m hurdle", false),
	DISCUS_THROW(12.91, 4.0, 1.1, "discus throw", true),
	POLE_VAULT(0.2797, 100, 1.35, "pole voult", true),
	JAVELIN_THROW(10.14, 7.0, 1.08, "javelin throw", true),
	RACE_1500M(0.03768, 480, 1.85, "1500m race", false);
	
	//private constants
	private double constA;
	private double constB;
	private double constC;
	private String name;
	private boolean isFieldEvent;
	private DateFormat timeFormatter = new SimpleDateFormat("mm:ss.SS");
	private NumberFormat numberFormatter = NumberFormat.getInstance(Locale.US);
	
	//logger
	private Logger LOG = Logger.getLogger(this.getClass().getName());
	
	/**
	 * The consructor
	 * @author Agu Aarna
	 * 
	 * @param constA - the A constant of the dechatlon points calculation equasion
	 * @param constB - the B constant of the dechatlon points calculation equasion
	 * @param constC - the C constant of the dechatlon points calculation equasion
	 * @param name - specifies the name of the event in human readable format
	 * @param isFieldEvent - specifies if the event is a field event or a running event
	 * 
	 * @version 1
	 */
	DecathlonEvent(
		double constA, double constB, double constC, String name, boolean isFieldEvent
		){
		this.constA = constA;
		this.constB = constB;
		this.constC = constC;
		this.name = name;
		this.isFieldEvent = isFieldEvent;
	}
	
	/**
	 * calculatePoints calculates dechatlon ponints according to the provided result in the
	 * parameter field
	 * @author Agu Aarna
	 * 
	 * @param result - the time value from which to calculate the results; overloads 
	 * calculatePoints(Date). The result has to be in a format "mm:ss.SS" or "ss.SS".
	 * 
	 * @version 1
	 */
	public double calculatePoints(String result){
		if(result == null){
			LOG.severe("Passed argument was null! Unable to colculate points!");
			return 0;
		}
		for(int i = 0; i < 2; i++){
			try {
				if(!isFieldEvent && i < 1)
					return calculatePoints(timeFormatter.parse(result));
				return calculatePoints(numberFormatter.parse(result).doubleValue());
			}
			catch (ParseException e) {
				LOG.warning("Unable to parse result string \"" + result + 
					"\" for the event " + this);
			}
		}
		return 0;
	}

	/**
	 * calculatePoints calculates dechatlon ponints according to the provided result in the
	 * parameter field
	 * @author Agu Aarna
	 * 
	 * @param resultTime - the time value from which to calculate the results. Only minute, second
	 * and millisecond fields will be examined
	 * 
	 * @version 1
	 */
	public double calculatePoints(Date resultTime){
		if(resultTime == null || this.isFieldEvent){
			LOG.severe("Passed argument was invalid! Unable to calculate points!");
			return 0;
		}

		Calendar cal = new GregorianCalendar();
		cal.setTime(resultTime);
		double points =
			(double)cal.get(Calendar.MILLISECOND) / 100 + 
			cal.get(Calendar.MINUTE) * 60 + 
			cal.get(Calendar.SECOND);
		
		//return points
		return calculatePoints(points); 
	}
		
	/**
	 * calculatePoints calculates dechatlon ponints according to the provided result in the
	 * parameter field
	 * @author Agu Aarna
	 * 
	 * @param result - the time value in seconds from which to calculate the results
	 * 
	 * @version 1
	 */
	public double calculatePoints(double result){
		if(isFieldEvent){
			if(	this == HIGH_JUMP ||
				this == LONG_JUMP ||
				this == POLE_VAULT)
				result *= 100;

			result -= constB;
		}
		else
			result = constB - result;
		
		return constA * Math.pow(result, constC);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}
