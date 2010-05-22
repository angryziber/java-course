package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * OutputToConsoleTest
 */
public class OutputToStreamTest {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
    }
    
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.OutputToConsole#set(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	public final void testSet() throws Exception {
		OutputStreamMock outputMock = new OutputStreamMock();
		OutputToStream testObj = new OutputToStream(outputMock);
		assertNotNull(testObj);
		
		testObj.set(TestData.GetOutputData());
		String expected = "1,6000,Name,reede, 20. Oktoober 2000,EE,90.00,20.45,20.45,20.45,90.00,90.00,20.45,20.45,20.45,90.00"+System.getProperty("line.separator");		
		String result = outputMock.read();

		assertTrue(result.compareTo(expected) == 0);
	}

}
