package net.azib.java.students.t020543.homework;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test for a {@link StringConvertor} class
 * @author t020543
 */
public class StringConvertorTest {

	private IStringConvertor sc;
	private IAthlete man;
	private String input = "\"Beata Kana\",29.02.1982,ZA,13.04,4.53,7.79,1.55,1:04.72,18.74,24.20,2.40,28.20,6:50.76";
	
	/**
	 * Sets up needed data
	 */
	@Before
	public void setUp() {
		sc = new StringConvertor();	
		man = new Athlete();	
	}
	
	/**
	 * Test <i>toAthlete()</i> method with a particular input
	 * @author t020543
	 */
	@Test
	public void testStringConvertor(){
		try {
			assertTrue(sc.toAthlete(input, man).getScore() == 3205); 
			System.out.println("TEST: StringConvertor class => OK");
		}
		catch(AssertionError e){
			System.out.println("ERROR! StringConvertor class test => FAILED!");
		}
	}
	
}
