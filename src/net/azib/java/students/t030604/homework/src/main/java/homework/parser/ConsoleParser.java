package main.java.homework.parser;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import main.java.homework.IDataParser;
import main.java.homework.domain.PlayerScore;

/**
 * @author Aleksandr Ivanov
 * <a href="mailto:aleks21@gmail.com">contact</a>
 */
public class ConsoleParser implements IDataParser {
	
	//input decisions
	private static final String YES = "yes";
	private static final String NO = "no";
	
	private static Scanner scanner = new Scanner(System.in);
	private static DateFormat dateFormat = DateFormat.getDateInstance(); 
	
	
	static {
		dateFormat.setLenient(true);
	}
	

	/* (non-Javadoc)
	 * @see main.java.homework.IDataParser#cleanup()
	 */
	@Override
	public void cleanup() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see main.java.homework.IDataParser#parseData()
	 */
	@Override
	public List<PlayerScore> parseData() {
		
		System.out.println("Enter the results in the following format");
		System.out.println("Name,dateOfBirth,CountryCode,Results");
		
		List<PlayerScore> result = new LinkedList<PlayerScore>();
		
		do {
			result.add(getPlayerScore());
			System.out.println("Continue [yes]/no ?");
		} while (!NO.equalsIgnoreCase(scanner.next()));
		
		
		return result;
	}
	//helper method - parses a single PlayerScore
	private PlayerScore getPlayerScore() {
		PlayerScore result = new PlayerScore();
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
				//TODO check ISO code
				countryValid = true;
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
			} catch (Exception ignored) {
				//TODO exception handling
			}
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
			//firstly try to parse simple seconds
			try {
				result = new Float(temp);
			} catch (NumberFormatException ignored) {
				//ouch, let's try smth else
			}
			String[] splitted = temp.split(":");
			if (splitted.length == 2) {
				Float minutes = null;
				Float seconds = null;
				try {
					minutes = new Float(splitted[0]);
					seconds = new Float(splitted[1]);
				} catch (NumberFormatException ignored) {
					//well, better luck next time
				}
				//simple sane check
				if (minutes > 0F && seconds > 0F && seconds < 60F) {
					result = minutes * 60F + seconds;
				}
			}
		} while(result == null);
		
		return result.floatValue();
	}
	

	/* (non-Javadoc)
	 * @see main.java.homework.IDataParser#setup(java.lang.String[])
	 */
	@Override
	public void setup(String... args) {
		System.out.println("Console parser initialised");
	}

}
