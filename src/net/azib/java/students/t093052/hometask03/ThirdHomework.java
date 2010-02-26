package net.azib.java.students.t093052.hometask03;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.TreeMap;

import org.junit.Test;

/**
 * ThirdHomework
 *
 * @author Kostja
 */
public class ThirdHomework {
	private static final String[] DUPL_DATA = { 
		"xxx", "ddd", "aaa", "xxx", "aaa", "xxx", 
		"bbb", "xxx", "aaa", "bbb", "aaa", "xxx" };
	
	private static final String FREQ_DATA = 
		"xxx ddd aaa xxx aaa xxx bbb xxx aaa bbb aaa xxx";
	
	@Test
	public void duplicateRemoverTest() throws Exception {
		assertArrayEquals(new String[] { "xxx", "ddd", "aaa", "bbb" }, 
				new DuplicateRemoverImpl().removeDuplicateStrings(DUPL_DATA));
	}
	
	@Test
	public void calculateFrequenciesTest() throws Exception {
		assertEquals(new TreeMap<String, Integer>() {{
			put("aaa", 4);
			put("bbb", 2);
			put("ddd", 1);
			put("xxx", 5);
		}}, new WordFrequencyCalculatorImpl().calculateFrequenciesOf(FREQ_DATA));
	}
	
}
