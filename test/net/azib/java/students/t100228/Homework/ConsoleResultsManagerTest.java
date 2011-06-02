package net.azib.java.students.t100228.Homework;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Unit tests for the {@link ConsoleResultsManager} class
 * @author Martin
 */
public class ConsoleResultsManagerTest {
	/**
	 * Test for the method {@link ConsoleResultsManager#fetchResults(ArrayList, Reader)}. First writes one competitor's
	 * results to file, then lets the {@link ConsoleResultsManager} fetch the results from file.
	 */
	@Test
	public void fetchResults()
	{
		PrintWriter writer = null;
		File fileTmp = null;

		try
		{
			fileTmp = File.createTempFile("testConsole", "txt");
			fileTmp.deleteOnExit();
			writer = new PrintWriter(fileTmp);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			fail("Couldn't create temporary file.");
		}

		writer.println("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72");
		writer.println("n");
		writer.close();

		ArrayList<Record> records = new ArrayList<Record>();
		ConsoleResultsManager manager = new ConsoleResultsManager();

		try
		{
			manager.fetchResults(records, new FileReader(fileTmp.getAbsolutePath()));
		}
		catch (Exception ex)
		{
			fail("Exception thrown!");
		}

		assertEquals("5:25.72", records.get(0).getThousandFiveHundredResult());
	}

	/**
	 * Test for the method {@link ConsoleResultsManager#outputResults(ArrayList, Writer)}. First lets the
	 * {@link ConsoleResultsManager} write the results to file, then reads the results back from file.
	 */
	@Test
	public void outputResults() {

		PrintWriter writer = null;
		PrintWriter writer2 = null;
		File fileTmp = null;
		ArrayList<Record> records = new ArrayList<Record>();

		try
		{
			Record record = new Record("Siim Susi", 0, "01.01.1976", "EE", 12.61F, 5.00F, 9.22F, 1.5F, "59.39", 16.43F,
					21.60F, 2.60F, 35.81F, "5:25.72");

			records.add(record);

			ConsoleResultsManager manager = new ConsoleResultsManager();

			fileTmp = File.createTempFile("testConsoleOut", "txt");
			fileTmp.deleteOnExit();

			manager.outputResults(records, new FileWriter(fileTmp));
			records.clear();

			BufferedReader br = new BufferedReader(new FileReader(fileTmp.getAbsolutePath()));
			String strTmp = br.readLine();
			String[] arrayStringTmp = strTmp.split(",");

			assertEquals("5:25.72", arrayStringTmp[14]);
		}
		catch (Exception ex)
		{
			fail("Exception thrown");
		}
	}
}
