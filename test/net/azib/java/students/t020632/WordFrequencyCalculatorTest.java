package net.azib.java.students.t020632;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.Map;


/**
 * WordFrequencyCalculatorTest
 *
 * @author Marek
 */
public class WordFrequencyCalculatorTest {

	/**
	 * @throws java.lang.Exception
	 */
	private WordFrequencyCalculator c;
	
	@Before
	public void setUp() throws Exception {
		c = new WordFrequencyCalculator();
	}
	
	
	@Test
	public void testStringCount(){
		String s = "ss ggg dd ss t";
		String [] t = new String [] {"dd", "ggg", "ss", "t"};
		int [] a = new int [] {1, 1, 2, 1};
		int i = 0;
		
		Map map = c.countStrings(s);
		
		Set set = map.keySet();
		
		Iterator it = set.iterator();
		
		while(it.hasNext()){
			String k = (String)it.next();
			assertEquals(t[i], k);
			assertEquals(a[i], map.get(k));
			i++;
		}
		
		
		
	}
	
	

}
