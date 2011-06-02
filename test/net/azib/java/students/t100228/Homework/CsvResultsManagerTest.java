package net.azib.java.students.t100228.Homework;

import static org.junit.Assert.assertEquals;

import net.azib.java.students.t100228.Homework.CsvResultsManager;
import net.azib.java.students.t100228.Homework.Record;
import org.junit.Test;

import static org.junit.Assert.fail;

import java.io.*;
import java.util.ArrayList;

/**
 * Unit tests for the {@link CsvResultsManager} class
 * @author Martin
 */
public class CsvResultsManagerTest {
	/**
	 * Test for the method {@link CsvResultsManager#fetchResults(ArrayList, String)}
	 */
	@Test
	public void fetchResults()
	{
		PrintWriter writer = null;
		File fileTmp = null;

		try
		{
			fileTmp = File.createTempFile("testCsv", "csv");
			fileTmp.deleteOnExit();
			writer = new PrintWriter(fileTmp);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail("Couldn't create temporary file.");
		}

		writer.println("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
		writer.close();

		ArrayList<Record> records = new ArrayList<Record>();

		CsvResultsManager manager = new CsvResultsManager();

		try
		{
			manager.fetchResults(records, fileTmp.getAbsolutePath());
		}
		catch (Exception ex)
		{
			fail("Exception thrown!");
		}

		assertEquals("5:25.72", records.get(0).getThousandFiveHundredResult());
	}

	/**
	 * Test for the method {@link CsvResultsManager#outputResults(String, ArrayList)}
	 */
	@Test
	public void outputResults()
	{
		PrintWriter writer = null;
		File fileTmp = null;

		try
		{
			fileTmp = File.createTempFile("testCsv", "csv");
			fileTmp.deleteOnExit();
			writer = new PrintWriter(fileTmp);

			// write result to file
			writer.println("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
			writer.close();

			ArrayList<Record> records = new ArrayList<Record>();

			CsvResultsManager manager = new CsvResultsManager();

			// read result back from file
			manager.fetchResults(records, fileTmp.getAbsolutePath());

			File fileTmp2 = null;

			fileTmp2 = File.createTempFile("testCsvOut", "csv");
			fileTmp2.deleteOnExit();


			manager.outputResults(fileTmp2.getAbsolutePath(), records);

			records.clear();

			FileReader fr = new FileReader(fileTmp2.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			if(line != null)
			{
				String[] individualResults = line.split(",");
				assertEquals("5:25.72",individualResults[14]);
			}
			else
			{
				fail("Input file is empty!");
			}
		}
		catch (Exception ex)
		{
			fail("Exception thrown!");
		}
	}
}
