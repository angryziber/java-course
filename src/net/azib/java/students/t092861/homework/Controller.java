/**
 * 
 */
package net.azib.java.students.t092861.homework;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Handles user actions, inputs and outputs.
 * 
 * @author Stanislav / 092861
 * 
 */
public class Controller {

	/**
	 * Current athlete instance.
	 */
	private Athlete athlete;
	
	/**
	 * Used for validating the file/console input.
	 */
	private boolean invalidInput;

	/**
	 * Processes the data from file or console.
	 * 
	 * @param data
	 *            as ArrayList<String>. Each elements of the list consist of 13
	 *            comma separated values.
	 *            Name,Birthday,CountryCode,100m,LJ,SP,HJ
	 *            ,400,110H,DT,PV,JT,1500m
	 * 
	 * @return new Athlete data structure
	 */
	public Athlete readData(ArrayList<String> data) {
		int iter = 0;
		Iterator<String> itr = data.iterator();
		athlete = new Athlete();
		ControllerInput.setController(this);
		while (itr.hasNext() && iter < ControllerInput.Field.values().length) {
			String item = itr.next();
			ControllerInput.Field field = ControllerInput.Field.values()[iter];
			invalidInput = field.parseAndStore(item, athlete);
			if (invalidInput) {
				if (field == ControllerInput.Field.NAME) {
					athlete.setName("Unreadable Name");
					iter++;
				} else {
					throw new ArrayIndexOutOfBoundsException();
				}
			} else {
				iter++;
			}
		}
		int points = calculatePoints(athlete);
		athlete.setScore(points);
		return athlete;
	}

	/**
	 * Checks name validity.
	 * 
	 * @param name
	 *            value to check
	 * @return true of validation is passed
	 */
	public boolean checkName(String name) {
		if (name.contains("\"")) {
			name = removeQuotes(name);
		}
		
		String firstName = "^[\\p{Lu}]{1}[\\p{L}]*[\'-]?[\\p{L}\\s]+";
		String surName = "[\\p{Lu}]{1}[\\p{L}]*[\'-]?[\\p{L}\\s]+$";

		String pattern = firstName + " " + surName;
		return matchesThePattern(pattern, name);
	}

	/**
	 * Checks country code validity.
	 * 
	 * @param countryCode
	 *            value to check
	 * @return true of validation is passed
	 */
	public boolean checkCountry(String countryCode) {
		String pattern = "[A-Z]{2}";
		return matchesThePattern(pattern, countryCode);
	}

	/**
	 * Checks time value validity.
	 * 
	 * @param time
	 *            value to check
	 * @return true of validation is passed
	 */
	public float checkTime(String time) {
		float convertedTime = convertStringToSeconds(time);
		if (convertedTime != -1) {
			return convertedTime;
		} else if (!time.contains(":")) {
			return Float.valueOf(time);
		}
		return -1;
	}

	/**
	 * Checks meters value validity.
	 * 
	 * @param meters
	 *            value to check
	 * @return true of validation is passed
	 */
	public boolean checkMeters(String meters) {
		String pattern = "^[\\d]{1,}[\\.]*[\\d]*$";
		return matchesThePattern(pattern, meters);
	}

