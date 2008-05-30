package net.azib.java.students.t001370.homework;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonInputConsole
 * Class for getting data from console (manual user input)
 * @author maksim
 */
public class DecathlonInputConsole extends DecathlonInput {
	private static final Logger LOG = Logger.getLogger(DecathlonInputConsole.class.getName());

	private final PrintStream output;
	private final Scanner input;

	/**
	 * DecathlonInputConsole constructor
	 */
	DecathlonInputConsole(){
		this.output = new PrintStream(System.out);
		this.input 	= new Scanner(System.in);

	}
	
	/**
	 * DecathlonInputConsole constructor. Mostly for testing purpose
	 * @param out - print stream - user interaction output channel
	 * @param in - scanner - user interaction input channel
	 */
	DecathlonInputConsole(PrintStream out, Scanner in){
		this.output = out;
		this.input 	= in;
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
	 * Parse string value from console. In case of format error user will be prompted 
	 * to input the value once again.
	 * @param strValue - string value representation
	 * @return float value of strValue or input from console
	 */
	 float parseStringValueFromConsole(String strValue){
		float readValue = 0;
		boolean success = false;
		
		do{
			try{
				readValue = parseStringValue(strValue);
				success = true;
			}
			catch (Exception e){
				success = false;
				output.println(Errors.ERROR_NUMBER_FORMAT_IS_WRONG.getErrorText());
				
				strValue = input.next();
			}
		}while(success != true);
	
		return readValue;
	}

	/**
	 * Get competition results from user input
	 * @return Collection of athletes
	 */
	 Collection<Athlete> getAthletesDataFromConsole(){
		LOG.log(Level.INFO, "get data from console entered");

		
		Collection<Athlete> returnAthletCollection = new TreeSet<Athlete>();
		
		output.println("You are about to enter competition results.");
		do{
			output.println("Enter competitor data. To continue press 'c' or 'x' for exit!");
			if (input.hasNext("x")){
				output.println("Exit from console!");
				break;
			}
			else if (input.hasNext("c")){
				Athlete athleteData = new Athlete();
				boolean success = false;
				
				//buffer readout 
				input.nextLine();
				
				// set athlete name 
				output.println("Enter athlete name (example: Gaas Põhja):");
				athleteData.setName(input.nextLine());
				//-----------------------------------------
				
				// set athlete birthday 
				DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
				output.println("Enter athlete birhtday (example: " + ((SimpleDateFormat) df).toPattern() + "):");
				do{
					try {
						athleteData.setBirthday(df.parse(input.next()));
						success = true;
					}
					catch (ParseException e) {
						output.println(Errors.ERROR_FORMAT_IS_WRONG.getErrorText());
						
						LOG.log(Level.INFO, Errors.ERROR_FORMAT_IS_WRONG.getErrorText());
						LOG.log(Level.INFO, e.getMessage());
						success = false;
					}
				}while(success != true);
				//-----------------------------------------
				
				// set athlete country code 
				output.println("Enter athlete contry code (example: EE):");
				success = false;
				do{
					String cStr = input.next()/*.toUpperCase()*/;
					if (cStr.matches("[A-Z]{2}")){
						athleteData.setCountryCode(cStr);
						success = true;
					}
					else{
						output.println(Errors.ERROR_COUNTRY_CONE_DOES_NOT_MATCH.getErrorText());
					}
				}while(success != true);
				//-----------------------------------------
				
				//set competition result for 100 m sprint 
				output.println("Enter athlete 100m sprint result (in sec. Example: 12.61): ");
				athleteData.competitionResults.setResult100mRace(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for long jump 
				output.println("Enter athlete long jump result (in m. Examle: 4.53):");
				athleteData.competitionResults.setResultLongJump(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for shot put
				output.println("Enter athlete shot put result (in m. Example: 10.12):");
				athleteData.competitionResults.setResultShotPut(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for high jump
				output.println("Enter athlete high jump result (in m. Example: 1.55):");
				athleteData.competitionResults.setResultHighJump(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for 400m sprint
				output.println("Enter athlete 400m sprint result (in min:sec or sec. Example: 1:08.44):");
				athleteData.competitionResults.setResult400mSprint(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for 110m hurdles
				output.println("Enter athlete 110m hurdler result (in sec. Example: 19.18):");
				athleteData.competitionResults.setResult110mHurdles(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for discus throw
				output.println("Enter athlete discus throw result (in m. Example: 24.20):");
				athleteData.competitionResults.setResultDiscusThrow(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for pole vault
				output.println("Enter athlete pole vault result (in m. Example: 2.80):");
				athleteData.competitionResults.setResultPoleVault(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for
				output.println("Enter athlete javelin throw result (in m. Example: 35.81):");
				athleteData.competitionResults.setResultJavelinThrow(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//set competition result for
				output.println("Enter athlete 1500m race result (in min:sec or sec. Example: 6:22.75):");
				athleteData.competitionResults.setResult1500mRace(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				//buffer readout 
				input.nextLine();
				//add new athlete to collection
				output.println("Entered athlete total score is : " + athleteData.competitionResults.getTotalScore() + " points");
				returnAthletCollection.add(athleteData);
			}
		}
		while (true);
		
		return returnAthletCollection;
	}

	
	@Override
	public Collection<Athlete> getData(String inArg) {
		return getAthletesDataFromConsole();
	}

}
