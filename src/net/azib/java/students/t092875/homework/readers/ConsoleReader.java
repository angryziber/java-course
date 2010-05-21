package net.azib.java.students.t092875.homework.readers;

import net.azib.java.students.t092875.homework.athletes.Athlete;
import net.azib.java.students.t092875.homework.competiotions.Competiotion;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ConsoleReader
 *
 * @author Mihhail
 */
public class ConsoleReader implements DecathlonReader {
	Scanner scanner;
	Locale locale;
	
	//Properties only for testing
	boolean testMode = false;
	String[] eventTestValues;
	String[] dataTestValues;
	
	public ConsoleReader(){
		locale = Locale.getDefault();
		scanner = new Scanner(System.in);
	}
	/**
	 * Read the inputs from the console
	 */
	@Override
	public List<Athlete> read() {
		boolean collecting = true;
		String name = null;
		Date dob = null;
		String origin = null;
		String[] results = null;
		List<Athlete> athletes = new ArrayList<Athlete>();
		int numberOfAthletes=1;
		while(collecting){
			try{
				System.out.println(insertMessage(numberOfAthletes));
				if(testMode){this.changeScanner(dataTestValues[0]);}
				name = setAthleteName();
				if(testMode){this.changeScanner(dataTestValues[1]);}
				dob = setDOB();
				if(testMode){this.changeScanner(dataTestValues[2]);}
				origin = setOrigin();
				results = setEventResults();
				athletes.add(new Athlete(name, dob, origin, results));
				if(testMode){this.changeScanner(dataTestValues[3]);}
				collecting = addAnotherAthlete();
				numberOfAthletes++;
			}catch(Exception e){
				System.out.println("Something went wrong!");
				System.out.println(e.getMessage());
			}
		}
		return athletes;
	}
	
	/**
	 * Returns the user what athlete he should enter
	 * @param athlete - athletes number in the order he was entered
	 * @return A string that informs the user which athlete he enters
	 */
	String insertMessage(int athlete){
		String statement = "Please insert the ";
		switch(athlete){
			case 1: statement += "1st";
				break;
			case 2: statement += "2nd";
				break;
			case 3: statement += "3rd";
				break;
			default: statement += athlete+"th";
		}
		statement += " athlete";
		return statement;
	}
	
	/**
	 * Asking the user to set the name
	 * @return Athletes name
	 * @throws InputMismatchException
	 */
	String setAthleteName() throws InputMismatchException{
		String name = null;
		System.out.println("Input the athletes first- and lastname");
		System.out.println("Example: 'Mihhail Arhipov'");
		name = scanner.nextLine();
		if(name.length()==0){
			throw new InputMismatchException();
		}
		return name; 
	}
	
	/**
	 * Asking the user to set the origin
	 * @return Athletes origin
	 * @throws InputMismatchException
	 */
	String setOrigin() throws InputMismatchException{
		String origin = null;
		System.out.println("Input the athletes origin");
		System.out.println("Example: 'UK'");
		Pattern originPattern = Pattern.compile("[A-Z][A-Z]");
		origin = scanner.next(originPattern);
		return origin;
	}
	
	/**
	 * Asking the user to set the date of birth
	 * @return Athletes date of birth
	 * @throws InputMismatchException
	 */
	Date setDOB() throws ParseException{
		System.out.println("Input the athletes date of birth");
		SimpleDateFormat format = (SimpleDateFormat) DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Format: "+format.toPattern());
		System.out.println("Example: "+format.format(new Date()));
		return format.parse(scanner.next());
	}
	
	/**
	 * Asking the user to set the result of all events
	 * @return Array of all results
	 * @throws InputMismatchException
	 */
	String[] setEventResults()  throws InputMismatchException{
		String[] results = new String[10];
		System.out.println("Enter the athletes results");
		for(int i=0; i<10; i++){
			if(testMode){
				this.changeScanner(eventTestValues[i]);
			}
			results[i] = setEventResult(i);
		}
		return results;
	}
	
	/**
	 * Asking the user to set the result for a specific event
	 * @return Result for a specific event
	 * @throws InputMismatchException
	 */
	String setEventResult(int event)  throws InputMismatchException{
		String result = null; 
		boolean invalidResult = true;
		Pattern pattern;
		System.out.println("Input the result for event " + Competiotion.values()[event].event());
		if(event==0 || event==9 || event==4 || event==5){
			System.out.println("Example: '50.32' (seconds) or '3:45.32' (minutes and seconds)");
			pattern = Pattern.compile("(\\d{1,2}\\.\\d\\d)|(\\d{1,2}:\\d\\d\\.\\d\\d)");
		}else{
			System.out.println("Example: '47.98' (meters)");
			pattern = Pattern.compile("\\d{1,3}.\\d\\d");
		}
		while(invalidResult){
			result = scanner.next(pattern);
			invalidResult = false;
			break;
		} 
		return result;
	}
	
	/**
	 * Check if the user like to add another athlete
	 * @return returns true if user entered Y and false if user entered N
	 */
	boolean addAnotherAthlete(){
		System.out.println("Do you want to add another Athlete [Y/N]");
		String response;
		while(true){
			response = scanner.nextLine();
			if(response.equals("n") || response.equals("N")){
				return false;
			}else if(response.equals("y") || response.equals("Y")){
				return true;
			}else{
				System.out.println("Didn't understand you. Try again");
			}
		}
	}
	
	/**
	 * Change scanner input into String. Only for testing
	 * @param input - String where the result should go
	 */
	void changeScanner(String input){
		scanner = new Scanner(input);
	}
	/**
	 * Activates the test mode. Only for testing
	 * @param mode - if true test mode is active. By default test mode is OFF
	 */
	void changeTestMode(boolean mode){
		this.testMode = mode;
	}
	
	/**
	 * Sets the event results for testing. Only for testing
	 * 
	 * @param eventTestValues - String array containing event results 
	 */
	void setEventTestValues(String[] eventTestValues){
		this.eventTestValues = eventTestValues;
	}
	
	/**
	 * Sets the athlete's data for testing. Only for testing
	 * 
	 * @param dataTestValues - String array containing data about the athlete
	 */
	void setDataTestValues(String[] dataTestValues){
		this.dataTestValues = dataTestValues;
	}
}
