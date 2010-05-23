package net.azib.java.students.t050724.homework;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Scanner
 *
 * @author xom
 */
public class ConsoleReader {
	
	SupportClass supporter = new SupportClass();
	private Scanner input = new Scanner(System.in);
	
	/**
	 * Gets input data from console, checks it's validity, puts it into Athlete object and returns the object.
	 * 
	 * @return Athlete object that has been filled with input data.
	 */
	protected ArrayList<Athlete> getDataFromConsole() {
		
		boolean end = false;
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
	
		while (!end){
			
			Athlete athleteFromConsole = new Athlete();
			
			System.out.println("Insert athletes name!");
			athleteFromConsole.setName(setAthleteName());
			
			System.out.println("Insert athletes date of birth (dd.mm.yyy)!");
			athleteFromConsole.setDate(setAthleteDate());
			
			System.out.println("Insert athletes country code(upper case)!");
			athleteFromConsole.setCountry(setAthleteCountry());
			
			System.out.println("Insert athletes 100 m sprint result (sec)!");
			athleteFromConsole.setHm(setAthleteResultDouble());
			
			System.out.println("Insert athletes long jump result (m)!");
			athleteFromConsole.setLongJump(setAthleteResultDouble());
			
			System.out.println("Insert athletes shot put result (m)!");
			athleteFromConsole.setShotPut(setAthleteResultDouble());
			
			System.out.println("Insert athletes high jump result (m)!");
			athleteFromConsole.setHighJump(setAthleteResultDouble());
			
			System.out.println("Insert athletes 400 m sprint result (min:sec or sec)!");
			athleteFromConsole.setFhm(setAthleteResultDoubleWithMins());
			
			System.out.println("Insert athletes 110 m hurdles result (sec)!");
			athleteFromConsole.setHtmHurdles(setAthleteResultDouble());
			
			System.out.println("Insert athletes discus throw result (m)!");
			athleteFromConsole.setDiscusThrow(setAthleteResultDouble());
			
			System.out.println("Insert athletes pole vault result (m)!");
			athleteFromConsole.setPoleVault(setAthleteResultDouble());
			
			System.out.println("Insert athletes javelin throw result (m)!");
			athleteFromConsole.setJavelinThrow(setAthleteResultDouble());
			
			System.out.println("Insert athletes 1500 m race result (min:sec or sec)!");
			athleteFromConsole.setTfhm(setAthleteResultDoubleWithMins());
			
			athletes.add(athleteFromConsole);
			athleteFromConsole = null;
			
			System.out.println("Enter another athlete? (y/n)");
			end = getEndCondition();
			
		}
		return athletes;		
	}
	
	private boolean getEndCondition() {
		
		String inDecision;
		boolean decision = false;
		boolean decisionMade = false;
		
		while(!decision){
			
			inDecision = input.nextLine();
			
			if (inDecision.equals("y")){
				decision = true;
				decisionMade = false;
			}
			else if (inDecision.equals("n")){
				decision = true;
				decisionMade = true;
			}					
			else{
				System.out.println("Insert 'y' or 'n'!");
			}				
		}
		return decisionMade;
	}

	private double setAthleteResultDoubleWithMins() {
		
		String inResult;
		Double outResult = null;
		boolean correctResult = false;
		
		while(!correctResult){
			
			inResult = input.nextLine();
		
			try {			
				outResult = supporter.setAthleteResultDoubleWithMins(inResult);
				correctResult = true;
			}
			catch (Exception e) {
			System.out.println("Insert correct result!");
			}			
		}
		return outResult;
	}

	private double setAthleteResultDouble() {
		
		while(true){
			
			try {				
				return Double.parseDouble(input.nextLine());		
			}
			catch (NumberFormatException e) {
				System.out.println("Insert correct result!");
			}		
		}
	}


	private String setAthleteCountry() {
		
		while(true){
			
			String country = input.nextLine();
			
			try {
				return supporter.checkAthleteCountry(country);
			}
			catch (Exception e) {
				System.out.println("Insert correct country code (upper case)!");
			}
			
		}
	}

	private Date setAthleteDate() {
	
		while(true){
			
			String inDate = input.nextLine();
			
			try {
				return supporter.checkAthleteDate(inDate);
			}
			catch (ParseException e) {
				System.out.println("Insert correct date (dd.mm.yyyy)");
			}
		}
	}

	private String setAthleteName() {

		String name = null;
		boolean correctName = false;
		
		while (!correctName){
			name = input.nextLine().trim();
			
			try {
				supporter.checkAthleteName(name);
				correctName = true;
			}
			catch (Exception e) {
				System.out.println("Insert correct name!");
			}
		}
		return name;
	}
	
}
