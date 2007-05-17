package net.azib.java.students.t050209.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * HandleConsoleIO
 *
 * @author Kaupo Laan
 */
public class HandleConsoleIO {
	
	public static String sportsmanName;
	public static String countryCode;
	public static String dateOfBirth;
	
	private static double run100mResult,
						  longJumpResult,
						  shotPutResult,
						  highJumpResult,
						  run400mResult,
						  run110mHurdles,
						  discusThrowResult,
						  poleVaultResult,
						  javelinThrowResult,
						  run1500mResult;
	public static String userData[] = {sportsmanName,
		   							   dateOfBirth,
		   							   countryCode};

	public static double userResults[] = {run100mResult, 
									      longJumpResult,
									      shotPutResult,
									      highJumpResult,
									      run400mResult,
									      run110mHurdles,
									      discusThrowResult,
									      poleVaultResult,
									      javelinThrowResult,
									      run1500mResult};
	public static String questionStrings[] = {"100 meters",
	  									      "long jump",
	  									      "shot put",
	  									      "high jump",
	  									      "400 meters",
	  									      "110 hurdles",
	  									      "discus throw",
	  									      "pole vault",
	  									      "javelin throw",
	  									  	  "1500 meters"};
	
	/**
	 * Gets user inserted string 
	 */
	private static String getUserInsertedString() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				
		String value = (String)in.readLine();
		return value;		
	}
	
	/**
	 * Handles sportsman name insertion 
	 */
	private static void nameInsertion() throws IOException {
		
		System.out.print("Insert sportsman name: ");
		userData[0] = getUserInsertedString();
	}
	
	/**
	 * Handles sportsman date of birth insertion 
	 */
	private static void dateOfBirthInsertion() throws IOException{
		//TODO - check if date is realistic
		
		Boolean validData = false;
		String dateOfBirthTempString;
		do {
			System.out.print("Insert date of birth (format DD.MM.YYYY): ");
			dateOfBirthTempString = getUserInsertedString();
			
			try{
				DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
				userData[1] = formatter.format(formatter.parse(dateOfBirthTempString));
		        validData = true;
			}
			catch(ParseException e) {
				System.out.println("Inserted date of birth in wrong format. Must be dd.mm.yyyy");
				validData = false;
		    }			
	    } while (validData == false);
	}
	
	/**
	 * Handles sportsman country code insertion 
	 */
	private static void countryCodeInsertion() throws IOException{
		Boolean validData = false;
		String countryCodeTempString;
		
		do{
			System.out.print("Insert country code (format XX): ");
			countryCodeTempString = getUserInsertedString();
					
			if(countryCodeTempString.matches("[A-Z]{2}")) {
				
				try{
					for (String code : Locale.getISOCountries()) {
						if (code.equals(countryCodeTempString))
							validData = true;
					}
				}
				catch (Error e){
					System.out.println("Error in countryCodeInsertion");
					validData = false;
				}
			}
			else{
				System.out.println("Inserted country code in wrong format. Must be XX");
				validData = false;
		    }						
	    } while (validData == false);
        
		userData[2] = countryCodeTempString;
	}
	
	/**
	 * Handles sportsman results insertion 
	 */
	private static List<Double> dataInsertion() throws IOException{
		Boolean validData      = false;
		String  dataTempString;
		List<Double> results = new LinkedList<Double>();
		
		for (int i = 0; i < 10; i++) {
			
			do{
			
				System.out.print("Insert " + questionStrings[i] + " result");
				dataTempString = getUserInsertedString();
				
				validData = fillUserResults(i, dataTempString);						
			} while (validData == false);
			results.add(userResults[i]);
		}
		return results;
	}
	
	/**
	 * Fills the temporary array with user results and verifies these
	 */
	private static boolean fillUserResults( int i, String dataTempString) {
		boolean validData;
		
		if (DecathlonPoints.values()[i].checkIfRunningEvent()){
					
			try{
				DateFormat formatter = new SimpleDateFormat("mm:ss.SS");				
				DateFormat finalFormatMinutes = new SimpleDateFormat("mm");
				DateFormat finalFormatSeconds = new SimpleDateFormat("ss.SS");
				
				userResults[i] = Double.parseDouble(finalFormatMinutes.format(formatter.parse(dataTempString))) * 60 +
								 Double.parseDouble(finalFormatSeconds.format(formatter.parse(dataTempString)));
				validData = true;
			}
			catch (ParseException e){
				try{
					DateFormat formatter = new SimpleDateFormat("ss.SS");				
					
					userResults[i] = Double.parseDouble(formatter.format(formatter.parse(dataTempString)));
					validData = true;
				}
				catch(ParseException pe) {
					System.out.println("Data in invalid format");
					validData = false;
				}
			}
		}
		else{
			try{
				userResults[i] = Double.parseDouble(dataTempString);
				validData = true;
			}
			catch (Exception e){
				System.out.println("Data in invalid format");
				validData = false;
			}
		}		
		return validData;
	}
	
	/**
	 * Handles console input insertion 
	 */
	public static List<Sportsman> handleConsoleInput() {
		Scanner scanner = new Scanner(System.in);
		
		List<Sportsman> sportsmanList = new LinkedList<Sportsman>();

		int userInteraction = 0;
		do {
			// Print user choises when entering data
			System.out.println("What do you want to do?");
			System.out.println("- 1 Continue with entering results");
			System.out.println("- 2 End data insertion");
			// Read userInteraction
			userInteraction = scanner.nextInt();

			if (userInteraction == 1) {
				Sportsman sportsman = new Sportsman();

				// Sportsman name insertion
				try{
					nameInsertion();
				}
				catch(IOException e)
				{
					System.out.println("IOException error in name insertion");
				}
				
				sportsman.setSportsmanName(userData[0]);
				
				// Sportsman date of birth insertion
				try{
					dateOfBirthInsertion();
				}
				catch(IOException e)
				{
					System.out.println("IOException error in date of birth insertion");
				}
				sportsman.setSportsmanDateOfBirth(userData[1]);
				
				// Sportsman country code insertion
				try{
				    countryCodeInsertion();
				}
				catch(IOException e)
				{
					System.out.println("IOException error in country code insertion");
				}
				sportsman.setSportsmanCountry(userData[2]);

				// Sportsman results insertion
				try{
					sportsman.setSportsmanResults(dataInsertion());
				}
				catch(IOException e)
				{
					System.out.println("IOException error in sportsman results insertion");
				}
				
				// Sportsman score calculation and storing
				sportsman.calculateAndStoreSportsmanScore();

				// Add sportsman to sportsmen list
				sportsmanList.add(sportsman);
				
			}
			// End data insertion
			else if (userInteraction == 2) {
				return sportsmanList;
			}
		} while (userInteraction != 1 || userInteraction != 2);
		
		return sportsmanList;
	}
	
	/**
	 * Handles console output insertion 
	 */
	public static void handleConsoleOutput(List<Sportsman> sportsmanList) {
		int position = 0;
		int step = 1;
		int lastScore = 0;
		
		for (Sportsman sm : sportsmanList) {
			
			// find sportsman place
			// if same score, same place
			if (sm.overallResult.equals(lastScore))
				step++;
			else {
				position += step;
				step = 1;
			}

			System.out.print(position + " ");			// write sportsman position
			System.out.print(sm.name + " ");			// write sportsman name
			System.out.print(sm.dateOfBirth + " ");		// write sportman date of birth
			System.out.print(sm.country + " ");			// write sportsman country
			
			for (Double res : sm.results)				// write sportsman results
				System.out.print(res + " ");
			
			System.out.println(sm.overallResult);		// write sportsman overall result
			
			lastScore = sm.overallResult;				// remember last score, 
														// so it is possible to serialize results
		}
	}
}
