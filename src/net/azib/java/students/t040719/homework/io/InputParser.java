package net.azib.java.students.t040719.homework.io;

import net.azib.java.students.t040719.homework.ISOCountry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	protected static final String DATE_FORMAT = "dd.MM.yyyy"; 
	private static final String REGEX_LONG = "([1-9]+:|)([0-5]|)[0-9]\\.[0-9]{2}";
	private static final String REGEX = "([0-5]|)[0-9]\\.[0-9]{2}";
	private static final String SPLIT = ":";
	
	protected static boolean isValidName(String name){
		return name.matches("\\w+ \\w+.*");
	}
	
	protected static boolean isValidCountryCode(String isoCode){
		return ISOCountry.isValidCountryCode(isoCode);
	}
	
	protected static String removeQuotes(String name){
		return name.replaceAll("\"(.+)\"","$1");
	}
	
	public static String parseName(String name){
		String tempName = removeQuotes(name);
		if(!isValidName(tempName))
			return "";
		else
			return tempName;
	}
	
	public static String parseCountryCode(String isoCode){
		if(!isValidCountryCode(isoCode))
			return "";
		else
			return isoCode;
	}
	
	public static Date parseDateString(String dateString){
		//Locale locale = new Locale(System.getProperty("user.language"));
		//DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
		Date d = null;
		try {
			d = new SimpleDateFormat(DATE_FORMAT).parse(dateString);
		}
		catch (ParseException e) {
			LOG.log(Level.WARNING, "Error parsing date", e);
		}
		return d;
	}
	
	protected static float parseLongTime(String time){
		float resultTime = 0.0f;
		Pattern p = Pattern.compile(SPLIT);
        String[] items = p.split(time);
        try{
		    if (items.length == 1)
		    	resultTime = Float.parseFloat(items[0]);
		    else{
		    	resultTime = Float.parseFloat(items[0])*60;
		    	resultTime += Float.parseFloat(items[1]);
		    }
        }
        catch(NumberFormatException e){
        	System.err.println("Error parsing long time string");
        }
		return resultTime;
	}
	
	public static float[] parseEventResults(String... rawResults){
		if (rawResults.length != 10){
			LOG.log(Level.SEVERE, "Event results cound is not 10.");			
			return null;
		}
		float[] results = new float[10];
		for(int i=0; i<10; i++){
			if (i==4 || i==9)
				if(!rawResults[i].matches(REGEX_LONG)){
					LOG.log(Level.SEVERE, "Value '" + rawResults[i] + "' does not match regex '" + REGEX_LONG + "'");
					return null;
				}
				else
					results[i] = parseLongTime(rawResults[i]);
			else
				try{
					if(!rawResults[i].matches(REGEX)){
						LOG.log(Level.SEVERE, "Value '" + rawResults[i] + "' does not match regex '" + REGEX + "'");
						return null;
					}
					results[i] = Float.parseFloat(rawResults[i]);
				}
				catch(NumberFormatException e){
					LOG.log(Level.SEVERE, "Error parsing number: " + rawResults[i], e);
					return null;
				}
		}
		return results;
	}
}
