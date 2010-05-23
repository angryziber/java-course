package net.azib.java.students.t050724.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * CSVScanner
 * 
 * @author xom
 */
public class CSVReader {

	SupportClass supporter = new SupportClass();

	/**
	 * Reads input data from the file specified by the parameter "path", checks
	 * its validity, puts it into Athlete object and returns the object.
	 * 
	 * @param path
	 *            String representation of the file or path, where to get the
	 *            data from.
	 * @return Athlete object that has been filled with input data.
	 */
	protected ArrayList<Athlete> getDataFromCSV(String path) {

		path = supporter.setFilePath(path);

		ArrayList<String> rawDataList = new ArrayList<String>();
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		String[] dataList;

		try {
			rawDataList = readFile(path);
		}
		catch (IOException e) {
			System.out.println("Problems with reading the file!");
		}

		for (String rawData : rawDataList) {

			Athlete athleteFromCSV = new Athlete();

			dataList = rawData.split(",");
			boolean allOK = false;

			try {
				athleteFromCSV.setName(supporter.checkAthleteName(dataList[0].replace("\"", "")));

				athleteFromCSV.setDate(supporter.checkAthleteDate(dataList[1]));

				athleteFromCSV.setCountry(supporter.checkAthleteCountry(dataList[2]));

				athleteFromCSV.setHm(Double.parseDouble(dataList[3]));

				athleteFromCSV.setLongJump(Double.parseDouble(dataList[4]));

				athleteFromCSV.setShotPut(Double.parseDouble(dataList[5]));

				athleteFromCSV.setHighJump(Double.parseDouble(dataList[6]));

				athleteFromCSV.setFhm(supporter.setAthleteResultDoubleWithMins(dataList[7]));

				athleteFromCSV.setHtmHurdles(Double.parseDouble(dataList[8]));

				athleteFromCSV.setDiscusThrow(Double.parseDouble(dataList[9]));

				athleteFromCSV.setPoleVault(Double.parseDouble(dataList[10]));

				athleteFromCSV.setJavelinThrow(Double.parseDouble(dataList[11]));

				athleteFromCSV.setTfhm(supporter.setAthleteResultDoubleWithMins(dataList[12]));

				allOK = true;
			}
			catch (Exception e) {

				System.out.println("There is some bad data in " + dataList[0] + "'s results, omitting it...");

			}

			if (allOK) {
				athletes.add(athleteFromCSV);
			}
			athleteFromCSV = null;

		}

		return athletes;

	}

	private ArrayList<String> readFile(String path) throws IOException {

		String line;
		ArrayList<String> lines = new ArrayList<String>();

		File file = new File(path);
		InputStreamReader streamreader = new InputStreamReader(new FileInputStream(file), "UTF-8");

		BufferedReader reader = new BufferedReader(streamreader);
		while ((line = reader.readLine()) != null) {
			lines.add(line.trim());
		}

		reader.close();

		return lines;
	}
}
