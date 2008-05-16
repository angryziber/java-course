package net.azib.java.students.t001370.homework;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Properties;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DecathlonDataReader
 * Gets decathlon competition data from appropriate input
 *
 * @author maksim
 */
public class DecathlonDataReader {
	private static final Logger LOG = Logger.getLogger(DecathlonDataReader.class.getName());
	
	private IOMethod inputSource;
	private final PrintStream output;
	private final Scanner input;

	
	/**
	 * DecathlonDataReader constructor
	 * @param inMethod - IO method from where the data will be read
	 */
	DecathlonDataReader(IOMethod inMethod){
		LOG.log(Level.INFO, "DecathlonDataReader created");
		
		this.inputSource = inMethod;
		this.output = System.out;
		this.input 	= new Scanner(System.in);
	}

	/**
	 * DecathlonDataReader constructor
	 * @param inMethod - IO method
	 * @param out - ui output stream
	 * @param in - ui input stream
	 */
	DecathlonDataReader(IOMethod inMethod, PrintStream out, Scanner in){
		LOG.log(Level.INFO, "DecathlonDataReader (extended) created");

		this.inputSource = inMethod;
		this.output = out;
		this.input 	= in;
	}

	/**
	 * SQL statement for PreparedStatement
	 * @return SQL statement string
	 */
	private String getSQLStatement(){
		return "SELECT a.name 		AS name, 													" +
				"       a.dob 			AS birthday, 											" +
				"       a.country_code 	AS country_code,										" +
				"       r.race_100m 	AS race_100m,											" +
				"       r.long_jump 	AS long_jump,											" +
				"       r.shot_put 		AS shot_put,											" +
				"       r.high_jump 	AS high_jump,											" +
				"       r.race_400m 	AS race_400m,											" +
				"       r.hurdles_110m 	AS hurdles_110m,										" +
				"       r.discus_throw 	AS discus_throw,										" +
				"       r.pole_vault 	AS pole_vault,											" +
				"       r.javelin_throw AS javelin_throw,										" +
				"       r.race_1500m 	AS race_1500m											" +
				"FROM (athletes AS a INNER JOIN results AS r ON a.id = r.athlete_id) 			" +
				"                    INNER JOIN competitions AS c ON r.competition_id = c.id 	" + 
				"WHERE c.id = ? OR c.name = ?"; 

	}
	
