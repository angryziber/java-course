package net.azib.java.students.t092851.homework;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * DecathlonDataOutputCSV
 *
 * @author Lauri
 */
public class DecathlonDataOutputCSV implements DecathlonDataOutput {
	
	private String fileName;
	
	/**
	 * @param fileName output CSV file name
	 */	
	public DecathlonDataOutputCSV(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * @param data decathlon competition data to write into CSV file
	 * @return true on success
	 */	
	@Override
	public boolean writeData(DecathlonData data) {
		BufferedWriter writer     = null;
		DateFormat     dateFormat = new SimpleDateFormat("dd.MM.yyyy");		
		int            rank       = 0;
		
		if (data == null)
			return false;
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
			for (Participant athlete : data)
			{
				writer.write(String.valueOf(++rank) + ",");
				writer.write(String.valueOf(athlete.getPoints()) + ",");
				writer.write("\"" + athlete.getName() + "\",");
				writer.write(dateFormat.format(athlete.getBirthDate()) + ",");
				writer.write(athlete.getCountry());
				for (DecathlonEvent event : DecathlonEvent.values()) {
					writer.write("," + String.valueOf(athlete.getResult(event)));
				}
				writer.write(System.getProperty("line.separator"));
			}	
		}
		catch (IOException e) {
			System.out.println("Cannot find the file " + fileName.toString());
			return false;
		}
		finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
			}
		}
		return true;
	}

}
