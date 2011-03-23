package net.azib.java.students.t093759.hometasks.fifth;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         23.03.11 13:39
 */
public class WordFrequencyCalculatorImplTest {
	@Test
	public void everyWordAppearsOnlyOnce() {
		String text = "dog cat etc";
		Map<String, Integer> correctWordFrequencies = new TreeMap<String, Integer>();
		correctWordFrequencies.put("dog", 1);
		correctWordFrequencies.put("cat", 1);
		correctWordFrequencies.put("etc", 1);

		Map<String, Integer> wordFrequencies = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text);

		assertThat(wordFrequencies, equalTo(correctWordFrequencies));
	}

	@Test
	public void someWordsAppearsMoreThanOnce() {
		String text = "dog cat dog";
		Map<String, Integer> correctWordFrequencies = new TreeMap<String, Integer>();
		correctWordFrequencies.put("dog", 2);
		correctWordFrequencies.put("cat", 1);

		Map<String, Integer> wordFrequencies = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text);

		assertThat(wordFrequencies, equalTo(correctWordFrequencies));
	}

	@Test
	public void orderOfWordsIsInAlphabeticalOrder() {
		String text = "dog cat dog";

		String[] wordsInCorrectOrder = {"cat", "dog"};

		Map<String, Integer> stringIntegerMap = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text);
		String[] words = stringIntegerMap.keySet().toArray(new String[stringIntegerMap.size()]);

		assertThat(words, equalTo(wordsInCorrectOrder));
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCountWordsFromNull() {
		new WordFrequencyCalculatorImpl().calculateFrequenciesOf(null);
	}
}
