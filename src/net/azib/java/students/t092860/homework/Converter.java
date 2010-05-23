package net.azib.java.students.t092860.homework;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;

/**
 * Utility class consisting methods for converting different data. 
 * Methods can be used directly.
 */
public class Converter {
	
	/**
	 * Converts string representation of time to seconds in double.
	 * 
	 * @param  input time in format (HH:mm:ss.SSS)
	 * @return       seconds in double
	 * @throws Exception if input data in invalid.
	 */
	public static double stringToTime(String input) throws Exception {
		double result = 0;
		String[] splitted = input.split(":");

		if (splitted.length <= 0 || splitted.length > 3)
			throw new Exception("String " + input + " cannot be converted into seconds. ");

		for (int i = splitted.length - 1; i >= 0; i--) {
			result += Double.parseDouble(splitted[i]) * (Math.pow(60, splitted.length - 1 - i));
		}

		return result;
	}
	
	/**
	 * Converts seconds in double into string.
	 * 
	 * @param  input seconds in double
	 * @return       string of time in format (HH:mm:ss.SSS)
	 * @throws Exception if input data in invalid.
	 */
	public static String timeToString(double input) throws Exception {
		String result = "";
		int temp = 0;
		
		while(input > 100.0){
			temp = ((int)input) / 60;
			result += String.valueOf(temp) + ":";
			input = input - temp*60;

		}
		BigDecimal bd = new BigDecimal(Double.toString(input));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		result += String.valueOf(bd);
			
		result = result.replace(',', '.');
		 
		return result;
	}
	
	/**
	 * Converts distance in double into string.
	 * 
	 * @param  input distance (meters) in double
	 * @return       string of distance in decimal precision of 2
	 */
	public static String distanceToString(double input){
		String result = "";
		
		BigDecimal bd = new BigDecimal(Double.toString(input));
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		result += String.valueOf(bd);
		 
		return result;
	}
	
	/**
	 * Converts athletes data to comma separated string.
	 * 
	 * @param  data athletes data
	 * @return      comma separated string of the athletes data
	 * @throws Exception if input data is invalid.
	 */
	public static String athleteToString(Athlete data) throws Exception {
		String out = "";

		out += data.getName();
		try {
			out += "," + SimpleDateFormat.getDateInstance(SimpleDateFormat.FULL, Locale.getDefault()).format(data.getDate());
		}
		catch (NullPointerException e) {
			out += "," + String.valueOf(data.getDate());
		}
		out += "," + data.getCountry();

		Collection<Events> eventsColl = data.getEvents();
		for (Events e : eventsColl){
			if(e.getUnits() == Events.Units.METERS)
				out += "," + distanceToString(data.getEventResult(e));
			else
				out += "," + timeToString(data.getEventResult(e));
		}

		return out;
	}
}
