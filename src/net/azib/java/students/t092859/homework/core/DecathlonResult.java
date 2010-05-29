package net.azib.java.students.t092859.homework.core;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.lang.Math;

/**
 * DecathlonResult
 *
 * @author konstantin
 */
public class DecathlonResult{
	private Athlete athlete;
	private Map<Event,Double> performance;
	private int validationResult;
	private Integer points;
	
	public final static Map<String,String> inputPatterns = new LinkedHashMap<String,String>() {
		{
			put("NAME",          "[\\p{L} ()-]+$");
			put("DOB",           ".+");
			put("COUNTRY",       "[A-Z]{2}");
			put("100M",          "\\d{1,2}(\\.\\d+)?");
			put("LONG_JUMP",     "\\d{1,2}(\\.\\d+)?");
			put("SHOT_PUT",      "\\d{1,2}(\\.\\d+)?");
			put("HIGH_JUMP",     "\\d{1}(\\.\\d+)?");
			put("400M",          "(\\d{1,2}:)?\\d{1,2}(\\.\\d+)?");
			put("HURDLES",       "\\d{1,2}(\\.\\d+)?");
			put("DISCUS_THROW",  "\\d{1,2}(\\.\\d+)?");
			put("POLE_VAULT",    "\\d{1,2}(\\.\\d+)?");
			put("JAVELIN_THROW", "\\d{1,2}(\\.\\d+)?");
			put("1500M",         "(\\d{1,2}:)?\\d{1,3}(\\.\\d+)?");
		}
	};
	
	/**Parses decathlon result parameters provided
	 * as arrays of strings in following order:
	 * <br>
	 * <br>Athlete name
	 * <br>Date of birth of athlete
	 * <br>2-letter ISO code of athlete country
	 * <br>100m sprint performance
	 * <br>Long jump performance
	 * <br>Shot put performance
	 * <br>High jump performance
	 * <br>400m sprint performance
	 * <br>110m hurdles performance
	 * <br>Discus throw performance
	 * <br>Pole vault performance
	 * <br>Javelin throw performance
	 * <br>1500m race performance
	 * <br>
	 * Tries to parse date of birth of athlete using
	 * provided country code (using all locales with
	 * this country code. If there is no matching locale,
	 * parsing without locale is attempted.)
	 * <br><br>
	 * Dates of birth before 1.01.1850 are not allowed
	 * 
	 * @param athlete
	 * @param performance
	 */
	public DecathlonResult(String[] parameters) {
		validationResult = -1; //-1 means validation passed
		//validate parameter count
		if(parameters.length != 13) //13 is hardcoded, but this number (number of result fields) must not change
		{
			validationResult = -2;
			return;
		}
		//validate parameters with input patterns
		for(int i = 0; i < 13; i++)
		{
			if(!parameters[i].matches((String)inputPatterns.values().toArray()[i]))
			{
				validationResult = i;
				return;
			}
		}

		//construct Athlete
		//look through available locales with specified country name, try to parse date of birth using them
		Date dateOfBirth = null;
		Locale foundLocale = null;
		for(Locale locale:Locale.getAvailableLocales())
		{
			if(locale.getCountry().equals(parameters[2]))
			{
				foundLocale = locale;
				Locale.setDefault(locale);
				SimpleDateFormat dateFormat = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
				try {
					dateOfBirth = dateFormat.parse(parameters[1]);
				}
				catch (ParseException e) {} //possible to ignore this exception because further dateOfBirth is tested to be null
				if(dateOfBirth != null)
					break;
			}
		}
		if(foundLocale == null)//there was no locale for specified country code
		{
			System.err.println("no locale found for country code: " + parameters[2]);
			foundLocale = new Locale("", parameters[2]);
		}
		if(dateOfBirth == null) //DOB is null if parser failed to parse
		{
			try { //if no birthday was found for locale with specified country, then try without locale
				dateOfBirth = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("")).parse(parameters[1]);
			}
			catch (ParseException e) {}
			if(dateOfBirth == null) //if still could not retrieve date of birth, then sorry
			{
				validationResult = 1;
				return;
			}
		}
		if(dateOfBirth.before(new GregorianCalendar(1850, 0, 1).getTime())) //some reasonable date
		{
			validationResult = 1;
			return;
		}
		
