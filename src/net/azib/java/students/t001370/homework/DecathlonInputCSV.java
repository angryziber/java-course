package net.azib.java.students.t001370.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonInputCSV
 *
 * @author maksim
 */
public class DecathlonInputCSV extends DecathlonInput {
	private static final Logger LOG = Logger.getLogger(DecathlonInputCSV.class.getName());

	private final PrintStream output;

	
	DecathlonInputCSV(){
		this.output = new PrintStream(System.out);

	}
	
	DecathlonInputCSV(PrintStream out, Scanner in){
		this.output = out;
	}

	
	
	
	/**
	 * Parse string value
	 * @param strValue - string value representation
	 * @return float value of the strValue
	 * @throws NumberFormatException
	 */
	 float parseStringValue(String strValue) throws NumberFormatException{
		float readValue = 0;
		
		String[] valueComponents = strValue.replace(',', '.').split(":");
		
		if (valueComponents.length == 1) {
			readValue = Float.parseFloat(valueComponents[0]);
		}
		else if (valueComponents.length == 2) {
			readValue = (float)(Integer.parseInt(valueComponents[0]) * 60) + 
								Float.parseFloat(valueComponents[1]);
		}
		else{
			throw new NumberFormatException();
		}
	
		return readValue;
	}
	

	/**
	 * Parse string value. In case of format error the user will be
	 * prompted an error, but the processing of data will not be stopped
	 * @param strValue - string value representation
	 * @return float value of strValue
	 */
	 float parseStringValueFromCSV(String strValue){
		float readValue = 0;

		try{
			readValue = parseStringValue(strValue);
		}
		catch (Exception e){
			output.println(Errors.ERROR_0022.getErrorText() + "(" + strValue + ")");
			
			readValue = 0;
		}
	
		return readValue;
	}

	/**
	 * Parse decathlon data line from CSV file
	 * 
	 * @param inputString String - coma-separated string with decathlon data 
	 * @return Athlete - if data was valid, else null 
	 */
	 Athlete parseCSVData(String inputString) {
		
		final int notAthleteDecathlonArgs = 13; //name + birthday + contry_code + 10(competitions) = 13
		Athlete returnAthlete = null;
		String[] dataStrings = inputString.split(",");
		
		if (dataStrings.length == notAthleteDecathlonArgs) {
			returnAthlete = new Athlete();
			
			int i = 0; //indicates data position in string
			
			//set athlete name
			returnAthlete.setName(dataStrings[i++].replace('\"', ' ').trim());
			//set athlete birthday
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			try {
				returnAthlete.setBirthday(sdf.parse(dataStrings[i++]));
			}
			catch (ParseException e) {
				output.println(Errors.ERROR_0016.getErrorText() + dataStrings[0]);
				output.println("Date format should be: '" + sdf.toPattern() + "'.");
				
				LOG.log(Level.INFO, Errors.ERROR_0016.getErrorText() + dataStrings[0]);
				LOG.log(Level.INFO, e.getMessage());
			}
			//set athlete country code
			returnAthlete.setCountryCode(dataStrings[i++]);
			//set athlete competition results
			returnAthlete.competitionResults.setResult100mRace(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultLongJump(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultShotPut(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultHighJump(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResult400mSprint(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResult110mHurdles(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultDiscusThrow(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultPoleVault(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResultJavelinThrow(parseStringValueFromCSV(dataStrings[i++]));
			returnAthlete.competitionResults.setResult1500mRace(parseStringValueFromCSV(dataStrings[i++]));
		}
		
		return returnAthlete;
	}


	/**
	 * Get decathlon competition data from CSV file
	 * @param inputFilePath String - represents file path from where to read
	 * @return Collection of athletes
	 */
	private Collection<Athlete> getAthletesDataFromCSV(String inputFilePath){
		LOG.log(Level.INFO, "get data from CSV entered");

		
		Collection<Athlete> returnAthleteCollection = new TreeSet<Athlete>();
		
		BufferedReader reader = null;
		
		try{
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), "UTF-8"));
			String line = null;
			while((line = reader.readLine()) != null){
				Athlete athlete = parseCSVData(line);
				
				if (athlete != null) {
					returnAthleteCollection.add(athlete);
				}
				else {
					output.println(Errors.ERROR_0017.getErrorText() + line + "'");
				}
			}
		}
		catch (IOException e){
			output.println(Errors.ERROR_0018.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_0018.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
		}
		finally{
			if (reader != null){
				try {
					reader.close();
				}
				catch (IOException e) {
					output.println(Errors.ERROR_0019.getErrorText());
					
					LOG.log(Level.INFO, Errors.ERROR_0019.getErrorText());
					LOG.log(Level.INFO, e.getMessage());
				}
			}
		}
		
		return returnAthleteCollection;
	}

	
	@Override
	public Collection<Athlete> getData(String inArg) {
		return getAthletesDataFromCSV(inArg);
	}

}
