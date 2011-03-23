package net.azib.java.students.t092861;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import java.util.Map;
import java.util.TreeMap;
import net.azib.java.students.t092861.lecture4.WordFrequencyCalculatorImpl;
import org.junit.Test;

/**
 * @author Stanislav / 092861
 * 
 */
public class WordFrequencyCalculatorImplTest {
	WordFrequencyCalculatorImpl wci = new WordFrequencyCalculatorImpl();
	Map<String, Integer> map;

	@Test
	public void calculateFrequenciesOfWordsInText() {
		map = new TreeMap<String, Integer>();
		map.put("text1", 2);
		map.put("text13", 1);
		map.put("text3", 2);
		assertThat(wci.calculateFrequenciesOf("text3? text1, text1 text13! text3."), is(map));
	}
	
	@Test
	public void calculateFrequenciesOfWordsInEmptyString() {
		map = new TreeMap<String, Integer>();
		assertThat(wci.calculateFrequenciesOf(""), is(map));
	}
}
