package net.azib.java.students.t030604.homework.parser;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataParser;
import net.azib.java.students.t030604.homework.util.TimeFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Class for parsing data from console input
 * 
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class ConsoleParser implements IDataParser {
	
	//input decisions
	private static final String NO = "no";
	
	private static Scanner scanner = new Scanner(System.in);
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
	
	/** 
	 * @see net.azib.java.students.t030604.homework.IDataParser#cleanup()
	 * {@inheritDoc}
	 */
	public void cleanup() {
		//blank
	}

	/** 
	 * @see net.azib.java.students.t030604.homework.IDataParser#parseData()
	 * {@inheritDoc}
	 */
	public List<AthleteScore> parseData() {
		List<AthleteScore> result = new LinkedList<AthleteScore>();
		
		do {
			result.add(getPlayerScore());
			System.out.println("Continue [yes]/no ?");
		} while (!NO.equalsIgnoreCase(scanner.next()));
		
		
		return result;
	}
	
	//helper method - parses a single PlayerScore
	private AthleteScore getPlayerScore() {
		AthleteScore result = new AthleteScore();
		boolean validityFlag = false;
		do {
			System.out.println("enter player name");
			String temp = scanner.next();
			result.setName(temp);
			Date birthDate = null;
			
			do {
				System.out.println("enter player birthDate [yyyy-mm-dd]");
				temp = scanner.next();
				try {
					birthDate = dateFormat.parse(temp);
				} catch (ParseException ignored) {
					System.out.println("Sorry, wrong format");
				}
			
			} while (birthDate == null);
			result.setBirthDate(birthDate);
			boolean countryValid = false;
			do {
				System.out.println("enter player country (ISO 2-letter code)");
				temp = scanner.next();
				countryValid = temp.trim().length() == 2;
			} while (!countryValid);
			result.setCountry(temp);
			
			result.setSprint100(getValidTime("enter 100m sprint result"));
			result.setLongJump(getValidDistance("enter long jump result"));
			result.setShotPut(getValidDistance("enter shot put result"));
			result.setHighJump(getValidDistance("enter high jump result"));
			result.setSprint400(getValidTime("enter 400m sprint result"));
			result.setHurdles110(getValidTime("enter 110m hurdles result"));
			result.setDiscusThrow(getValidDistance("enter discus throw result"));
			result.setPoleVault(getValidDistance("enter pole vault result"));
			result.setJavelinThrow(getValidDistance("enter javelin throw result"));
			result.setRace1500(getValidTime("enter race result"));
			
			validityFlag  = result.validate();
			if (!validityFlag) {
				System.out.println("Some data seems to be incorrect, you need to start from scratch ");
				System.out.println("those fields didn't pass validation:");
				System.out.println(result.getValidationErrors());
			}
		} while (!validityFlag);
		
		return result;
	}
	
	//used to fetch distance
	private float getValidDistance(String message) {
		Float result = null;
		do {
			System.out.println(message); 
			try {
				result = scanner.nextFloat();
			} catch (Exception ignored) {}
		} while (result == null);
		return result.floatValue();
	}
	
	//used to fetch time
	private float getValidTime(String message) {
		String temp = null;
		Float result = null;
		do {
			System.out.println(message);
			temp = scanner.next();
			result = TimeFormat.parse(temp);
		} while(result == null);
		
		return result.floatValue();
	}
	
	
	/** 
	 * @see net.azib.java.students.t030604.homework.IDataParser#setup(java.lang.String[])
	 * {@inheritDoc}
	 */
	public void setup(String... args) {
		//blank
	}

}
