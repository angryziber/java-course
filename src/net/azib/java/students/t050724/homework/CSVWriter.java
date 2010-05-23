package net.azib.java.students.t050724.homework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * CSVPrinter
 * 
 * @author xom
 */
public class CSVWriter {

	SupportClass supporter = new SupportClass();

	/**
	 * Writes the data of the parameter "athletes" to a .csv file that is
	 * specified by the parameter "path".
	 * 
	 * @param athletes
	 *            ArrayList of Athlete that is to be printed out to console.
	 * @param path
	 *            String representation of the file or path, where to write the
	 *            file.
	 */
	protected void printDataToFile(ArrayList<Athlete> athletes, String path) {

		path = supporter.setFilePath(path);

		ArrayList<String> athletesToPrint = new ArrayList<String>();
		athletesToPrint = supporter.createAthleteStrings(athletes);

		try {
			writeFile(athletesToPrint, path);
		}
		catch (IOException e) {
			System.out.println("Problems writing the file!");
		}

	}

	private void writeFile(ArrayList<String> athletesToPrint, String path) throws IOException {

		File file = new File(path);
		OutputStreamWriter streamwriter = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");

		BufferedWriter writer = new BufferedWriter(streamwriter);
		for (String string : athletesToPrint) {
			writer.write(string);
			writer.newLine();
		}

		writer.close();
	}

}
