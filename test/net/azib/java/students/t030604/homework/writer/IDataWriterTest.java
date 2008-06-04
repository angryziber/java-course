package net.azib.java.students.t030604.homework.writer;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataWriter;

import java.io.File;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * CsvWriterTest common tests for CSV, XML, HTML writers
 *
 * @author Aleksandr Ivanov
 */
public class IDataWriterTest {
	
	private static final String tempPath = System.getProperty("java.io.tmpdir");
	private static final String fileName = "temp.output";
	private static final String absoluteFileName = tempPath + "\\" + fileName;
	
	private List<AthleteScore> results;
	
	/**
	 * tests if writers can initialize properly
	 * @throws WriterException
	 */
	@Test
	public void testSetupValid() throws WriterException {
		List<String> errors = new LinkedList<String>();
		//csv
		try {
			testSetupValid(new CsvWriter());
		} catch (Exception failed) {
			errors.add("CSV writer setup failed. " + failed.getMessage());
		}
		//xml
		try {
			testSetupValid(new XmlWriter());
		} catch (Exception failed) {
			errors.add("XML writer setup failed. " + failed.getMessage());
		}
		//html
		try {
			testSetupValid(new HtmlWriter());
		} catch (Exception failed) {
			errors.add("HTML writer setup failed. " + failed.getMessage());
		}
		Assert.assertTrue(errors.toString(), errors.isEmpty());
	}
	
	@Test
	public void testSetupInvalid() throws WriterException {
		int expectedErrors = 0;
		//csv
		try {
			testSetupInvalid(new CsvWriter());
		} catch (WriterException expected) {
			expectedErrors++;
		}
		//xml
		try {
			testSetupInvalid(new XmlWriter());
		} catch (WriterException expected) {
			expectedErrors++;
		}
		//html
		try {
			testSetupInvalid(new HtmlWriter());
		} catch (WriterException expected) {
			expectedErrors++;
		}
		Assert.assertEquals("Some writers allow null argument setup methods", 3, expectedErrors);
	}

	/**
	 * tests if writers can output scores to the file
	 * @throws WriterException
	 */
	@Test
	public void testOutput() throws WriterException {
		List<String> errors = new LinkedList<String>();
		//csv
		try {
			testOutput(new CsvWriter());
		} catch (Exception failed) {
			errors.add("CSV writer output failed. " + failed.getMessage());
		} finally {
			tearDown();
		}
		//xml
		try {
			testOutput(new XmlWriter());
		} catch (Exception failed) {
			errors.add("XML writer output failed. " + failed.getMessage());
		} finally {
			tearDown();
		}
		//html
		try {
			testOutput(new HtmlWriter());
		} catch (Exception failed) {
			errors.add("HTML writer output failed. " + failed.getMessage());
		} finally {
			tearDown();
		}
		Assert.assertTrue(errors.toString(), errors.isEmpty());
	}
	
	
	//tests valid setup case
	private void testSetupValid(IDataWriter tested) throws WriterException {
		tested.setup(absoluteFileName);
	}
	
	//tests invalid setup case
	private void testSetupInvalid(IDataWriter writer) throws WriterException {
		//all tested writers must have output filename as a parameter.
		//so this should fail with the Exception
		writer.setup();
	}
	
	//helper method to test output for one single writer
	private void testOutput(IDataWriter tested) throws WriterException {
		tested.setup(absoluteFileName);
		tested.output(results);
		tested.cleanup();
		//here is the plan
		// if the file is present in the temp dir - we 
		// assume that the operation was OK
		File folder = new File(tempPath);
		boolean ok = false;
		
		for(String file : folder.list()) {
			if (fileName.equalsIgnoreCase(file)) {
				ok = true;
				break;
			}
		}
		Assert.assertTrue(ok);
	}
	
	
	/**
	 * loads initial data
	 */
	@Before
	public void setUp() {
		results = new LinkedList<AthleteScore>();
		AthleteScore test = new AthleteScore(
				"John Doe", 
				new Date(), 
				"EE", 
				10F,
				10F,
				10F,
				10F,
				10F,
				10F, 
				10F, 
				10F, 
				10F, 
				10F);
		test.setPoints(1000);
		test.setRank(1);
		results.add(test);
		test.setName("Another John");
		test.setRank(2);
		test.setPoints(100);
		results.add(test);
	}

	/**
	 * deletes unneeded tmp files
	 */
	private void tearDown(){
		File doomed = new File(absoluteFileName);
		doomed.delete();
	}
	
}
