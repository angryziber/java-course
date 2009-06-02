package net.azib.java.students.t090437.homework.test;

import net.azib.java.students.t090437.homework.CompetitionDataLoader;
import net.azib.java.students.t090437.homework.Competitor;
import net.azib.java.students.t090437.homework.CompetitionFromCSV;
import net.azib.java.students.t090437.homework.MyException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Calendar;
import java.util.SortedSet;

import org.junit.*;


/**
 * CompetitorsFromCSVTest
 *
 * @author Ronald
 */
public class CompetitionFromCSVTest {
	String line = "\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72";
	
	@Test
	public void testIfCanReadExampleCSVFile() throws IOException, MyException {
		String testFileContents = "" +
				"\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 \r\n" +
				"\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76 \r\n" + 
				"\"Szőrös Szűk\",3.04.1972,HU,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75 \r\n" +
				"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01 ";
		
		File testFile = File.createTempFile("test", ".csv"); 
		
		Writer writer = new FileWriter(testFile);
		writer.write(testFileContents);
		
		writer.close();
		
		CompetitionDataLoader dataLoader = new CompetitionFromCSV(testFile.getAbsolutePath());
		
		dataLoader.loadData();
		
		SortedSet<Competitor> competitors = dataLoader.getResults();
		
		int count_competitors = 0;
		for(Competitor competitor : competitors) {
			count_competitors++;
			if(competitor.getName().equals("Siim Susi")) {			
				Assert.assertTrue(competitor.getCountry().equals("EE"));
				Assert.assertEquals(competitor.getSprint_100m_s().getSec(), 12.61, 0.001);
			} else if(competitor.getName().equals("Szőrös Szűk")) {
				Calendar bday = Calendar.getInstance();
				bday.setTime(competitor.getBirthday());

				Assert.assertTrue(bday.get(Calendar.DAY_OF_MONTH) == 3);
				Assert.assertTrue(bday.get(Calendar.MONTH) == 3); // Month Jan == 0, Apr == 3
				Assert.assertTrue(bday.get(Calendar.YEAR) == 1972);
			}
		}
		
		Assert.assertTrue(count_competitors == 4);
		
		testFile.delete();
	}
	
	@Test
	public void testIfWorksWithEmptyFile() throws IOException, MyException {
		String testFileContents = "";
			
		File testFile = File.createTempFile("testfile", ".csv");
		
		Writer writer = new FileWriter(testFile);
		writer.write(testFileContents);
		
		writer.close();
		
		CompetitionDataLoader dataLoader = new CompetitionFromCSV(testFile.getAbsolutePath());
		
		dataLoader.loadData();
		
		SortedSet<Competitor> competitors = dataLoader.getResults();
		
		Assert.assertNotNull(competitors);
		Assert.assertTrue(competitors.size() == 0);

		testFile.delete();
	}
}
