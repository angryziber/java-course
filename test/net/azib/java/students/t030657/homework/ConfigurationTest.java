package net.azib.java.students.t030657.homework;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Karina
 * public class ConfigurationTest
 *
 */

public class ConfigurationTest  {
	@Test
	public void testReaderCreation() {
		String[] argv = {"-f", "i.csv"};
		Configuration conf = new Configuration(argv);
		Reader reader = conf.getReader();
		assertTrue(reader instanceof CsvReader);
	}  
	@Test
	public void testWriterCreation() {
		String[] argv = {"-o", "o.csv"};
		Configuration conf = new Configuration(argv);
		Writer writer = conf.getWriter();
		assertTrue(writer instanceof CsvWriter);
	}  
}