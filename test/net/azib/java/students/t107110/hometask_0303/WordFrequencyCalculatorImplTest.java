package net.azib.java.students.t107110.hometask_0303;

import org.junit.Test;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Eduard Shustrov
 */
public class WordFrequencyCalculatorImplTest {
	private final WordFrequencyCalculatorImpl calculator = new WordFrequencyCalculatorImpl();

	@Test
	public void nullText() {
		final Map<String, Integer> nullWords = null;
		assertThat(wordOccurrences(null), is(nullWords));
	}

	@Test
	public void emptyText() {
		final Map<String, Integer> noWords = Collections.emptyMap();
		assertThat(wordOccurrences(""), are(noWords));
	}

	@Test
	public void oneWordOnce() {
		final Map<String, Integer> oneWordOnce = newMap();
		oneWordOnce.put("one", 1);

		assertThat(wordOccurrences("one"), are(oneWordOnce));
	}

	@Test
	public void oneWordTwice() {
		final Map<String, Integer> oneWordTwice = newMap();
		oneWordTwice.put("one", 2);

		assertThat(wordOccurrences("one one"), are(oneWordTwice));
	}

	@Test
	public void oneWordTwiceAnotherOnce() {
		final Map<String, Integer> oneWordTwiceAnotherOnce = newMap();
		oneWordTwiceAnotherOnce.put("one", 2);
		oneWordTwiceAnotherOnce.put("two", 1);

		assertThat(wordOccurrences("one two one"), are(oneWordTwiceAnotherOnce));
	}

	private static Map<String, Integer> newMap() {
		return new LinkedHashMap<String, Integer>();
	}

	private Map<String, Integer> wordOccurrences(final String text) {
		return calculator.calculateFrequenciesOf(text);
	}

	private static <T> org.hamcrest.Matcher<T> are(T value) {
		return is(value);
	}
}
