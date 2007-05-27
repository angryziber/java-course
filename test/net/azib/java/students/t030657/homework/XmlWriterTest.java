package net.azib.java.students.t030657.homework;

import java.io.File;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Karina
 * public class XmlWriterTest
 *
 */

public class XmlWriterTest  {
	@Test
	public void test() throws Exception{
		
		Reader rd = new CsvReader(new File("test/comp1.txt"));
		List<Results> results = rd.readAll();
		assertEquals("wrong list size", 6,results.size());

		File outputFile = new File("test/tmp.xml");
		Writer wr = new XmlWriter(outputFile);
		Results r = results.get(0);
		r.setPosition("1");
		wr.write(r);
		wr.close();
		
		assertTrue(outputFile.length()>3);
	}
}