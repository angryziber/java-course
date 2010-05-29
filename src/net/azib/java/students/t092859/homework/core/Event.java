package net.azib.java.students.t092859.homework.core;

import java.util.Formatter;
import java.util.Locale;

/**
 * Event
 *
 * @author konstantin
 */
public enum Event {
	SPRINT_100M   (25.4347, 18,   1.81, 1,   EventType.TRACK), //for result in seconds
	LONG_JUMP     (0.14354, 220,  1.4,  100, EventType.FIELD), //for result in centimeters
	SHOT_PUT      (51.39,   1.5,  1.05, 1,   EventType.FIELD), //for result in meters
	HIGH_JUMP     (0.8465,  75,   1.42, 100, EventType.FIELD), //for result in centimeters
	SPRINT_400M   (1.53775, 82,   1.81, 1,   EventType.TRACK), //for result in seconds
	HURDLES_110M  (5.74352, 28.5, 1.92, 1,   EventType.TRACK), //for result in seconds
	DISCUS_THROW  (12.91,   4,    1.1,  1,   EventType.FIELD), //for result in meters
	POLE_VAULT    (0.2797,  100,  1.35, 100, EventType.FIELD), //for result in centimeters
	JAVELIN_THROW (10.14,   7,    1.08, 1,   EventType.FIELD), //for result in meters
	RACE_1500M    (0.03768, 480,  1.85, 1,   EventType.TRACK); //for result in seconds
	
	private final double A; //parameter names as in official scoring table
	private final double B;
	private final double C;
	private final int coef; //coefficient for transforming usual units to
							//those used in scoring table
	private final EventType type;   //type of event - track/field,
									//performance calculation depends on this
	
	Event(double A, double B, double C, int coef, EventType type){
		this.A = A;
		this.B = B;
		this.C = C;
		this.coef = coef;
		this.type = type;
	}
	
	public double getA() {return A;}
	public double getB() {return B;}
	public double getC() {return C;}
	public int getCoef() {return coef;}
	public EventType getType() {return type;}
	
	
	/**
	 * Returns formatted value of event performance according
	 * to event type: track events use [min:]sec format, field
	 * events use meters format. Seconds and meters have 2 decimal places.
	 * @param resultValue - event performance
	 * @return formatted result (string)
	 */
	public String formatResult(Double resultValue)
	{
		String formattedResult = "";
		
		if(type.equals(EventType.TRACK) && resultValue > 60)
		{
			formattedResult += (int)(resultValue/60) + ":" +
			new Formatter().format(new Locale(""), "%05.2f", resultValue % 60).toString();
		}
		else
			formattedResult += new Formatter().format(new Locale(""), "%.2f", resultValue).toString();
		
		return formattedResult;
	}
}
