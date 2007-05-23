package net.azib.java.students.t030657.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Karina
 * public class CsvTest
 *
 */

public class CsvTest  {
	@Test
	public void test() throws Exception{
		
		Reader rd = new CsvReader(new File("test/comp1.txt"));
		List<Results> results = rd.readAll();
		assertNotNull("read failed", results);
		assertEquals("wrong list size", 6,results.size());

		File outputFile = new File("test/tmp.csv");
		Writer wr = new CsvWriter(outputFile);
		Results r = results.get(0);
		r.setPosition("1");
		wr.write(r);
		wr.close();
		
		FileInputStream fis = new FileInputStream(outputFile);
		InputStreamReader in = new InputStreamReader(fis, "UTF-8");
		BufferedReader input = new BufferedReader(in);
		String line = input.readLine();
		assertNotNull(line);
		String[] fields = line.split(CsvReader.SEPARATOR);
		assertTrue(fields.length>CsvReader.MIN_FIELDS);

		
	}
}