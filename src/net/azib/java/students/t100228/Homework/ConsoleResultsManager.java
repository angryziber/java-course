package net.azib.java.students.t100228.Homework;

import java.io.*;
import java.util.ArrayList;

/**
 * Reads input competition data from console and outputs the results to console
 * @author Martin
 */
public class ConsoleResultsManager {

	/**
	 * Reads console input data into an ArrayList of {@link Record}s
	 * @param listResults The {@link ArrayList} into which the console input data is read
	 * @param reader The {@link Reader} instance which is passed to this method to facilitate testing (in case of
	 * testing, a {@link FileReader} instance is provided; in case of running the program, a {@link InputStreamReader}
	 * is provided
	 * @throws Exception
	 */
	public void fetchResults(ArrayList<Record> listResults, Reader reader) throws Exception{
		BufferedReader br = new BufferedReader(reader);// new InputStreamReader(System.in));
		System.out.println("Enter results in the form <\"contestant name\">,<date of birth [dd-mm-yyyy]>," +
			"<nationality>,<results of ten events separated by comma>");

		while(true)
		{
			Record record = new Record();
			String strTmp = br.readLine();
			String[] arrayStringTmp = strTmp.split(",");

			record.setName(arrayStringTmp[0]);

			record.setBirthDate(arrayStringTmp[1]);

			record.setNationality(arrayStringTmp[2]);

			// 100m
			Float res = new Float(arrayStringTmp[3]);
			record.setHundredMResult(res);

			//long jump
			res = new Float(arrayStringTmp[4]);
			record.setLongJumpResult(res);

			// shot put
			res = new Float(arrayStringTmp[5]);
			record.setShotPutResult(res);

			// high jump
			res = new Float(arrayStringTmp[6]);
			record.setHighJumpResult(res);

			// 400 m
			record.setFourHundredMResult(arrayStringTmp[7]);

			// 110 m hurdles
			res = new Float(arrayStringTmp[8]);
			record.setOneHundredTenResult(res);

			// Discus throw
			res = new Float(arrayStringTmp[9]);
			record.setDiscusResult(res);

			// pole vault
			res = new Float(arrayStringTmp[10]);
			record.setPoleVaultResult(res);

			// javelin throw
			res = new Float(arrayStringTmp[11]);
			record.setJavelinResult(res);

			// 1500 m
			//res = new Float(arrayStringTmp[12]);
			record.setThousandFiveHundredResult(arrayStringTmp[12]);

			listResults.add(record);
			System.out.println("More results? (y/n)");
			strTmp = br.readLine();
			if(!strTmp.equals("y"))
			{
				break;
			}
		}
	}

	/**
	 * Writes the results of the competition with scores and places to the stream provided by {@code writer}.
	 * @param listResults The {@link ArrayList} instance which contains the {@link Record}s to be outputted to stream
	 * @param writer The {@link Writer} instance which is passed to this method to facilitate testing (in case of
	 * testing, a {@link FileWriter} instance is provided; in case of running the program, a {@link OutputStreamWriter}
	 * is provided
	 * @throws Exception
	 */
	public void outputResults(ArrayList<Record> listResults, Writer writer) throws Exception {
		BufferedWriter wr = new BufferedWriter(writer);
		wr.write("Ordered results:");
		for(Record record: listResults)
		{
			wr.write(record.getPlace() + "," + record.getScore() + "," + record.getName() + ","
					+ record.getBirthDate() + "," + record.getNationality() + "," + record.getHundredMResult() + "," +
					record.getLongJumpResult() + "," + record.getShotPutResult() + "," +
					record.getHighJumpResult() + "," + record.getFourHundredMResult() + "," +
					record.getOneHundredTenResult() + "," + record.getDiscusResult() + "," +
					record.getPoleVaultResult() + "," + record.getJavelinResult() + "," +
					record.getThousandFiveHundredResult());
			wr.write("\n");
		}
		wr.flush();
	}
}
