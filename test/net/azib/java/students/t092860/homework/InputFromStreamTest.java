package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 * InputFromConsoleTest
 */
public class InputFromStreamTest {

	private static Logger logger = Logger.getLogger("global");
	
    @Before
    public void setUp() {
		logger.setLevel(Level.OFF);
    }
    
	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.InputFromConsole#get()}.
	 * @throws Exception 
	 */
	@Test
	public final void testGet() throws Exception {
		InputStreamMock inputMock = new InputStreamMock();
		InputFromStream testObj = new InputFromStream(inputMock);
		assertNotNull(testObj);
		
		List<Input.Data> output = new ArrayList<Input.Data>();
		
		String name = "Name";
		String date = "2000.10.20";
		String country = "EE";
		String trackPerf = "1:30";
		String fieldPerf = "20.45";
		
		String input = name+","+date+","+country+","
		+trackPerf+","+fieldPerf+","+fieldPerf+","+fieldPerf+","+trackPerf
		+","+trackPerf+","+fieldPerf+","+fieldPerf+","+fieldPerf+","+trackPerf;
		
		inputMock.write(input);
		output = testObj.get();
		
		assertTrue(output.get(0).getName().compareTo(name) == 0);
		assertTrue(output.get(0).getDate().compareTo((new SimpleDateFormat("dd.MM.yyyy")).parse(date)) == 0);
		assertTrue(output.get(0).getCountry().compareTo(country) == 0);
		assertTrue(output.get(0).getEventResult(Events.RACE_100M) == Converter.stringToTime(trackPerf));
		assertTrue(output.get(0).getEventResult(Events.LONG_JUMP) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.SHOT_PUT) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.HIGH_JUMP) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.RACE_400M) == Converter.stringToTime(trackPerf));
		assertTrue(output.get(0).getEventResult(Events.HURDLES_110M) == Converter.stringToTime(trackPerf));
		assertTrue(output.get(0).getEventResult(Events.DISCUS_THROW) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.POLE_VAULT) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.JAVELIN_THROW) == Double.valueOf(fieldPerf));
		assertTrue(output.get(0).getEventResult(Events.RACE_1500M) == Converter.stringToTime(trackPerf));
	}

}
