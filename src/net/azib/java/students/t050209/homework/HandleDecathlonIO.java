package net.azib.java.students.t050209.homework;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.sql.Time;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

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
	
	private static int calculateScore() {
		int overallResult = 0;
		
		for (int i = 0; i < 10; i++){
			overallResult = overallResult + 
						DecathlonPoints.values()[i].eventPoints(userResults[i]);
		}
		
		return overallResult;
	}
	
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
	
	public static double getUserInsertedValue() throws Exception, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double value = Double.parseDouble(in.readLine());
		return value;
	}
	
	public static String getUserInsertedString() throws IOException{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//String str = in.readLine();
		//String UTF8Str = new String(str.getBytes(),"UTF-8");		
		String value = (String)in.readLine();
		return value;		
	}
	
	public void nameInsertion() throws IOException {
		//TODO - is validation needed?
		
		System.out.print("Insert sportsman name: ");
		userData[0] = getUserInsertedString();
	}
	
	public void dateOfBirthInsertion() throws IOException{
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
	
	public void countryCodeInsertion() throws IOException{
		Boolean validData = false;
		String countryCodeTempString;
		
		//TODO check if valid country code getISOCountries
		
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
	
	public void dataInsertion() throws IOException{
		Boolean validData      = false;
		double	convertedRslt  = 0;
		String  dataTempString;
		
		for (int i = 0; i < 10; i++) {
			
			do{
			
				System.out.print("Insert " + questionStrings[i] + " result");
				dataTempString = getUserInsertedString();
				
				validData = fillUserResults(i, dataTempString);						
			} while (validData == false);
			
			/*overallResult = overallResult + 
		    				DecathlonPoints.values()[i].eventPoints(userResults[i]);*/
		}
	}	
		
	public static String insertDataPath() throws IOException{
		Boolean validData      = false;
		String pathTempString;
		
		do{	
			System.out.print("Insert the location of the file: ");
			pathTempString = getUserInsertedString();

			Reader reader = null;
			try {
				reader = new InputStreamReader(new BufferedInputStream(new FileInputStream(pathTempString)), "UTF-8");
				reader.close();	        
		        validData = true;
			}
			catch (IOException e) {
				System.out.println("Cannot find the file specified");
				validData = false;
			}
			catch (NullPointerException e){
				System.out.println("Cannot find the file specified");
				validData = false;
			}
		}while(validData == false);
		
		return pathTempString;
	}
	
	public static void readDataFromFile(String dataPath) {
		boolean validData;
		try {
			BufferedReader bufRdr  = new BufferedReader(new FileReader(dataPath));
			String line = null;
			int i = 0;
			
			while((line = bufRdr.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line,",");
				while (st.hasMoreTokens())
				{
					if (i <= 2)
						userData[i] = st.nextToken();
					else if (i > 2 && i <= 13) {						
						validData = fillUserResults(i - 3, st.nextToken());
						if(validData == false){
							System.out.println("Data invalid");
							return;							
						}
					}
					else
						System.out.println("Data invalid");
					i++;
				}
			} 
//			close the file
			bufRdr.close(); 
	        	        
		}
		catch (IOException e) {
			System.out.println("Data read failed");			
		}
	}
	
	public static void readFromFileSequence() throws IOException{
		readDataFromFile(insertDataPath());
	}
	
	public static void writeDataToFile(String dataPath) {
		//BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(dataPath),"UTF8"));
        //out.write("Василий Пупкин");
        //out.close();
        System.out.println("Written Process Completed.");
	}

	public static void showResultOnScreen() {
		//TODO - convert seconds to x:xx.xx again
		System.out.println(userData[0]);
		System.out.println(userData[1]);
		System.out.println(userData[2]);
		for (int i = 0; i < 10; i++){
			System.out.print(userResults[i] + ",");
		}
		System.out.println("\n" + calculateScore());
	}
}
