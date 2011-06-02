package net.azib.java.students.t100228.Homework;

import java.io.*;
import java.util.ArrayList;

/**
 * Reads and writes competition results from/to a CSV file
 * @author Martin
 */
public class CsvResultsManager {

	/**
	 * Reads competition results from a CSV file into an ArrayList of {@link Record}s
	 * @param listResults The {@link ArrayList} into which the competition results are read
	 * @param fileName Path of the input CSV file
	 * @throws Exception
	 */
	public void fetchResults(ArrayList<Record> listResults, String fileName) throws Exception{
		File f = new File(fileName);
		if(!f.exists())
		{
			throw new FileNotFoundException();
		}
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null)
		{
			String[] individualResults = line.split(",");
			Record record = new Record();

			record.setName(individualResults[0]);
			record.setBirthDate(individualResults[1]);
			record.setNationality(individualResults[2]);

			record.setHundredMResult(new Float(individualResults[3]));
			record.setLongJumpResult(new Float(individualResults[4]));
			record.setShotPutResult(new Float(individualResults[5]));
			record.setHighJumpResult(new Float(individualResults[6]));
			record.setFourHundredMResult(individualResults[7]);
			record.setOneHundredTenResult(new Float(individualResults[8]));
			record.setDiscusResult(new Float(individualResults[9]));
			record.setPoleVaultResult(new Float(individualResults[10]));
			record.setJavelinResult(new Float(individualResults[11]));
			record.setThousandFiveHundredResult(individualResults[12]);

			listResults.add(record);
			line = br.readLine();

		}
		br.close();
		fr.close();
	}

	/**
	 * Writes competition results from {@code records} to the file specified by {@code fileName}
	 * @param fileName Path of the file to write competition results into
	 * @param records {@link ArrayList} of {@link Record}s which contains competition results
	 */
	public void outputResults(String fileName, ArrayList<Record> records) throws FileNotFoundException {

		PrintWriter printWriter;

		File f = new File(fileName);

		printWriter = new PrintWriter(fileName);

		for(Record record: records)
		{
			printWriter.println(record.getPlace() + "," + record.getScore() + "," + record.getName() + ","
					+ record.getBirthDate() + "," + record.getNationality() + "," + record.getHundredMResult() + "," +
					record.getLongJumpResult() + "," + record.getShotPutResult() + "," +
					record.getHighJumpResult() + "," + record.getFourHundredMResult() + "," +
					record.getOneHundredTenResult() + "," + record.getDiscusResult() + "," +
					record.getPoleVaultResult() + "," + record.getJavelinResult() + "," +
					record.getThousandFiveHundredResult());
		}
		printWriter.close();
	}
}
