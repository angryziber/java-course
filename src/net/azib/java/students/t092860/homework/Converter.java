package net.azib.java.students.t092860.homework;

import java.lang.Math;
import java.util.Collection;

/**
 * Converter
 *
 * @author scythe
 */
class Converter {
	
	/**
	 * Converts string representation of time to seconds in float
	 * 
	 * @param  input time in format (HH:mm:ss.SSS)
	 * @return       seconds in float
	 */
	//convert String representation of time (HH:mm:ss.SSS) to seconds in float
	public static double stringToTime(String input) throws Exception
	{
		float result = 0;
		String[] splitted = input.split(":");
		
		if (splitted.length <= 0 || splitted.length > 3)
			throw new Exception("String "+input+" cannot be converted into seconds. ");
		
		for(int i=splitted.length-1; i>=0; i--)
		{
			result += Double.parseDouble(splitted[i])*(Math.pow(60,splitted.length-1-i));
		}

		return result;
	}
	
	/**
	 * Converts athletes data to comma separated string
	 * 
	 * @param  data athletes data
	 * @return      comma separated string of the athletes data
	 */
	public static String athleteToString(Athlete data)
	{
		String out = "";
		
		out += data.getName();
		out += "," + data.getDate();
		out += "," + data.getCountry();
		
		Collection<Events> eventsColl = data.getEvents();
		for(Events e: eventsColl)
			out += "," + String.valueOf(data.getEventResult(e));
		
		return out;
	}
}
