package net.azib.java.students.t020632.homework;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestCSVInput
 *
 * @author t020632
 */
public class TestCSVInput {
	
	CSVInput input;
	
	@Before
	public void setUp() throws Exception {
		input = new CSVInput("net/azib/java/students/t020632/homework/test.csv");
	}
	
	@Test
	public void testname() throws Exception {
		input.read();
	}

	@After
	public void tearDown() throws Exception {
		input = null;
	}

}
