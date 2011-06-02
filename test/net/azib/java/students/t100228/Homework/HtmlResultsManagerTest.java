package net.azib.java.students.t100228.Homework;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Unit test for the {@link HtmlResultsManager} class
 * @author Martin
 */
public class HtmlResultsManagerTest {
	/**
	 * Test for the method {@link HtmlResultsManager#outputResults(String, ArrayList)}
	 */
	@Test
	public void outputResults()
	{
		Record record = new Record("Siim Susi", 0, "01.01.1976", "EE", 12.61F, 5.00F, 9.22F, 1.5F, "59.39", 16.43F,
						21.60F, 2.60F, 35.81F, "5:25.72");

		record.setPlace("1");

		ArrayList<Record> records = new ArrayList<Record>();

		records.add(record);

		try
		{
			File fileTmp = new File("test.html");
			fileTmp.deleteOnExit();

			HtmlResultsManager manager = new HtmlResultsManager();
			manager.outputResults(fileTmp.getAbsolutePath(), records);

			FileReader fr = new FileReader(fileTmp.getAbsolutePath());
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();

			boolean substringFound = false;

			while(line != null)
			{
				if(line.indexOf("Siim Susi") > 0)
				{
					substringFound = true;
					break;
				}
				line = br.readLine();
			}

			assertEquals(true, substringFound);
		}
		catch(Exception ex)
		{
			fail("Exception occurred!");
		}
	}
}
