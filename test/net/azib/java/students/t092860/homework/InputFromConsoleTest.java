package net.azib.java.students.t092860.homework;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * InputFromConsoleTest
 *
 * @author armin
 */
public class InputFromConsoleTest {

	/**
	 * Test method for {@link net.azib.java.students.t092860.homework.InputFromConsole#get()}.
	 */
	@Test
	public final void testGet() {
		InputStreamMock inputMock = new InputStreamMock();
		InputFromConsole testObj = new InputFromConsole(inputMock);
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

		try {
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
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
