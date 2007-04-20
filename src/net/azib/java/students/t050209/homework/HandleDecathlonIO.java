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
	
	public void nameInsertion() throws IOException {
		//TODO - is validation needed?
		
		System.out.print("Insert sportsman name: ");
		userData[0] = getUserInsertedString();		
	}
	
	public void dateOfBirthInsertion() throws IOException{
		Boolean validData = false;
		String dateOfBirthTempString;
		do {
			System.out.print("Insert date of birth (format DD.MM.YYYY): ");
			dateOfBirthTempString = getUserInsertedString();
			
			try{
				DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");				
		        Date date = (Date)formatter.parse(dateOfBirthTempString);
		        
		        validData = true;
			}
			catch(ParseException e) {
				System.out.println("Inserted date of birth in wrong format. Must be dd.mm.yyyy");
				validData = false;
		    }			
	    } while (validData == false);
		
		userData[1] = dateOfBirthTempString;
	}
	
	public void countryCodeInsertion() throws IOException{
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
	
	public int dataInsertion() throws IOException{
		Boolean validData      = false;
		int     overallResult  = 0;
		double	convertedRslt  = 0;
		String  dataTempString;
		
		for (int i = 0; i < 10; i++) {
			
			//TODO try catch sequence - if field event, then... else ...
			do{
			
				System.out.print("Insert " + questionStrings[i] + " result");
				dataTempString = getUserInsertedString();		
			
				if(dataTempString.matches("[0-9]:[0-9]{2}\\x2E[0-9]")){
					convertedRslt = (dataTempString.charAt(0) - '0') * 60 + 
									(dataTempString.charAt(2) - '0') * 10 +
									(dataTempString.charAt(3) - '0') +
									(dataTempString.charAt(5) - '0') / 10;
					validData = true;
				}
				else if(dataTempString.matches("[0-9]:[0-9]{2}\\x2E[0-9]{2}")){
					convertedRslt = (dataTempString.charAt(0) - '0') * 60 + 
									(dataTempString.charAt(2) - '0') * 10 +
									(dataTempString.charAt(3) - '0') +
									(dataTempString.charAt(5) - '0') / 10 +
									(dataTempString.charAt(6) - '0') / 100;
					validData = true;
				}
				else if (dataTempString.matches("[0-9]{2}\\x2E[0-9]{2}") || 
						 dataTempString.matches("[0-9]{2}\\x2E[0-9]")    ||
						 dataTempString.matches("[0-9]\\x2E[0-9]{2}")    ||
						 dataTempString.matches("[0-9]\\x2E[0-9]")		 ||
						 dataTempString.matches("[0-9]{2}")          ||
						 dataTempString.matches("[0-9]")){
					convertedRslt = Double.parseDouble(dataTempString);
					validData = true;
				}
				else{
					System.out.println("Inserted result in wrong format. Must be XX.XX or X:XX.XX");
					validData = false;
				}
						
			} while (validData == false);
			
			overallResult = overallResult + 
		    				DecathlonPoints.values()[i].eventPoints(userResults[i]);
			userResults[i] = convertedRslt;//getUserInsertedValue();
		}
				
		return overallResult;
	}	
	
	public static void readFromFileSequence() {
		String s;
		
	}

}
