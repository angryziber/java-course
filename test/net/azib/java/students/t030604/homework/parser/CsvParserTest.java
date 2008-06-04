package net.azib.java.students.t030604.homework.parser;

import net.azib.java.students.t030604.homework.AthleteScore;
import net.azib.java.students.t030604.homework.IDataParser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * CsvParserTest
 *
 * @author Aleksandr Ivanov
 */
public class CsvParserTest{

	@Test
	public void testSetupValid() throws Exception {
		File temp = File.createTempFile("test", ".tmp", null);
		temp.deleteOnExit();
		new CsvParser().setup(temp.getAbsolutePath());
	}
	
	@Test
	public void testSetupInvalid() {
		try {
			new CsvParser().setup("test1.txt");
		} catch (Exception expected){}
		try {
			new CsvParser().setup();
		} catch (Exception expected){}
	}
	
	@Test 
	public void testParseDataValid() throws Exception {
		File temp = File.createTempFile("test", ".tmp", null);
		temp.deleteOnExit();
		FileWriter writer = new FileWriter(temp);
		writer.append("\"Siim Susi\",01.01.1976,EE,12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 ");
		writer.flush();
		writer.close();
		IDataParser parser = new CsvParser();
		parser.setup(temp.getAbsolutePath());
		List<AthleteScore> tested = parser.parseData();
		Assert.assertEquals(1, tested.size());
	}
	
	@Test (expected=ParserException.class)
	public void testParseDataInvalid() throws ParserException, IOException{
		File temp = File.createTempFile("test", ".tmp", null);
		temp.deleteOnExit();
		FileWriter writer = new FileWriter(temp);
		writer.append("\"Siim Susi\",12.61,5.00,9.22,1.50,59.39,16.43,21.60,2.60,35.81,5:25.72 ");
		writer.flush();
		writer.close();
		IDataParser parser = new CsvParser();
		parser.setup(temp.getAbsolutePath());
		parser.parseData();
	}
}
