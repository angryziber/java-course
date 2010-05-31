package net.azib.java.students.t092851.homework;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DecathlonDataInputCVS
 *
 * @author Lauri
 */
public class DecathlonDataInputCSV implements DecathlonDataInput {
	
	private String fileName;

	
	/**
	 * @param fileName input CSV file name
	 */
	public DecathlonDataInputCSV(String fileName) {
		this.fileName = fileName;
	}

	
	/**
	 * Reads decathlon competition data from CSV file
	 * @return decathlon competition data; in case of failure returns 'null'
	 */	
	@Override
	public DecathlonData readData() {
		BufferedReader reader = null;
		String line;
		Participant athlete;
		String [] quoteSplit;
		String [] rawFields;
		DecathlonData data = new DecathlonData();
		int column;
		
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
			while ((line = reader.readLine()) != null) {
				column = 1;
				// Name field is surrounded by quotes, may contain comma 
				quoteSplit = line.split("\"");
				if (quoteSplit.length != 3) {
					System.out.println("Not supported input file format. Name must be enclosed to quotes.");
					return null;
				}
				rawFields = quoteSplit[2].split(",");
				if (rawFields.length < 13) {
					System.out.println("Not supported input file format. Data fields are missing.");
					return null;
				}
				athlete = new Participant();
				athlete.setName(quoteSplit[1]);
				athlete.setBirthDate(convertToDate(rawFields[column++]));
				athlete.setCountry(rawFields[column++]);
				for (DecathlonEvent event: DecathlonEvent.values())
					athlete.setResult(event, convertToDouble(rawFields[column++]));
				data.insert(athlete);
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("File \"" + fileName + "\" not found: " + e);
			data = null;
		}
		catch (IOException e) {
			System.out.println("Problem with reading from \"" + fileName + "\" file: " + e);
			data = null;
		}
		catch (ParseException e) {
			System.out.println("Invalid date or unsupported date format in file \"" + fileName + "\": " + e);
			data = null;
		}
		catch (NumberFormatException e) {
			System.out.println("Invalid number format in file \"" + fileName + "\": " + e);
			data = null;			
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
				}
				catch (IOException e) {
				}
			}
		}
		return data;
	}
	
	
	private double convertToDouble(String s) {
		String [] timeSplit = s.split(":");
		if (timeSplit.length == 1) {
			return Double.valueOf(s);
		}
		return Double.valueOf(timeSplit[0]) * 60 + Double.valueOf(timeSplit[1]);
	}
	
	
	private Date convertToDate(String s) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = dateFormat.parse(s);
		return date;
	}

}
