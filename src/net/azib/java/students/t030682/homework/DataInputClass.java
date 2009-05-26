package net.azib.java.students.t030682.homework;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * DataInputClass is a class containing all methods for inputing Decathlon
 * Competition information
 * 
 * @author t030682
 */
public class DataInputClass {
	private static final String CORRECT_STRING = "(\\uFEFF)?\"?.+\"?,[0-3]?[0-9].[0-1]?[0-9].[1-2][0,9][0-9][0-9],[A-Z][A-Z],(([0-9]:)?[0-9]+.?[0-9]?[0-9]?,){9}+(([0-9]:)?[0-9]+.?[0-9]?[0-9]?) ?";

	/**
	 * consoleReader allows Decathlon competition data to be read from console
	 * interactively
	 * 
	 * @return String[] array containg one inputted athlete's data in each array
	 *         row
	 * @author t030682
	 */
	public String[] consoleReader() {
		Scanner s = new Scanner(System.in);
		int arraySize = 1;
		String[] inputRecords = new String[arraySize];
		System.out.println("DECATHLON RESULTS CONSOLE READER");
		// while user says "y" ask for new athletes data
		String action = "y";
		while (action.charAt(0) == 121) {
			inputRecords[arraySize - 1] = inputRecordFromConsole();
			action = askFromConsole(s, "Do you want to enter more athlete's data? y/n", "[a-z&&[yn]]");
			if (action.charAt(0) == 121) {
				// increase array size
				String[] tmpArray = new String[++arraySize];
				System.arraycopy(inputRecords, 0, tmpArray, 0, inputRecords.length);
				inputRecords = tmpArray;
			}
		}
		return inputRecords;
	}