		athlete = new Athlete(parameters[0], dateOfBirth, foundLocale);
		
		performance = new EnumMap<Event, Double>(Event.class);
		for(int i = 3; i < 13; i++)
		{
			Double value;
			String[] valueFragments = parameters[i].split(":");
			try { //although input is already compared to pattern
				if (valueFragments.length == 1){
					Scanner scanner = new Scanner(parameters[i]).useLocale(new Locale("")); //use no locale, hence '.' as decimal separator
					value = scanner.nextDouble();
				}
				else {
					if (valueFragments.length == 2) {
						int minutes = new Scanner(valueFragments[0]).nextInt();
						Scanner scanner = new Scanner(valueFragments[1]).useLocale(new Locale(""));
						Double seconds = scanner.nextDouble();
						value = seconds + minutes * 60;
					}
					else {
						validationResult = i;
						return;
					}

				}
			}
			catch (InputMismatchException e) {
				validationResult = i;
				return;
			}
			performance.put(Event.values()[i-3], value);
		}
		
		
	}

	/**
	 * @return the athlete
	 */
	public Athlete getAthlete() {
		return athlete;
	}

	/**
	 * @return the performance
	 */
	public Map<Event, Double> getPerformance() {
		return performance;
	}

	/**Returns result of input parameter validation.
	 * Validation result =<br>-1 if validation passed,
	 * <br>or parameter number(0-based) on which validation
	 * failed.
	 * 
	 * @return validationResult - result of validation
	 */
	public int getValidationResult() {
		return validationResult;
	}
	
	public int getPoints(){
		if(points == null){
			points = 0;
			for(Entry<Event,Double> eventPerformance : performance.entrySet()){
				Event event = eventPerformance.getKey();
				if(event.getType().equals(EventType.FIELD))
					points += (int)(event.getA()*Math.pow(
							eventPerformance.getValue()*event.getCoef() - event.getB(),
							event.getC()));
				if(event.getType().equals(EventType.TRACK))
					points += (int)(event.getA()*Math.pow(
							event.getB() - eventPerformance.getValue()*event.getCoef(),
							event.getC()));
			}
		}
		return points;
	}
	
	/**
	 * Returns summary of all decathlon result fields
	 * as strings (except points) in following order:
	 * <br>
	 * <br>Points
	 * <br>Athlete name
	 * <br>Date of birth of athlete
	 * <br>2-letter ISO code of athlete country
	 * <br>100m sprint performance
	 * <br>Long jump performance
	 * <br>Shot put performance
	 * <br>High jump performance
	 * <br>400m sprint performance
	 * <br>110m hurdles performance
	 * <br>Discus throw performance
	 * <br>Pole vault performance
	 * <br>Javelin throw performance
	 * <br>1500m race performance
	 * 
	 * @return summary - decathlon result summary
	 */
	public List<String> getSummary(){
		List<String> summary = new ArrayList<String>();
		
		summary.add(new Integer(getPoints()).toString());
		summary.add(getAthlete().getName());
		
		Locale athleteCountryLocale = getAthlete().getCountryLocale();
		Date DOB = getAthlete().getBirthday();
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.SHORT, athleteCountryLocale);
		
		summary.add(dateformat.format(DOB));
		summary.add(athleteCountryLocale.getCountry());
		
		Map<Event, Double> performance = getPerformance();
		for(int i = 0; i < 10; i++)
		{
			Event event = Event.values()[i];
			summary.add(event.formatResult(performance.get(event)));
		}
		
		return summary;
	}
}
