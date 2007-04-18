package net.azib.java.students.t050209.homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * HandleDecathlonIO
 *
 * @author Kaupo Laan
 */
public class HandleDecathlonIO {

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
	
	public static double getUserInsertedValue() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double value = Double.parseDouble(in.readLine());
		return value;
	}
	
	public static String getUserInsertedString() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String value = (String) in.readLine();
		return value;		
	}
	
	private static void nameInsertion() throws IOException {
		//TODO - is validation needed?
		
		System.out.print("Insert sportsman name: ");
		userData[0] = getUserInsertedString();		
	}
	
	private static void dateOfBirthInsertion() throws IOException{
		Boolean validData = false;
		String dateOfBirthTempString;
		do {
			System.out.print("Insert date of birth (format DD.MM.YEAR): ");
			dateOfBirthTempString = getUserInsertedString();
			
			try{
				DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");				
		        Date date = (Date)formatter.parse(dateOfBirthTempString);
		        
		        validData = true;
			}
			catch(ParseException e) {
				System.out.println("Inserted date of birth in wrong format. Must be xx.xx.xxxx");
				validData = false;
		    }
			
	    } while (validData == false);
		
		userData[1] = dateOfBirthTempString;
	}
	
	private static void countryCodeInsertion() throws IOException{
		Boolean validData = false;
		String countryCodeTempString;
		
		do{
			System.out.print("Insert country code (format XX): ");
			countryCodeTempString = getUserInsertedString();
					
			if(countryCodeTempString.matches("[A-Z]{2}")) {
				
		        validData = true;
			}
			else{
				System.out.println("Inserted country code in wrong format. Must be XX");
				validData = false;
		    }
						
	    } while (validData == false);
        userData[2] = countryCodeTempString;
	}
	
	public static int manualInsertionSequence() throws Exception, IOException {
//		TODO data validation, possibility to cancel operations
		int overallResult = 0;
				
		nameInsertion();
		dateOfBirthInsertion();		
		countryCodeInsertion();
		
		for (int i = 0; i < 10; i++)
		{
			System.out.print("Insert " + questionStrings[i] +" result (format x.xx): ");
			userResults[i] = getUserInsertedValue();
			overallResult = overallResult + 
					        DecathlonPoints.values()[i].eventPoints(userResults[i]);
		}
		
		return overallResult;
	}
	
	public static void readFromFileSequence() {
		String s;
		
	}

}
