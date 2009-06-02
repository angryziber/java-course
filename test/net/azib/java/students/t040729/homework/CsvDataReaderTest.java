package net.azib.java.students.t040729.homework;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

public class CsvDataReaderTest {

	private String getLineToWrite(String name, String otherData, String[] results){
		String returnString = "";
		String str = Arrays.toString(results);
		returnString = "\""+name + "\","+otherData+","+str.substring(1, str.length()-1);
		
		return returnString;
	}
	
	private Properties getFakeProperties(){
		Properties fakeProperties = new Properties();
		fakeProperties.setProperty("encoding","utf-8");
		fakeProperties.setProperty("dateformat_string","dd.MM.yyyy");
		fakeProperties.setProperty("dateformat_console_short","dd.MM.yy");
		fakeProperties.setProperty("xml_dateformat_string","yyyy-MM-dd");
		return fakeProperties;
	}
	
	@Test
	public void testGetCompetitionDataHappyPath() throws Exception {
		String name1 = "Василий Пупкин";
		String name2 = "Szőrös Szűk";
		String[] results1 = { "10.99","3.95","23.12","2.45","1:01.99","12.87","74.08","6.14","98.48","3:26.00"};
		String[] results2 = { "19.99","4.95","23.12","2.45","1.99","12.87","24.08","3.14","58.48","8:26.00"};
		File file = File.createTempFile("csvreadtest","");
		file.deleteOnExit();
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
		
		String stringToWrite = getLineToWrite(name1,"21.10.1980,UA",results1) + "\n"+ getLineToWrite(name2,"3.04.1972,HU",results2);
		output.write(stringToWrite);
		output.close();
		
		CsvDataReader dataIn = new CsvDataReader(file.getAbsolutePath());
		dataIn.setAppProperties(getFakeProperties());
		List<Athlete> aList = dataIn.getCompetitionData();
		assertEquals(name1,aList.get(0).getName());
		assertEquals("21.10.1980",aList.get(0).getBirthDate());
		assertEquals("UA",aList.get(0).getCountryCode());
		for (int i=0; i < results1.length; i++){
			assertEquals(results1[i],aList.get(0).getFormattedResult((byte) i));
		}
		assertEquals(name2,aList.get(1).getName());
	}
	
	@Test
	public void testCsvFileWithBadData() throws IOException{
		File file = File.createTempFile("csvreadtest2","");
		file.deleteOnExit();
		
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"utf-8"));
		
		String stringToWrite = "\"My name\",10.10.2000,EE,tere,3.95,23.12,2.45,1:01.99,12.87,74.08,6.14,98.48,3:26.00";
		output.write(stringToWrite);
		output.close();

		CsvDataReader dataIn = new CsvDataReader(file.getAbsolutePath());
		try{
			dataIn.setAppProperties(getFakeProperties());
			@SuppressWarnings("unused")
			List<Athlete> aList = dataIn.getCompetitionData();
			fail("CSV bad data test failed!");
		}catch(Exception e){
			
		}
	}
}
