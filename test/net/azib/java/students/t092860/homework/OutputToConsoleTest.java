package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * OutputToConsoleTest
 *
 * @author armin
 */
public class OutputToConsoleTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.OutputToConsole#set(java.util.List)}.
	 */
	@Test
	public final void testSet() {
		OutputStreamMock outputMock = new OutputStreamMock();
		OutputToConsole testObj = new OutputToConsole(outputMock);
		assertNotNull(testObj);
		
		try {			
			testObj.set(AthleteData.GetOutputData());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		String expected = "1,6000,Name,reede, 20. Oktoober 2000,EE,90.0,20.45,20.45,20.45,90.0,90.0,20.45,20.45,20.45,90.0"+System.getProperty("line.separator");
		
		String result = outputMock.read();
		assertTrue(result.compareTo(expected) == 0);
	}

}
