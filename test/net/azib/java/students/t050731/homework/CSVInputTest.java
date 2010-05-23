package net.azib.java.students.t050731.homework;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * ConsoleInputTest
 * 
 * @author Raigo
 */

public class CSVInputTest {

	InputAthletesFromCSV in = new InputAthletesFromCSV();
	HelperMethods helper = null;
	
//	@Test
//	public void test() {	
//
//		helper = EasyMock.createMock(HelperMethods.class);
//		in = new InputAthletesFromCSV();
//		in.readFromCSV("athletes");
//		
//		EasyMock.expect(helper.checkIfFileExits("athletes")).andReturn(true);
//		EasyMock.replay(helper);
//    	
//		verify(helper);
//	}
	
	@Test
	public void testFileExistance()
	{	
		assertEquals(null, in.readFromCSV(""));
	}
	
}
