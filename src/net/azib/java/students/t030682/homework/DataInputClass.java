package net.azib.java.students.t030682.homework;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * DataInput
 * 
 * @author aplotn
 */
public class DataInputClass {

	public String[] consoleReader(){
		Scanner s = new Scanner(System.in);
		int arraySize =1;
		String [] inputRecords = new String[arraySize];
		System.out.println("DECATHLON RESULTS CONSOLE READER");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String action = "y";
	
		//problem here
		while (action=="y") {
			inputRecords[arraySize-1]=inputRecordFromConsole();
			action = ask(s,"Do you want to enter more athlete's data? y/n","[a-z&&[yn]]");
			System.out.println(action);
			if (action=="y") {
			String[] tmpArray = new String[++arraySize];
			System.arraycopy(inputRecords, 0, tmpArray, 0, inputRecords.length);
			inputRecords=tmpArray;
		} 
		}
		return inputRecords;
		
	}
	
	public String inputRecordFromConsole() {
		Scanner s = new Scanner(System.in);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\nEnter athlete's data:\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String scannedData = ask(s, "first name:", "[A-Z][a-z]+");
		scannedData = scannedData.concat(" " + ask(s, "surname:", "[A-Z][a-z]+"));
		scannedData = scannedData.concat(","
				+ ask(s, "date of birth [DD.MM.YYYY]:", "[0-3]?[0-9].[0-1]?[0-9].[1-2][0-9][0-9][0-9]"));
		scannedData = scannedData.concat("," + ask(s, "country [XX]:", "[A-Z][A-Z]"));
		scannedData = scannedData.concat("," + ask(s, "100m sprint time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "Long jump result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "Shot put result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "High jump result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "400m sprint time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "110m hurdles time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "Discus throw result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "Pole vault result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "Javelin throw result [metres[.centimeters]]:", "[0-9]+.?[0-9]?[0-9]?"));
		scannedData = scannedData.concat("," + ask(s, "1500m race time [seconds[.milliseconds]]:", "[0-9]+.?[0-9]?[0-9]?"));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		return scannedData;
	}

	public String inputRecordFromCSVFile(String rowFromFile) {

		rowFromFile.replaceAll("\"", "");
		String[] splitRow = rowFromFile.split(",");

		splitRow[7] = checkMinutesAndConvertToSeconds(splitRow[7]);
		splitRow[12] = checkMinutesAndConvertToSeconds(splitRow[12]);
		String fileRecord = splitRow[0];
		for (int i = 0; i < splitRow.length - 1; i++) {
			fileRecord = fileRecord.concat("," + splitRow[i + 1]);
		}
		return fileRecord;
	}

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
		return count;
	}

	public String[] csvReader(String filename) throws IOException {
		int n = countLinesInFile(filename);
		String lines[] = new String[n + 1];
		try {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			int i = 0;
			while ((strLine = br.readLine()) != null) {
				strLine = strLine.replaceAll("[\"]", "");
				lines[i] = strLine;
				i++;
			}
			in.close();
		}
		catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
		return lines;
	}

	public String checkMinutesAndConvertToSeconds(String res) {
		if (res.indexOf(':') != -1) {
			String[] splitted = res.split(":");
			res = Double.toString(60 * Double.parseDouble(splitted[0]) + Double.parseDouble(splitted[1]));
		}
		return res;
	}

	private String ask(Scanner s, String message, String pattern) {
		String response = null;
		while (true) {
			try {
				System.out.print(message);
				response = s.next(pattern);
				break;
			}
			catch (InputMismatchException e) {
				// ask again
				System.out.println("Wrong input data!");
				s.next();
			}
		}
		return response;
	}
}
