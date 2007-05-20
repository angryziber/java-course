package net.azib.java.students.t020632.homework;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestConsoleInput is a test class for ConsoleInput class
 *
 * @author Marek Soobik t020632
 */
public class TestConsoleInput {

	ConsoleInput input;
	List<AthleteResults> results;
	
	@Before
	public void setUp() throws Exception {
		input = new ConsoleInput();
		results = new ArrayList<AthleteResults>();
	}
	
	
	/**
	 * Method parseLine() is tested. Both valid and invalid input string 
	 * for parseLine() are tested.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testParseLine() throws Exception {
		String correctLine = 	"Romain Barras,29.02.1982,ZA,  11.42, 7.18,  14.89, 2.00, 48.80, 14.49,  42.67, 4.62, 63.07, 4:26.77";
		String incorrectLine = 	"Romain Barras 29.02.1982,ZA,  11.42, 7.18,  14.89, 2.00, 48.80, 14.49,  42.67, 4.62, 63.07, 4:26.77";
		
		assertTrue(input.parseLine(correctLine, results));
		assertFalse(input.parseLine(incorrectLine, results));
	}


	@After
	public void tearDown() throws Exception {
		input = null;
		results = null;
	}

}
