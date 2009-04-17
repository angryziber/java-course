package net.azib.java.students.t090437;

import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * WordFreqImplTest
 *
 * @author Ronald
 */
public class WordFreqImplTest {
	@Test
	public void simpleCounting() {
		MyWordFrequencyCalculator myFreqC = new MyWordFrequencyCalculator();
		
		Map<String, Integer> wFreq = myFreqC.calculateFrequenciesOf("tere tere vana kere");
		
		for (Map.Entry e : wFreq.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
			if(e.getKey().equals("tere")) {
				assertTrue("simple counting failed!", e.getValue().equals(new Integer(2)));
			}
		}
	}

}
