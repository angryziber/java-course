package net.azib.java.students.t092860.homework;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * OutputToXMLTest
 */
public class OutputToXMLTest {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
		Locale.setDefault(Locale.UK);
    }
    
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
		
		// Warning: locale & OS-specific test!
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" +
		"<Competition>" +
			"<Athlete>" +
				"<Position>1</Position>" +
				"<Score>6000</Score>" +
				"<Name>Name</Name>" +
				"<Birthdate>Friday, 20 October 2000</Birthdate>" +
				"<Country>EE</Country>" +
				"<Events>" +
					"<RACE_100M>90.00</RACE_100M>" +
					"<LONG_JUMP>20.45</LONG_JUMP>" +
					"<SHOT_PUT>20.45</SHOT_PUT>" +
					"<HIGH_JUMP>20.45</HIGH_JUMP>" +
					"<RACE_400M>90.00</RACE_400M>" +
					"<HURDLES_110M>90.00</HURDLES_110M>" +
					"<DISCUS_THROW>20.45</DISCUS_THROW>" +
					"<POLE_VAULT>20.45</POLE_VAULT>" +
					"<JAVELIN_THROW>20.45</JAVELIN_THROW>" +
					"<RACE_1500M>90.00</RACE_1500M>" +
				"</Events>" +
			"</Athlete>" +
		"</Competition>\r\n";
		
		String result = outputMock.read();
		assertEquals(expected, result);
	}
}
