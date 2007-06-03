package net.azib.java.students.t060401.homework.test;

import net.azib.java.students.t060401.homework.decathlon.Athlete;
import net.azib.java.students.t060401.homework.decathlon.DecathlonInfoVector;
import net.azib.java.students.t060401.homework.decathlon.DecathlonResults;
import net.azib.java.students.t060401.homework.util.Utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * ThletesTest
 * 
 * @author t060401
 */
public class DecathlonInfoVectorTest {

	private DecathlonInfoVector decathlonVector;
	private String filePath1 = "test1"+this.hashCode()+".csv";
	private String filePath2 = "test2"+this.hashCode()+".csv";

	@Before
	public void createPropVector() {
		saveDecathlonTestData();
		decathlonVector = new DecathlonInfoVector();
	}

	@Test
	public void testLoadDecathlonInfoFromFile() throws Exception {

		decathlonVector.loadDecathlonInfoFromFile(filePath1);
		assertEquals("Expected exactly one athlete in vector", 1, decathlonVector.size());
		Iterator iter = decathlonVector.iterator();
		while (iter.hasNext()) {
			Athlete athlete = (Athlete) iter.next();
			assertEquals("Birth time was not parsed correctly. ", Utils.getDate("01.01.1976"), athlete.getBirthTime());
			assertEquals("Name was not parsed correctly. ", "Siim Susi", athlete.getName());
			assertEquals("Country was not parsed correctly. ", "EE", athlete.getCountry());
			DecathlonResults results = athlete.getDecathlonResults();
			assertEquals("Decathlon info was not parsed correctly. ", 4234, results.getPoints());
		};
		decathlonVector.saveDecathlonInfoVector(filePath2);
		try {
			File file = new File(filePath2);
			assertTrue("Vector could not be saved to a file", file.exists());
		}
		catch (Exception e) {
			fail("Vector could not be saved to a file");
		}
		deleteTestData();
	}

	private void saveDecathlonTestData() {
		String fileContent = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
		if (fileContent != null) {
			try {
				BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath1), "UTF-8"));
				out.write(fileContent);
				out.close();
				System.out.println("Wrote file to " + filePath1);
			}
			catch (Exception e) {
				System.out.println("Failed to write file: " + filePath1 + ". " + e);
			}
		}
	}

	private void deleteTestData() {
		try {
			System.out.println(filePath1);
			System.out.println(filePath2);
			File file = new File(filePath1);
			file.delete();
			File file2 = new File(filePath2);
			file2.delete();
		}
		catch (Exception e) {
			System.out.println("Failed to delete test files: " + filePath1 + " and " + filePath2 + e);
		}
	}
}
