package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * @author dionis
 *         6/5/11 4:02 AM
 */
public class ParamsParserTest {

	@Test
	public void itIsAvailableToHaveDuplicateKeys() {
		ParamsParser paramsParser = new ParamsParser("-key1", "-key2", "-key1", "-key3");
		assertThat(paramsParser.getKeys().size(), is(4));
	}

	@Test
	public void keyOrderIsTheSame() {
		ParamsParser parser = new ParamsParser("-key2", "-key1", "-key3");
		assertThat(parser.getKeys().size(), is(3));
		List<String> keys = new ArrayList<String>();
		for (String key : parser.getKeys()) {
			keys.add(key);
		}
		assertThat(keys.get(0), equalTo("-key2"));
		assertThat(keys.get(1), equalTo("-key1"));
		assertThat(keys.get(2), equalTo("-key3"));
	}

	@Test
	public void keysStartWithMinusSignAndIfNoKeyIsProvidedThenAllOtherShouldBeIgnored() {
		assertTrue(new ParamsParser("a", "b", "c").getKeys().isEmpty());
	}

	@Test
	public void noParamsMeansNoParams() {
		assertTrue(new ParamsParser().getKeys().isEmpty());
	}

	@Test
	public void paramsParserExample() {
		Map<String, List<String>> expected = new HashMap<String, List<String>>();
		expected.put("-key1", new ArrayList<String>(Arrays.asList("param1", "param2")));
		expected.put("-key2", new ArrayList<String>(Arrays.asList("param3", "param4", "param5")));
		expected.put("-key3", new ArrayList<String>(Arrays.asList("param6", "param7")));
		ParamsParser paramsParser = new ParamsParser("-key1", "param1", "param2", "-key2",
				"param3", "param4", "param5", "-key3", "param6", "param7");
		assertThat(paramsParser.getKeys().get(0), is("-key1"));
		assertTrue(paramsParser.getValues().get(0).contains("param1") && paramsParser.getValues().get(0).contains("param2"));
		assertThat(paramsParser.getKeys().get(1), is("-key2"));
		assertTrue(paramsParser.getValues().get(1).contains("param3") && paramsParser.getValues().get(1).contains("param4")
				&& paramsParser.getValues().get(1).contains("param5"));
		assertThat(paramsParser.getKeys().get(2), is("-key3"));
		assertTrue(paramsParser.getValues().get(2).contains("param6") && paramsParser.getValues().get(2).contains("param7"));
	}
}