	/**
	 * This method reads one athlete's data from console
	 * 
	 * @return String containing athletes data which have been read from console
	 * @author t030682
	 */
	private String inputRecordFromConsole() {
		Scanner s = new Scanner(System.in);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nEnter athlete's data:\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String scannedData = askFromConsole(s, "first name:", "\\p{Lu}\\p{Ll}+");
		scannedData = scannedData.concat(" " + askFromConsole(s, "surname:", "\\p{Lu}\\p{Ll}+"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "date of birth [DD.MM.YYYY]:", "[0-3]?[0-9].[0-1]?[0-9].[1-2][0,9][0-9][0-9]"));
		scannedData = scannedData.concat("," + askFromConsole(s, "country [XX]:", "[A-Z][A-Z]"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "100m sprint time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "Long jump result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "Shot put result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "High jump result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "400m sprint time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "110m hurdles time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "Discus throw result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "Pole vault result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "Javelin throw result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat(","
				+ askFromConsole(s, "1500m race time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return scannedData;
	}

	/**
	 * This method ask some string from console and compares it to predefined
	 * string
	 * 
	 * @param s
	 *            Scanner which is used to read data from console
	 * @param message
	 *            Information to be printed to console
	 * @param pattern
	 *            Regular Expresion which is being compared to inputted string
	 * 
	 * @return String which was read from console
	 * @author t030682
	 */
	private String askFromConsole(Scanner s, String message, String pattern) {
		String response = null;
		while (true) {
			try {
				// display message, read from console and compare to regex
				// pattern
				System.out.print(message);
				response = s.next(pattern);
				break;
			}
			catch (InputMismatchException e) {
				System.out.println("Wrong input data!");
				s.next();
			}
		}
		return response;
	}

	/**
	 * csvReader reads Decathlon Competition from .csv file
	 * 
	 * @param filename
	 *            File location
	 * @return String[] array containg one inputted athlete's data in each array
	 *         row
	 * @author t030682
	 */
	public String[] csvReader(String filename) throws IOException {
		int arraySize = 0;
		int errorLine = 0;
		String lines[] = new String[arraySize];
		FileInputStream fstream = new FileInputStream(filename);
		DataInputStream in = new DataInputStream(fstream);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		try {
			String strLine;
			while ((strLine = br.readLine()) != null) {
				// while file contains new lines read line, compare to regex, if
				// ok add to array and remove unneeded symbols
				if (Pattern.compile(CORRECT_STRING).matcher(strLine).matches()) {
					strLine = strLine.replaceAll("[\"]", "");
					strLine = strLine.replaceAll("\\uFEFF", "");
					String[] splitRow = strLine.split(",");
					splitRow[7] = checkMinutesAndConvertToSeconds(splitRow[7]);
					splitRow[12] = checkMinutesAndConvertToSeconds(splitRow[12]);
					strLine = splitRow[0];
					for (int i = 0; i < splitRow.length - 1; i++) {
						strLine = strLine.concat("," + splitRow[i + 1]);
					}
					// increase array
					String[] tmpArray = new String[++arraySize];
					System.arraycopy(lines, 0, tmpArray, 0, lines.length);
					lines = tmpArray;
					lines[arraySize - 1] = strLine;
					errorLine++;
				}
				else {
					// if some row contains wrong data, dont read this row and
					// print error
					System.out.println("Wrong data in CSV file on line " + ++errorLine + ": " + strLine);
				}
			}

		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
			finally {
				in.close();
				br.close();
				fstream.close();
			}
		return lines;
	}

	/**
	 * This method fixes time from .csv file by converting format from MM:SS.ss
	 * to SS.ss
	 * 
	 * @param rowFromFile
	 *            String time result needed to be converted
	 * @return String converted time
	 * @author t030682
	 */
	private String checkMinutesAndConvertToSeconds(String res) {
		if (res.indexOf(':') != -1) {
			String[] splitted = res.split(":");
			res = Double.toString(60 * Double.parseDouble(splitted[0]) + Double.parseDouble(splitted[1]));
		}
		return res;
	}

	public String convertSQLString(String toConvert) {
		char[] newString = new char[10];
		newString[0] = toConvert.charAt(8);
		newString[1] = toConvert.charAt(9);
		newString[2] = '.';
		newString[3] = toConvert.charAt(5);
		newString[4] = toConvert.charAt(6);
		newString[5] = '.';
		newString[6] = toConvert.charAt(0);
		newString[7] = toConvert.charAt(1);
		newString[8] = toConvert.charAt(2);
		newString[9] = toConvert.charAt(3);
		return new String(newString);
	}

	/**
	 * mysqlReader reads Decathlon competition data from database <b>Needs to be
	 * implemented yet</b>
	 * 
	 * @param database
	 *            Database to get data from
	 * @return
	 * @author t030682
	 * @throws SQLException
	 */
	public String[] mysqlReader(String database) throws SQLException {
		int arraySize = 0;
		int errorRow=0;
		String[] athletes = new String[arraySize];
		Connection conn;
		boolean emptyResult = false;
		conn = DriverManager
				.getConnection("jdbc:mysql://java.azib.net:3306/decathlon?zeroDateTimeBehavior=round", "java", "java");
		try {
			PreparedStatement s = conn
					.prepareStatement("select athletes.name, athletes.dob, athletes.country_code,race_100m,long_jump,shot_put,high_jump,race_400m,hurdles_110m, discus_throw,pole_vault,javelin_throw,race_1500m from decathlon.athletes,decathlon.competitions,decathlon.results	where competitions.id=results.competition_id and athletes.id=results.athlete_id and (competitions.name=? or competitions.id=?)");
			s.setString(1, database);
			s.setString(2, database);
			ResultSet result = s.executeQuery();
			int i = 0;

			if (result.next()) {
			do {
				String resultRow = result.getString(1) + "," + convertSQLString(result.getDate(2).toString()) + ","
						+ result.getString(3) + "," + result.getString(4) + "," + result.getString(5) + "," + result.getString(6)
						+ "," + result.getString(7) + "," + result.getString(8) + "," + result.getString(9) + ","
						+ result.getString(10) + "," + result.getString(11) + "," + result.getString(12) + ","
						+ result.getString(13);
				if (Pattern.compile(CORRECT_STRING).matcher(resultRow).matches()) {
					String[] tmpArray = new String[++arraySize];
					System.arraycopy(athletes, 0, tmpArray, 0, athletes.length);
					athletes = tmpArray;
					athletes[arraySize - 1] = resultRow;
					errorRow++;	
				} else {
					System.out.println("Wrong data in database for athlete " + result.getString(1));
					System.out.println(resultRow);
					++errorRow;
				}
				i++;
			} while (result.next());
		} else {
			emptyResult=true;
			System.out.println("No data in database \"" + database + "\"");
		}
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			conn.close();
		}
		if (emptyResult==true) System.exit(-1);
		return athletes;
	}
}
