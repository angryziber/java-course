package net.azib.java.students.t092855.lecture4;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class WordFrequencyCalculatorImplTest {
	private Map <String, Integer> map = new TreeMap<String, Integer>();


	@Test
	public void stringWithOneWord() {
		map.put("aaa", 1);

		assertEquals(map, new WordFrequencyCalculatorImpl().calculateFrequenciesOf("aaa"));
	}

	@Test
	public void emptyString() {
		map.put("", 1);
		assertThat(new WordFrequencyCalculatorImpl().calculateFrequenciesOf(""), is(map));
	}

	@Test
	public void stringWithManyWords() {
		String string = "aaa bbb ccc aaa bbb aaa";
		map.put("aaa", 3);
		map.put("bbb", 2);
		map.put("ccc", 1);

		assertThat(new WordFrequencyCalculatorImpl().calculateFrequenciesOf(string), is(map));
	}

}
