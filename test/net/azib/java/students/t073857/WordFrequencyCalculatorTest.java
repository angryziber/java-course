package net.azib.java.students.t073857;

import net.azib.java.students.t073857.hw3.WordFrequencyCalculatorImpl;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.Set;


/**
 * WordFrequencyCalculatorTest
 *
 * @author Joonas Vali
 */
public class WordFrequencyCalculatorTest {
	@Test
	public void testOverall() throws Exception {
		String s = "a a b b a c c a a b b a\na b a b bb b a a aa a\na\nb";
		Set<Map.Entry<String, Integer>> entry = new WordFrequencyCalculatorImpl().calculateFrequenciesOf(s).entrySet();		
		assertEquals("Entry: ", "[a=12, aa=1, b=8, bb=1, c=2]", entry.toString());		
	}
}