	/**
	 * Get decathlon competition data from database
	 * @param readParam String - specifies the competition (can be a number or competition name) 
	 * @return Collection of athletes
	 */
	private Collection<Athlete> getAthletesDataFromDB(String readParam) {
		LOG.log(Level.INFO, "get data from DB entered");

		
		Collection<Athlete> returnAthletCollection = new TreeSet<Athlete>();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Connection conn = null;

		try{
			Properties pr = new Properties();
			
			LOG.log(Level.INFO, DecathlonDataReader.class.getResource("db.properties").getPath());
			pr.load(DecathlonDataReader.class.getResourceAsStream("db.properties"));
			
			conn = DriverManager.getConnection(
					"jdbc:" + 
						pr.getProperty("db.subprotocol", "mysql") + ":" + 
						pr.getProperty("db.subname", "//srv.azib.net:3306/decathlon"),
					pr.getProperty("db.username", "java"),
					pr.getProperty("db.password", "java"));
			
			pstmt = conn.prepareStatement(getSQLStatement());
			pstmt.setString(1, readParam);
			pstmt.setString(2, readParam);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {	
				Athlete athleteData = new Athlete();
				
				// set athlete data
				athleteData.setName(rs.getString("name"));
				athleteData.setBirthday(rs.getDate("birthday"));
				athleteData.setCountryCode(rs.getString("country_code"));
				athleteData.competitionResults.setResult100mRace(rs.getFloat("race_100m"));
				athleteData.competitionResults.setResultLongJump(rs.getFloat("long_jump"));
				athleteData.competitionResults.setResultShotPut(rs.getFloat("shot_put"));
				athleteData.competitionResults.setResultHighJump(rs.getFloat("high_jump"));
				athleteData.competitionResults.setResult400mSprint(rs.getFloat("race_400m"));
				athleteData.competitionResults.setResult110mHurdles(rs.getFloat("hurdles_110m"));
				athleteData.competitionResults.setResultDiscusThrow(rs.getFloat("discus_throw"));
				athleteData.competitionResults.setResultPoleVault(rs.getFloat("pole_vault"));
				athleteData.competitionResults.setResultJavelinThrow(rs.getFloat("javelin_throw"));
				athleteData.competitionResults.setResult1500mRace(rs.getFloat("race_1500m"));
				
				//add new athlete to collection
				returnAthletCollection.add(athleteData);
			}
		}
		catch (SQLException e){
			
			output.println(Errors.ERROR_0012.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_0012.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			
			System.exit(1);
		}
		catch (FileNotFoundException e) {
			output.println(Errors.ERROR_0024.getErrorText());
			output.println(Errors.ERROR_0012.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		catch (IOException e) {
			output.println(Errors.ERROR_0025.getErrorText());
			output.println(Errors.ERROR_0012.getErrorText());

			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		finally{
			
			try{
				pstmt.close();
				rs.close();
				conn.close();
			}
			catch(SQLException e){
				output.println(Errors.ERROR_0013.getErrorText());

				LOG.log(Level.INFO, Errors.ERROR_0013.getErrorText());
				LOG.log(Level.INFO, e.getMessage());
			}
		}
		return returnAthletCollection;
	}
	
	/**
	 * Parse string value
	 * @param strValue - string value representation
	 * @return float value of the strValue
	 * @throws NumberFormatException
	 */
	private float parseStringValue(String strValue) throws NumberFormatException{
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
	private float parseStringValueFromConsole(String strValue){
		float readValue = 0;
		boolean success = false;
		
		do{
			try{
				readValue = parseStringValue(strValue);
				success = true;
			}
			catch (Exception e){
				success = false;
				output.println(Errors.ERROR_0014.getErrorText());
				
				strValue = input.next();
			}
		}while(success != true);
	
		return readValue;
	}

	/**
	 * Parse string value. In case of format error the user will be
	 * prompted an error, but the processing of data will not be stopped
	 * @param strValue - string value representation
	 * @return float value of strValue
	 */
	private float parseStringValueFromCSV(String strValue){
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
	 * Get competition results from user input
	 * @return Collection of athletes
	 */
	private Collection<Athlete> getAthletesDataFromConsole(){
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
				
				//buffer dummy readout 
				output.println("Your choice was to continue: " + input.nextLine());
				
				// set athlete name 
				output.println("Enter athlete name (example: Gaas Põhja):");
				athleteData.setName(input.nextLine());
				//-----------------------------------------
				
				// set athlete birthday 
				DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
				output.println("Enter athlete birhtday (example: " + ((SimpleDateFormat) df).toPattern() + "):");
				do{
					try {
						athleteData.setBirthday(df.parse(input.next()));
						success = true;
					}
					catch (ParseException e) {
						output.println(Errors.ERROR_0015.getErrorText());
						
						LOG.log(Level.INFO, Errors.ERROR_0015.getErrorText());
						LOG.log(Level.INFO, e.getMessage());
						success = false;
					}
				}while(success != true);
				//-----------------------------------------
				
				// set athlete country code 
				output.println("Enter athlete contry code (example: EE):");
				success = false;
				do{
					String cStr = input.next().toUpperCase();
					if (cStr.matches("[A-Z]{2}")){
						athleteData.setCountryCode(cStr);
						success = true;
					}
					else{
						output.println(Errors.ERROR_0023.getErrorText());
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
				output.println("Enter athlete 400m sprint result (in min:sec. Example: 1:08.44):");
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
				output.println("Enter athlete 1500m race result (in min:sec. Example: 6:22.75):");
				athleteData.competitionResults.setResult1500mRace(parseStringValueFromConsole(input.next()));
				//-----------------------------------------
				
				
				//add new athlete to collection
				output.println("Entered athlete total score is : " + athleteData.competitionResults.getTotalScore() + " points");
				returnAthletCollection.add(athleteData);
			}
		}
		while (true);
		
		return returnAthletCollection;
	}
	
	/**
	 * Parse decathlon data line from CSV file
	 * 
	 * @param inputString String - coma-separated string with decathlon data 
	 * @return Athlete - if data was valid, else null 
	 */
	private Athlete parseCSVData(String inputString) {
		
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
	
	
	/**
	 * Get athletes data from input specified by calling class constructor
	 * @return Collection of athletes
	 */
	public Collection<Athlete> getData(){
		LOG.log(Level.INFO, "getData entered");

		
		Collection<Athlete> athleteFactory = null;
		
	
		try {
			switch (inputSource) {
				
				case CONSOLE_INPUT:
					athleteFactory = getAthletesDataFromConsole();
				break;
				
				case CSV_INPUT:
					athleteFactory = getAthletesDataFromCSV(inputSource.getIOArgument());
				break;
				
				case DB_INPUT:
					athleteFactory = getAthletesDataFromDB(inputSource.getIOArgument());
				break;

				default:
					output.println(Errors.ERROR_0020.getErrorText() + inputSource.name());
				
					LOG.log(Level.INFO, Errors.ERROR_0020.getErrorText() + inputSource.name());
					System.exit(1);
				break;
			}
		}
		catch (Exception e) {
			output.println(Errors.ERROR_0021.getErrorText());
			
			LOG.log(Level.INFO, Errors.ERROR_0021.getErrorText());
			LOG.log(Level.INFO, e.getMessage());
			System.exit(1);
		}
		
		return athleteFactory;
	}
}
