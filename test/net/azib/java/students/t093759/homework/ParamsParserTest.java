package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author dionis
 *         6/5/11 4:02 AM
 */
public class ParamsParserTest {
	@Test
	public void paramsParserIsSingleton() {
		assertTrue(ParamsParser.getInstance() == ParamsParser.getInstance());
	}

	@Test
	public void duplicateKeysWillBeIgnoredAndTheirParamWillBeAppendedToExistingKey() {
		Map<String, List<String>> parsedKeys = ParamsParser.getInstance().parse("-key1", "-key2", "-key1", "-key3");
		assertThat(parsedKeys.size(), is(3));
		assertTrue(parsedKeys.containsKey("-key1"));
		assertTrue(parsedKeys.containsKey("-key2"));
		assertTrue(parsedKeys.containsKey("-key3"));
	}

	@Test
	public void keyOrderIsTheSame() {
		Map<String, List<String>> parsedKeys = ParamsParser.getInstance().parse("-key2", "-key1", "-key3");
		assertThat(parsedKeys.size(), is(3));
		List<String> keys = new ArrayList<String>();
		for (String key : parsedKeys.keySet()) {
			keys.add(key);
		}
		assertThat(keys.get(0),equalTo("-key2"));
		assertThat(keys.get(1),equalTo("-key1"));
		assertThat(keys.get(2),equalTo("-key3"));
	}

	@Test
	public void keysStartWithMinusSignAndIfNoKeyIsProvidedThenAllOtherShouldBeIgnored() {
		assertThat(ParamsParser.getInstance().parse("a","b","c").size(),is(0));
	}

	@Test
	public void noParamsMeansNoParams() {
		assertTrue(ParamsParser.getInstance().parse().isEmpty());
	}

	@Test
	public void paramsParserExample() {
		Map<String, List<String>> expected = new HashMap<String, List<String>>();
		expected.put("-key1", new ArrayList<String>(Arrays.asList("param1", "param2")));
		expected.put("-key2", new ArrayList<String>(Arrays.asList("param3", "param4", "param5")));
		expected.put("-key3", new ArrayList<String>(Arrays.asList("param6", "param7")));
		assertMapEquals(expected, ParamsParser.getInstance().parse("-key1", "param1", "param2", "-key2",
				"param3", "param4", "param5", "-key3", "param6", "param7"));
	}

	private void assertMapEquals(Map<String, List<String>> expected, Map<String, List<String>> actual) {
		for (Map.Entry<String, List<String>> expectedEntry : expected.entrySet()) {
			assertTrue(actual.containsKey(expectedEntry.getKey()));
			List<String> actuals = actual.get(expectedEntry.getKey());
			List<String> expecteds = expectedEntry.getValue();
			String[] actualArr = new String[actuals.size()];
			String[] expectedArr = new String[expecteds.size()];
			assertArrayEquals(expecteds.toArray(expectedArr), actuals.toArray(actualArr));
		}
	}
}
