package net.azib.java.students.t030682.homework;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * DataInput
 * 
 * @author aplotn
 */
public class DataInputClass { 

	public String[] consoleReader() {
		Scanner s = new Scanner(System.in);
		int arraySize = 1;
		String[] inputRecords = new String[arraySize];
		System.out.println("DECATHLON RESULTS CONSOLE READER");
		String action = "y";
		while (action.charAt(0) == 121) {
			inputRecords[arraySize - 1] = inputRecordFromConsole();
			action = askFromConsole(s, "Do you want to enter more athlete's data? y/n", "[a-z&&[yn]]");
			if (action.charAt(0) == 121) {
				String[] tmpArray = new String[++arraySize];
				System.arraycopy(inputRecords, 0, tmpArray, 0, inputRecords.length);
				inputRecords = tmpArray;
			}
		}
		return inputRecords;
	}

	public String inputRecordFromConsole() {
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

	private String askFromConsole(Scanner s, String message, String pattern) {
		String response = null;
		while (true) {
			try {
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

	/*
	public int countLinesInFile(String filename) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(filename));
		byte[] c = new byte[1024];
		int count = 0;
		int readChars = 0;
		while ((readChars = is.read(c)) != -1) {
			for (int i = 0; i < readChars; ++i) {
				if (c[i] == '\n')
					++count;
			}
		}
		is.close();
		return count;
	}
	*/

	public String[] csvReader(String filename) throws IOException {
		int arraySize = 0;
		int errorLine = 0;
		String lines[] = new String[arraySize];
		try {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
				while ((strLine = br.readLine()) != null) {
				if (Pattern.compile("(\\uFEFF)?\"\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)+\",[0-3]?[0-9].[0-1]?[0-9].[1-2][0,9][0-9][0-9],[A-Z][A-Z],(([0-9]:)?[0-9]+.?[0-9]?[0-9]?,){9}+(([0-9]:)?[0-9]+.?[0-9]?[0-9]?) ?").matcher(strLine).matches()) {
					strLine = strLine.replaceAll("[\"]", "");
					strLine = strLine.replaceAll("\\uFEFF", "");
					strLine = fixRecordFromCSVFile(strLine);
					String[] tmpArray = new String[++arraySize];
					System.arraycopy(lines, 0, tmpArray, 0, lines.length);
					lines=tmpArray;
					lines[arraySize-1] = strLine;
					errorLine++;
					}
				else {
					System.out.println("Wrong data in CSV file on line " + ++errorLine + ": " + strLine);
				}
			}
			in.close();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return lines;
	}

	public String fixRecordFromCSVFile(String rowFromFile) {
		String[] splitRow = rowFromFile.split(",");
		splitRow[7] = checkMinutesAndConvertToSeconds(splitRow[7]);
		splitRow[12] = checkMinutesAndConvertToSeconds(splitRow[12]);
		String fileRecord = splitRow[0];
		for (int i = 0; i < splitRow.length - 1; i++) {
			fileRecord = fileRecord.concat("," + splitRow[i + 1]);
		}
		return fileRecord;
	}	
	
	public String checkMinutesAndConvertToSeconds(String res) {
		if (res.indexOf(':') != -1) {
			String[] splitted = res.split(":");
			res = Double.toString(60 * Double.parseDouble(splitted[0]) + Double.parseDouble(splitted[1]));
		}
		return res;
	}
	
	public String[] mysqlReader (String database) {

		/*
		select athletes.name, athletes.dob, athletes.country_code,race_100m,long_jump,shot_put,high_jump,race_400m,hurdles_110m, discus_throw,pole_vault,javelin_throw,race_1500m
		from decathlon.athletes,decathlon.competitions,decathlon.results
		where competitions.id=results.competition_id and athletes.id=results.athlete_id 
			and competitions.name='training'  / and competitions.id='1'
		*/
		return null;
	}
	
	
}
