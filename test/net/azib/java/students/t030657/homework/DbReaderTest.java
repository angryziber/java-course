package net.azib.java.students.t030657.homework;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Karina
 * public class DbReaderTest
 *
 */

public class DbReaderTest  {
	@Test
	public void test() throws Exception{
		
		Reader rd = new DbReader(1);
		List<Results> results = rd.readAll();
		assertTrue("wrong list size", results.size()>0);
	}
}