	/**
	 * Used for matching the String with pattern.
	 * 
	 * @param patt
	 *            to validate against
	 * @param str
	 *            value to check
	 * @return true of matches the pattern
	 */
	private static boolean matchesThePattern(String patt, String str) {
		Pattern pattern = Pattern.compile(patt);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	/**
	 * Parsing String to time in seconds.
	 * 
	 * @param str
	 *            string to parse
	 * @return time in seconds
	 */
	private float convertStringToSeconds(String str) {
		DecimalFormat nf = (DecimalFormat) NumberFormat.getInstance();
		nf.setParseBigDecimal(true);
		BigDecimal bMin = new BigDecimal(0), bSec = new BigDecimal(0), bMSec = new BigDecimal(0);
		try {
			if (str.contains(":")) {// convert 5:25.72 to 325.72
				
				bMin = new BigDecimal(str.substring(0, str.lastIndexOf(":"))).multiply(new BigDecimal(60));
				bSec = new BigDecimal(str.substring(str.lastIndexOf(":") + 1));

			} else { // convert 25.72 to 25.72
				bMSec = new BigDecimal(str);
			}
		} catch (Exception e) {
			return -1;
		}
		BigDecimal sum = bMin.add(bSec).add(bMSec);
		return sum.floatValue();
	}

	/**
	 * Used for removing the quotes from name.
	 * 
	 * @param name
	 *            to process
	 * @return name without the quotes
	 */
	public String removeQuotes(String name) {
		return name.replaceAll("\"", "");
	}
	
	/**
	 * Used for inserting the quotes to the name.
	 * 
	 * @param name
	 *            to process
	 * @return name with the quotes
	 */
	public String indertQuotes(String name) {
		return "\"" + name + "\"";
	}
	
	/**
	 * Arranging the athletes in descending order of the total score (ascending
	 * order of their places).
	 * 
	 * @param athletes
	 *            - non arranged list.
	 * @return ascending ordered list.
	 */
	public ArrayList<Athlete> arrangeInOrder(ArrayList<Athlete> athletes) {
		// modified merge sort of athlete scores
		Collections.sort(athletes, new Comparator<Athlete>() {
			@Override
			public int compare(Athlete a, Athlete b) {
				return (a.getScore() < b.getScore() ? 1 : (a.getScore() > b	.getScore() ? -1 : 0));
			}
		});
		
		// setting athletes places
		String place = "1";
		int start = 0, count = 0;
		athletes.get(0).setPlace(place);
		for (int i = 1; i < athletes.size(); i++) {
			if(athletes.get(i).getScore() == athletes.get(i-1).getScore()){
				count++;
			}
			if(athletes.get(i).getScore() != athletes.get(i-1).getScore()){
				place = String.valueOf(Integer.valueOf(place) + count + 1);
				count = 0;
			}
			athletes.get(i).setPlace(place);
		}
		
		count = 0;
		for (int i = 1; i < athletes.size(); i++) {
			if(athletes.get(i).getPlace() == athletes.get(i-1).getPlace()){
				if(start == 0){
					start = i;
				}
				count++;
				if (i!=athletes.size()-1) {
					continue;
				}
			}
			if (count>0) insertSpacesInSamePlaces(athletes, start, start + count);
			count = start = 0;
		}
		return athletes;
	}

	private ArrayList<Athlete> insertSpacesInSamePlaces(ArrayList<Athlete> a, int start, int end) {
		ArrayList<Athlete> athletes = a; 
		for (int i = start-1; i < end; i++) {
			athletes.get(i).setPlace(start+"-"+(end));
		}
		return athletes;
	}

	/**
	 * Calculate points for athlete.
	 * 
	 * @param a
	 *            - athlete for whom calculating the points
	 * @return number of point as int
	 */
	public int calculatePoints(Athlete a) {
		int points = 0;
		points = Double.valueOf(
				Const.SPRING_100_A // track event
						* Math.pow(Const.SPRING_100_B - a.getSprint100(),
								Const.SPRING_100_C)).intValue();

		points += Double.valueOf(
				Const.LONG_JUMP_A // cm
						* Math.pow(a.getLongJump() * 100 - Const.LONG_JUMP_B,
								Const.LONG_JUMP_C)).intValue();

		points += Double.valueOf(
				Const.SHOT_PUT_A
						* Math.pow(a.getShortPut() - Const.SHOT_PUT_B,
								Const.SHOT_PUT_C)).intValue();

		points += Double.valueOf(
				Const.HIGH_JUMP_A // cm
						* Math.pow(a.getHighJump() * 100 - Const.HIGH_JUMP_B,
								Const.HIGH_JUMP_C)).intValue();

		points += Double.valueOf(
				Const.SPRING_400_A // track event
						* Math.pow(Const.SPRING_400_B - a.getSprint400(),
								Const.SPRING_400_C)).intValue();

		points += Double.valueOf(Const.HURDLES_A // track event
				* Math.pow(Const.HURDLES_B - a.getHurdles(), Const.HURDLES_C))
				.intValue();

		points += Double.valueOf(
				Const.DISCUS_THROW_A
						* Math.pow(a.getDiscusThrow() - Const.DISCUS_THROW_B,
								Const.DISCUS_THROW_C)).intValue();

		points += Double.valueOf(
				Const.POLE_VAULT_A // cm
						* Math.pow(a.getPoleVault() * 100 - Const.POLE_VAULT_B,
								Const.POLE_VAULT_C)).intValue();

		points += Double.valueOf(
				Const.JAVELIN_THROW_A
						* Math.pow(a.getJavelinThrow() - Const.JAVELIN_THROW_B,
								Const.JAVELIN_THROW_C)).intValue();

		points += Double.valueOf(Const.RACE_A // track event
				* Math.pow(Const.RACE_B - a.getSprint1500(), Const.RACE_C))
				.intValue();

		return points;
	}
}
