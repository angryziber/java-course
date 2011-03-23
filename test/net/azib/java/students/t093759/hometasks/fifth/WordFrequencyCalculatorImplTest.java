package net.azib.java.students.t093759.hometasks.fifth;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         23.03.11 13:39
 */
public class WordFrequencyCalculatorImplTest {
	@Test
	public void everyWordAppearsOnlyOnce() {
		String text = "dog cat etc";
		Map<String, Integer> wordsFrequencies = new TreeMap<String, Integer>();
		wordsFrequencies.put("dog", 1);
		wordsFrequencies.put("cat", 1);
		wordsFrequencies.put("etc", 1);

		assertThat(new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text), is(wordsFrequencies));
	}

	@Test
	public void someWordsAppearsMoreThanOnce() {
		String text = "dog cat dog";
		Map<String, Integer> wordsFrequencies = new TreeMap<String, Integer>();
		wordsFrequencies.put("dog", 2);
		wordsFrequencies.put("cat", 1);

		assertThat(new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text), is(wordsFrequencies));
	}

	@Test
	public void orderOfWordsIsInAlphabeticalOrder() {
		String text = "dog cat dog";

		String[] wordsInRightOrder = {"cat", "dog"};

		Map<String, Integer> stringIntegerMap = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(text);
		String[] words = stringIntegerMap.keySet().toArray(new String[stringIntegerMap.size()]);
		assertThat(words, is(wordsInRightOrder));
	}
}
