package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

/**
 * @author dionis
 *         5/29/1110:35 PM
 */
public class ConsoleLoaderTest {
	ConsoleLoader loader = new ConsoleLoader();

	@Test
	public void exceptionWillBeThrownIfNotNumericWillBeEntered() {
		loader.in = new ByteArrayInputStream("hello".getBytes());
		try {
			loader.getDoubleFromInputStream();
		} catch (Exception e) {
			assertFalse(e instanceof StopLoadingAthletesException);
			assertFalse(e instanceof SkipLoadingAthleteException);
			assertTrue(e != null);
		}
	}

	@Test
	public void parseMinuteSecondsMilliseconds() throws StopLoadingAthletesException, ParseException, SkipLoadingAthleteException {
		for (Map.Entry<String, String> valToParseAndExpected : exampleMapOfResultsMinutesSecondsMillis().entrySet()) {
			String valueToParse = valToParseAndExpected.getKey();
			Double expectedValue = Double.valueOf(valToParseAndExpected.getValue());
			loader.in = new ByteArrayInputStream(valueToParse.getBytes());
			assertThat(loader.parseMinutesAndSecondsAndMillisFromInputStream(), equalTo(expectedValue));
		}
	}

	private Map<String, String> exampleMapOfResultsMinutesSecondsMillis() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("0:04.7", "4.7");
		map.put("1:04.720", "64.72");
		map.put("1:04.7", "64.7");
		map.put("1:04.007", "64.007");
		map.put("1:04.72", "64.72");
		map.put("6:50.76", "410.76");
		return map;
	}

	@Test
	public void minuteSecondsMilliseconds() throws StopLoadingAthletesException, ParseException, SkipLoadingAthleteException {
		for (Map.Entry<String, String> valToParseAndExpected : exampleMapOfResultsSecondsMillis().entrySet()) {
			String valueToParse = valToParseAndExpected.getKey();
			Double expectedValue = Double.valueOf(valToParseAndExpected.getValue());
			loader.in = new ByteArrayInputStream(valueToParse.getBytes());
			assertThat(loader.parseSecondsAndMillisFromInputStream(), equalTo(expectedValue));
		}
	}

	private Map<String, String> exampleMapOfResultsSecondsMillis() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("04.7", "4.7");
		map.put("4.720", "4.72");
		map.put("4.7", "4.7");
		map.put("04.007", "4.007");
		map.put("04.72", "4.72");
		map.put("50.76", "50.76");
		return map;
	}
}
