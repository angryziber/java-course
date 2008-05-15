package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.ISOCountry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 * InputParser - a class for parsing input data
 *
 * @version 1.0
 * @author Romi Agar
 */
public class InputParser {
	private static final Logger LOG = Logger.getLogger(InputParser.class.getSimpleName());
	
	public static final String DATE_FORMAT = "dd.MM.yyyy"; 
	private static final String REGEX_LONG = "([0-9]+:|)([0-5]|)[0-9]\\.[0-9]{2}";
	private static final String REGEX = "[0-9]*[0-9]\\.[0-9]{2}";
	private static final String SPLIT = ":";
	
	/**
	 * Checks if given name is valid
	 * @param name athlete name as a string
	 * @return true if valid, false otherwise
	 */
	public static boolean isValidName(String name){
		return name.matches("\\w+ \\w+.*");
	}
	
	/**
	 * Removes single quotes from the beginning and at the end of the string
	 * @param str string from which to remove the quotes
	 * @return string without quotes
	 */
	public static String removeQuotes(String str){
		return str.replaceAll("\"(.+)\"","$1");
	}
	
	/**
	 * Parses country code by checking if it is valid
	 * @param isoCode 2-letter ISO country code string
	 * @return isoCode if it is valid or "--" if it is not
	 */
	public static String parseCountryCode(String isoCode){
		if(!ISOCountry.isValidCountryCode(isoCode))
			return "--";
		else
			return isoCode;
	}
	
	/**
	 * Parses date string
	 * @param dateString date string in the format "dd.MM.yyyy" as in CSV files
	 * @return date object if parsing is successful, NULL otherwise
	 */
	public static Date parseDateString(String dateString){
		Date d = null;
		try {
			d = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
		}
		catch (ParseException e) {
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.WARNING, "Error parsing date string: " + dateString, e);
			else
				LOG.log(Level.WARNING, "Error parsing date string: " + dateString);
		}
		return d;
	}
	
	/**
	 * Parses decathlon event times if they are in long format (min:sec)
	 * @param time in the format of min:sec
	 * @return time in seconds (float) if successful, 0.0f otherwise
	 */
	public static float parseLongTime(String time){
		float resultTime = 0.0f;
		Pattern p = Pattern.compile(SPLIT);
        String[] items = p.split(time);
        try{
		    if (items.length == 1)
		    	resultTime = Float.parseFloat(items[0]);
		    else
		    	resultTime = Float.parseFloat(items[0])*60 + Float.parseFloat(items[1]);
        }
        catch(NumberFormatException e){
			if (System.getProperty("program.debug") != null)
				LOG.log(Level.WARNING, "Error parsing time string " + time, e);
			else
				LOG.log(Level.WARNING, "Error parsing time string" + time);
        }
		return resultTime;
	}
	
	/**
	 * Parses all the decathlon event results
	 * @param rawResults as an array of strings
	 * @return event results in float array if successful, NULL if not
	 * TODO: For future development, results should be checked against world records and they shouldn't be excessively bigger
	 */
	public static float[] parseEventResults(String... rawResults){
		if (rawResults.length != 10){
			LOG.log(Level.WARNING, "Event results cound is not 10.");			
			return null;
		}
		float[] results = new float[10];
		for(int i=0; i<10; i++){
			if (i==4 || i==9)
				if(!rawResults[i].matches(REGEX_LONG)){
					LOG.log(Level.WARNING, "Value '" + rawResults[i] + "' does not match regex '" + REGEX_LONG + "'");
					return null;
				}
				else
					results[i] = parseLongTime(rawResults[i]);
			else
				try{
					if(!rawResults[i].matches(REGEX)){
						LOG.log(Level.WARNING, "Value '" + rawResults[i] + "' does not match regex '" + REGEX + "'");
						return null;
					}
					results[i] = Float.parseFloat(rawResults[i]);
				}
				catch(NumberFormatException e){
					if (System.getProperty("program.debug") != null)
						LOG.log(Level.WARNING, "Error parsing number: " + rawResults[i], e);
					else
						LOG.log(Level.WARNING, "Error parsing number: " + rawResults[i]);						
					return null;
				}
		}
		return results;
	}

	/**
	 * @param timeResult time in seconds
	 * @return returns a string of time result formatted in min:sec format
	 */
	public static String formatTime(float timeResult) {
		if (timeResult < 60.0f)
			return String.format(Locale.US, "%.2f", timeResult);
		else
			return Integer.toString((int)Math.floor(timeResult / 60)) + ":" + ((timeResult % 60 < 10)? "0":"") + String.format(Locale.US, "%.2f", (float)(timeResult % 60));
	}
}
