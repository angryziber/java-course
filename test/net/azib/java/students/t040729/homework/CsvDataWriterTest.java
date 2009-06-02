package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

/**
 * CsvDataWriterTest
 * 
 * @author ValleTon
 */
public class CsvDataWriterTest {

	/**
	 * Test method for {@link net.azib.java.students.t040729.homework.CsvDataWriter#putCompetitionData(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	public void testCsvFileGeneration() throws Exception {
		float[] results = {10.99f,3.95f,23.12f,2.45f,61.99f,12.87f,74.08f,6.14f,98.48f,206f};
		String expected = "\"\",0,\"Szőrös Szűk\",03.04.1972,HU,10.99,3.95,23.12,2.45,1:01.99,12.87,74.08,6.14,98.48,3:26.00";
		
		File file = File.createTempFile("csvwritetest","");
		file.deleteOnExit();
		
		List<Athlete> listToWrite = new ArrayList<Athlete>();
		Athlete athlete = new Athlete(new Name("Szőrös Szűk"),new BirthDate("3.04.1972","dd.MM.yyyy"),new Country("HU"));
		
		for (int i=0; i < results.length; i++){
			athlete.insertEventResult((byte) i, results[i]);

		}
		listToWrite.add(athlete);
		CsvDataWriter dataOut = new CsvDataWriter(file.getAbsolutePath());
		dataOut.setAppProperties(getFakeProperties());
		dataOut.putCompetitionData(listToWrite);
		
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(file),"utf-8"));
		assertEquals(expected,input.readLine());
		input.close();
	}
	
	private Properties getFakeProperties(){
		Properties fakeProperties = new Properties();
		fakeProperties.setProperty("encoding","utf-8");
		fakeProperties.setProperty("dateformat_string","dd.MM.yyyy");
		fakeProperties.setProperty("dateformat_console_short","dd.MM.yy");
		fakeProperties.setProperty("xml_dateformat_string","yyyy-MM-dd");
		return fakeProperties;
	}
}
