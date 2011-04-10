package net.azib.java.students.t110013.hometask3;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Vadim
 */
public class WordFrequencyCalculatorImplTest {
	WordFrequencyCalculatorImpl wfc = new WordFrequencyCalculatorImpl();
	Map<String, Integer> expectedMap = new TreeMap<String, Integer>();

	@Test(expected = NullPointerException.class)
	public void nullArgument() {
		wfc.calculateFrequenciesOf(null);
	}

	@Test
	public void emptyStringArgument() {
		expectedMap = Collections.emptyMap();
		assertThat(wfc.calculateFrequenciesOf(""), is(expectedMap));
	}

	@Test
	public void wordFrequenciesInAlphabeticalOrder() {
		expectedMap.put("and", 3);
		expectedMap.put("a", 1);
		expectedMap.put("or", 2);
		expectedMap.put("the", 1);
		assertThat(wfc.calculateFrequenciesOf("the or a and and or and"), is(expectedMap));
	}
}
