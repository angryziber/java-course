package net.azib.java.students.t092859.hometask4;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

/**
 * WordFrequencyCalculatorImplTest
 *
 * @author kostya
 */
public class WordFrequencyCalculatorImplTest {
	WordFrequencyCalculatorImpl calculator = new WordFrequencyCalculatorImpl();
	
	@Test
	public void wordFrequencyCalculation() throws Exception {
		String text = "Word frequency calculator determines frequency of occurence of each word";
		Map<String, Integer> freqMap = calculator.calculateFrequenciesOf(text);
		
		assertEquals((Integer)2, freqMap.get("word"));
		assertEquals((Integer)2, freqMap.get("frequency"));
		assertEquals((Integer)1, freqMap.get("calculator"));
		assertEquals((Integer)1, freqMap.get("determines"));
		assertEquals((Integer)2, freqMap.get("of"));
		assertEquals((Integer)1, freqMap.get("occurence"));
		assertEquals((Integer)1, freqMap.get("each"));
		
	}

}
