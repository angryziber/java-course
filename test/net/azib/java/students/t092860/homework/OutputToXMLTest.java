package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * OutputToXMLTest
 */
public class OutputToXMLTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.OutputToXML#set(java.util.List)}.
	 * @throws Exception 
	 */
	@Test
	public final void testSet() throws Exception {
		OutputStreamMock outputMock = new OutputStreamMock();
		OutputToXML testObj = new OutputToXML(outputMock);
		assertNotNull(testObj);
				
		testObj.set(TestData.GetOutputData());
		
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+System.getProperty("line.separator")+
		"<Competition>" +
			"<Athlete>" +
				"<Position>1</Position>" +
				"<Score>6000</Score>" +
				"<Name>Name</Name>" +
				"<Birthdate>reede, 20. Oktoober 2000</Birthdate>" +
				"<Country>EE</Country>" +
				"<Events>" +
					"<RACE_100M>90.0</RACE_100M>" +
					"<LONG_JUMP>20.45</LONG_JUMP>" +
					"<SHOT_PUT>20.45</SHOT_PUT>" +
					"<HIGH_JUMP>20.45</HIGH_JUMP>" +
					"<RACE_400M>90.0</RACE_400M>" +
					"<HURDLES_110M>90.0</HURDLES_110M>" +
					"<DISCUS_THROW>20.45</DISCUS_THROW>" +
					"<POLE_VAULT>20.45</POLE_VAULT>" +
					"<JAVELIN_THROW>20.45</JAVELIN_THROW>" +
					"<RACE_1500M>90.0</RACE_1500M>" +
				"</Events>" +
			"</Athlete>" +
		"</Competition>"+System.getProperty("line.separator");
		
		String result = outputMock.read();
		assertTrue(result.compareTo(expected) == 0);
	}
}
