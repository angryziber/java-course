package net.azib.java.students.t092860.homework;

import java.lang.Math;
import java.util.Collection;
import java.util.Iterator;

/**
 * Converter
 *
 * @author scythe
 */
class Converter {
	
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
	
	public static String athleteToString(Athlete data)
	{
		String out = "";
		
		out += "," + data.getName();
		out += "," + data.getDate();
		out += "," + data.getCountry();
		
		Collection<Double> coll = data.getEventResults();
		Iterator<Double>  eventsIt = coll.iterator();
		while(eventsIt.hasNext())
			out += "," + String.valueOf(eventsIt.next());
		
		return out;
	}
}
