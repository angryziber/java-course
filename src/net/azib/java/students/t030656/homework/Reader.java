package net.azib.java.students.t030656.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;


/**
 * reader
 *
 * @author sprot
 */
public class Reader {

	/**
	 * constructor
	 */
	public Reader() {
	}
	/**
	 * Reads input from screen
	 * @return
	 */
	static Competition readFromScreen(){
		Competition comp = new Competition();	
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
				
			comp.setName(getCompetitionName(reader));
			
			boolean b = true;
			while (b) {
				Participant par = new Participant();
				par.setName(getParticipantName(reader));
				par.setDateOfBirth(getParticipantDateOfBirth(reader));
				par.setCountry(getParticipantCountry(reader));
				
				while (true) {
					try
					{
						par.setResults(getParticipantResults(reader));
						break;
					}
					catch(NumberFormatException ex){
						System.out.println("Wrong input. Not in correct format. Try again!");
					}
					catch(IllegalArgumentException ex){
						System.out.println("Wrong number of results (less on greater than 10). Try again!");
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
				comp.addParticipant(par);
				b = askContinue(reader);
			}
		}
		catch (UnsupportedEncodingException e) {
			System.out.println("Unable to initialize reader");
		}
		return comp;
	}
	/**
	 * gets name for the competition
	 * @param comp
	 * @param reader
	 * @return 
	 */
	private static String getCompetitionName(BufferedReader reader) {
		while (true) {
			try {
				System.out.print("Enter the competition name: ");
				return reader.readLine();
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}
	}

	/**
	 * Get name for the participant
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantName(BufferedReader reader){
		while (true) {
			try {
				System.out.print("Enter the participant name: ");
				String pName = reader.readLine();
				if(pName.length() != 0){
					return pName;
				}
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			System.out.println("Wrong input. Name can not be empty. Try again!");
		}				
	}

	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantDateOfBirth(BufferedReader reader){
		while (true) {
			try {
				System.out.print("Enter the participants date of birth (dd.mm.yyyy): ");
				DateFormat df = new SimpleDateFormat("dd.mm.yyyy");
		        df.setLenient(false);
		        String strDate = reader.readLine();
		        df.format(df.parse(strDate));
				return strDate;
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			catch (ParseException e) {
				System.out.println("Wrong input. Try again!");
			}
		}		
	}
	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantDateOfBirth(String strDate, String format){
		try {
				DateFormat df = new SimpleDateFormat(format);
		        df.setLenient(false);
		        df.format(df.parse(strDate));
				return strDate;
			}
		catch (ParseException e) {
				System.out.println("Wrong input.");
				return null;
		}	
	}

	/**
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	private static String getParticipantCountry(BufferedReader reader){
		while (true) {
			System.out.print("Enter the participants country (2 upercase letter code): ");
			String pCountry;
			try {
				pCountry = reader.readLine();
				if (pCountry.matches("[A-Z]{2}")) {
					/**
					 * check the aviability of this country code
					 */
					for(String str : Locale.getISOCountries())
					{
						if(str.matches(pCountry)){
							return pCountry;
						}
					}
					
				}else{
					System.out.println("Wrong format or wrong country code.");
				}	
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
			
		}		
	}
	private static String getParticipantCountry(String strCountry){
		if (strCountry.matches("[A-Z]{2}")) {
				/**
				 * check the aviability of this country code
				 */
			for(String str : Locale.getISOCountries())
			{
				if(str.matches(strCountry)){
					return strCountry;
				}
			}
			return null;
		}else{
			System.out.println("Wrong format or wrong country code.");
			return null;
		}		
	}
	
	private static boolean askContinue(BufferedReader reader){
		while(true){
			System.out.print("Insert another participant? \n" +
				"[1] Yes\n" +
				"[2] No\n" +
				": ");
			try {
				switch(Integer.parseInt(reader.readLine())){
				case 1:
					return true;
				case 2:
					return false;
				default:
					System.out.println("Wrong input");
				}
			}
			catch (NumberFormatException e) {
				System.out.println("Wrong input. Try again!");
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}
	}
	
	private static String[] getParticipantResults(BufferedReader reader){
		while (true) {
			System.out.print("Enter the participants results.\n" +
					"Delimiter results with coma (,). " +
					"Coma should represented as dot (.) " + 
					"like: 12.24,123.3\n: ");
			try {
				String str = reader.readLine();
				return str.split(",");
			}
			catch (IOException e) {
				System.out.println("Wrong input. Try again!");
			}
		}		
	}
	
	public static String getPathToFile(){
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
			System.out.println("Insert path for the file (default is \"C:\\\\\")");
			System.out.print(": ");
			String path = reader.readLine();
			return path;
		}
		catch (UnsupportedEncodingException e1) {
			System.out.println("Unable to initialize reader");
			return "c:\\";
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return "c:\\";
	}
	
	/**
	 * gets the name for the input/output file
	 * @return String file name.
	 */
	public static String getNameToFile(){
		while(true)
		{
			try {
				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
				System.out.println("Insert name for the file. Default value is \"decathlon\"");
				System.out.print(": ");
				String name = reader.readLine();
				if(name.length() != 0){
					return name;
				}
			}
			catch (UnsupportedEncodingException e1) {
				System.out.println("Unable to initialize reader");
				return "decathlon";
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			return "decathlon";
		}
	}
	/**
	 * Reads the results from csv file. Path and file name are input from the user
	 * @return Competition 
	 */
	public static Competition ReadFromCSV(){
		Competition comp = new Competition();
		comp.setName("unknown_competition_from_csv");
		BufferedReader reader = null;
		while(true){
			String filename = getPathToFile() + "\\" + getNameToFile();
			try {
				reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF8"));
				while(true){
					
					String line = null;
					if((line = reader.readLine()) == null){
						return comp;
					}
					String[] mLine = line.split(",");
					line.split(",");
					Participant par = new Participant();
					par.setName(mLine[0].substring(1, mLine[0].length()-1));
					par.setDateOfBirth(getParticipantDateOfBirth(mLine[1], "dd.mm.yyyy"));
					par.setCountry(getParticipantCountry(mLine[2]));
					String[] result = new String[10];
					for(int i = 0; i<10; i++){
						result[i] = mLine[i+3];
					}
					par.setResults(result);
					comp.addParticipant(par);
				}
			}
			catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			catch (FileNotFoundException e) {
				System.out.println("File was not found.");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static Competition ReadFromSQL(){
		String url = "jdbc:mysql://srv.azib.net:3306/decathlon";
		Competition comp = new Competition();
//		input reader
		InputStream inStream = System.in;
		Scanner inScan = new Scanner(inStream);
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, "java", "java");
		
			
			String query = "SELECT c.description, c.id FROM competitions AS c";
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			System.out.println("Competitions in database:");
			System.out.println("ID \tDescription");
			while (resultSet.next()) {
				System.out.println( "["+ resultSet.getString("id")+ "]" + "\t" + resultSet.getString("description")); 
			}
			resultSet.close();
			statement.close();
			
			System.out.println("Select competition by typing correct id");
			int id = inScan.nextInt();
			
			query = "SELECT a.name, a.dob, a.country_code, r.race_100m, r.long_jump, r.shot_put, r.high_jump, r.race_400m, r.hurdles_110m, r.discus_throw, r.pole_vault, r.javelin_throw, r.race_1500m"
				+ " FROM results AS r INNER JOIN athletes AS a ON a.id = r.athlete_id "
				+ " WHERE r.competition_id = " + id;
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				 Participant par = new Participant();
				 par.setName(resultSet.getString("name"));
				 par.setDateOfBirth(getParticipantDateOfBirth(resultSet.getString("dob"), "yyyy-mm-dd"));
				 par.setCountry(getParticipantCountry(resultSet.getString("country_code")));
				 String[] arrRes = new String[10];
				 arrRes[0] = resultSet.getString("race_100m");
				 arrRes[1] = resultSet.getString("long_jump");
				 arrRes[2] = resultSet.getString("shot_put");
				 arrRes[3] = resultSet.getString("race_100m");
				 arrRes[4] = resultSet.getString("high_jump");
				 arrRes[5] = resultSet.getString("hurdles_110m");
				 arrRes[6] = resultSet.getString("discus_throw");
				 arrRes[7] = resultSet.getString("pole_vault");
				 arrRes[8] = resultSet.getString("javelin_throw");
				 arrRes[9] = resultSet.getString("race_1500m");
				 par.setResults(arrRes);
				 comp.addParticipant(par);
			}
			resultSet.close();
			statement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return comp;
	}
}
