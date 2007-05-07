package net.azib.java.students.t020556.homework;

import java.util.Calendar;
import java.util.EnumMap;
import java.util.Locale;

import antlr.collections.List;

/**
 * Competitor class resembles dechatlon competitors
 *
 * @author Agu Aarna
 * @version 1
 */
public class Competitor {
	private EnumMap<DecathlonEvent.Running, Double> runningEvents = 
		new EnumMap<DecathlonEvent.Running, Double>(DecathlonEvent.Running.class);
	private EnumMap<DecathlonEvent.Field, Double> fieldEvents = 
		new EnumMap<DecathlonEvent.Field, Double>(DecathlonEvent.Field.class);
	
	private String name = "unknown";
	private Calendar dateOfBirth = null;
	private Locale locale = null;
	
	/**
	 * setEventResult method sets the competitor event result
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fieldEvent - specifies an event
	 * @param result - specifies the event's result of the competitor
	 */
	public void setEventResult(DecathlonEvent.Running event, double result){
		runningEvents.put(event, result);
	}
	
	/**
	 * setEventResult method sets the competitor event result
	 * 
	 * @author Agu Aarna
	 * 
	 * @param fieldEvent - specifies an event
	 * @param result - specifies the event's result of the competitor
	 */
	public void setEventResult(DecathlonEvent.Field event, double result){
		fieldEvents.put(event, result);
	}
	
}
