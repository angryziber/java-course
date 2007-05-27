package net.azib.java.students.t010691.homework;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.lang.NullPointerException;

/**
 * InputData
 * 
 * Represents an abstract source of competition data
 *
 * @author Ilja Lutov
 */
abstract class InputData {

	/**
	 * Retrieves next competitor result from data source
	 * Must be overridden by child classes to implement a particular resource
	 *   
	 * @return string array containing competitor data
	 */
	abstract public Competitor nextResult();
	
	/**
	 * Closes input data source
	 * Must be overridden by child classes to deal with specific resource
	 */
	abstract public void close();
	
	/**
	 * Processes raw competition results and creates an athlete instance if valid
	 * 
	 * @param data raw competition data for a single athlete
	 * 
	 * @return competitor instance containing personal information and correct results
	 */
	protected Competitor createCompetitorFromRawData(String[] data) {
		try {
			// Personal data
			String name = data[0].replaceAll("\"", "");
			Date birthDate = new SimpleDateFormat("dd.mm.yyyy").parse(data[1]);
			CountryCode countryCode = CountryCode.valueOf(data[2]);
	
			// Running and field event results are stored in separate maps
			// since different formulas are used to calculate points in each group
			Map<CompetitionEvent, Float> runningResults = new HashMap<CompetitionEvent, Float>();
			Map<CompetitionEvent, Float> fieldResults = new HashMap<CompetitionEvent, Float>();

			// Fill maps with competition results
			runningResults.put(CompetitionEvent.ONE_HUNDRED_METERS_SPRINT, convertStringToFloat(data[3]));
			fieldResults.put(CompetitionEvent.LONG_JUMP, convertStringToFloat(data[4]) * 100);
			fieldResults.put(CompetitionEvent.SHOT_PUT, convertStringToFloat(data[5]));
			fieldResults.put(CompetitionEvent.HIGH_JUMP, convertStringToFloat(data[6]) * 100);
			runningResults.put(CompetitionEvent.FOUR_HUNDRED_METERS_SPRINT, convertStringToFloat(data[7]));
			runningResults.put(CompetitionEvent.ONE_HUNDRED_AND_TEN_METERS_HURDLES, convertStringToFloat(data[8]));
			fieldResults.put(CompetitionEvent.DISCUS_THROW, convertStringToFloat(data[9]));
			fieldResults.put(CompetitionEvent.POLE_VAULT, convertStringToFloat(data[10]) * 100);
			fieldResults.put(CompetitionEvent.JAVELIN_THROW, convertStringToFloat(data[11]));
			runningResults.put(CompetitionEvent.ONE_THOUSAND_AND_FIVE_HUNDRED_METERS_RACE, convertStringToFloat(data[12]));
			
			// Create athlete instance
			return new Competitor(name, birthDate, countryCode, runningResults, fieldResults);
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: data is missing"); 
		}
		catch (IllegalArgumentException e) {
			System.out.println("Error: invalid country code");
		}
		catch (ParseException e) {
			System.out.println("Error: invalid date format");
		}
		catch (NullPointerException e) {
			System.out.println("Error: invalid result");
		}

		return null;
	}
	
	/**
	 * Converts value contained in a string to float equivalent.
	 * String may be either a single number or ':' separated value that
	 * contains minutes and seconds accordingly.
	 * 
	 * @param stringValue competition event performance value
	 * 
	 * @return float equivalent of input argument
	 */
	private Float convertStringToFloat(String stringValue) {
		Float floatValue;
		
		// Try single number
		try {
			floatValue = new Float(stringValue);
		}
		catch (NumberFormatException simpleNumberFormatException) {
			// Try 'minutes:seconds' value
			try {
				String[] complexValue = stringValue.split(":");
				floatValue = new Float(complexValue[0]) * 60;
				floatValue += new Float(complexValue[1]);
			}
			catch (ArrayIndexOutOfBoundsException arrayIndexException) {
				floatValue = null;
			}
			catch (NumberFormatException complexNumberFormatException) {
				floatValue = null;
			}
		}

		// Return competition event performance value as a float number
		return floatValue;
	}
}
