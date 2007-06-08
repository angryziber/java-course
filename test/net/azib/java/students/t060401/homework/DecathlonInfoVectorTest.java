package net.azib.java.students.t060401.homework;

import net.azib.java.students.t060401.homework.decathlon.Athlete;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEvent;
import net.azib.java.students.t060401.homework.decathlon.DecathlonEventEnum;
import net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector;
import net.azib.java.students.t060401.homework.decathlon.DecathlonResults;
import net.azib.java.students.t060401.homework.decathlon.RunningEvent;
import net.azib.java.students.t060401.homework.util.DateUtil;
import net.azib.java.students.t060401.homework.util.LanguageUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Locale;

import junit.framework.TestCase;

/**
 * DecathlonInfoVectorTest
 * 
 * @author Astrid Pärn
 */
public class DecathlonInfoVectorTest extends TestCase {

	DecathlonInfoVector decathlonVector;
	private String filePath1 = "test1" + this.hashCode() + ".csv";
	private String filePath2 = "test2" + this.hashCode() + ".csv";
	private String filePath3 = "test3" + this.hashCode() + ".csv";

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		decathlonVector = new DecathlonInfoVector();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		deleteTestData();
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector#loadDecathlonInfoFromFile(java.lang.String)}.
	 */
	public void testLoadDecathlonInfoFromFile() {
		saveDecathlonTestData();
		String msg = "";
		try {
			msg = decathlonVector.loadDecathlonInfoFromFile(filePath1);
		}
		catch (Exception e1) {
			fail("File loading failed");
		}
		assertEquals("Expected success message when loading data from file", LanguageUtil.getString("LoadAthletes.DataLoaded"),
				msg);
		assertEquals("Expected exactly one athlete in vector", 1, decathlonVector.size());
		Iterator iter = decathlonVector.iterator();
		while (iter.hasNext()) {
			Athlete athlete = (Athlete) iter.next();
			assertEquals("Birth time was not parsed correctly. ", DateUtil.getDate("01.01.1976"), athlete.getBirthTime());
			assertEquals("Name was not parsed correctly. ", "Siim Susi", athlete.getName());
			assertEquals("Country was not parsed correctly. ", "EE", athlete.getCountry());
			DecathlonResults results = athlete.getDecathlonResults();
			assertEquals("Decathlon info was not parsed correctly. ", 4234, results.getPoints());
		}
		;

		try {
			msg = decathlonVector.loadDecathlonInfoFromFile(filePath3);
			assertEquals("File with invalid data should not be loaded successfully", LanguageUtil
					.getString("DecathlonVector.UnparsableFileRow")
					+ " 0 ." + LanguageUtil.getString("DecathlonVector.IllegalDataUnitsCount"), msg);
		}
		catch (Exception e1) {
			fail("File with invalid data should not throw exception");
		}
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector#saveDecathlonInfoVector(java.lang.String)}.
	 */
	public void testSaveDecathlonInfoVector() {
		try {
			decathlonVector.saveDecathlonInfoVector(filePath2);
			File file = new File(filePath2);
			assertTrue("Vector could not be saved to a file", file.exists());
		}
		catch (Exception e) {
			fail("Vector could not be saved to a file");
		}
	}

	/**
	 * Test method for
	 * {@link net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector#toSortedVector()}.
	 */
	public void testToSortedVector() {
		Athlete athlete1 = setAthlete(1);
		Athlete athlete2 = setAthlete(2);
		Athlete athlete3 = setAthlete(2);
		decathlonVector.add(athlete1);
		decathlonVector.add(athlete2);
		decathlonVector.add(athlete3);
		String expected = "[[1, 14612, Tom, 12.12.1983, AD, 01.00, 02.00, 03.00, 04.00, 05.00, 06.00, 07.00, 08.00, 09.00, 10.00], [2-3, 13858, Tom, 12.12.1983, AD, 02.00, 03.00, 04.00, 05.00, 06.00, 07.00, 08.00, 09.00, 10.00, 11.00], [2-3, 13858, Tom, 12.12.1983, AD, 02.00, 03.00, 04.00, 05.00, 06.00, 07.00, 08.00, 09.00, 10.00, 11.00]]";
		assertEquals(expected, decathlonVector.toSortedVector().toString());
	}

	private void saveDecathlonTestData() {
		// valid data
		String fileContent = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
		saveFile(fileContent, filePath1);
		// invalid data (last data unit missing)
		String invalidFileContent = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81";
		saveFile(invalidFileContent, filePath3);
	}

	private void saveFile(String fileContent, String filePath) {
		if (fileContent != null) {
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
				out.write(fileContent);
				out.close();
				System.out.println("Wrote file to " + filePath);
			}
			catch (Exception e) {
				System.out.println("Failed to write file: " + filePath + ". " + e);
			}
		}
	}

	private void deleteTestData() {
		try {
			File file = new File(filePath1);
			file.delete();
			File file2 = new File(filePath2);
			file2.delete();
			File file3 = new File(filePath3);
			file3.delete();
		}
		catch (Exception e) {
			System.out.println("Failed to delete test files: " + filePath1 + " and " + filePath2 + e);
		}
	}

	private Athlete setAthlete(int resultValue) {
		Athlete athlete = new Athlete("Tom", "12.12.1983", Locale.getISOCountries()[0]);
		DecathlonResults results = new DecathlonResults();
		DecathlonEventEnum[] eventTypes = DecathlonEventEnum.values();
		for (int i = 0; i < eventTypes.length; i++) {
			DecathlonEvent event = new RunningEvent(eventTypes[i], i + resultValue);
			results.put(event);
		}
		athlete.setDecathlonResults(results);
		return athlete;
	}
}
