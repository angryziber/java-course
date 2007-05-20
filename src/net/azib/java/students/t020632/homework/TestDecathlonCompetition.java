package net.azib.java.students.t020632.homework;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * TestDecathlonCompetition is a test class for DecathlonCompetition
 *
 * @author Marek Soobik t020632
 */
public class TestDecathlonCompetition {

	DecathlonCompetition competition;
	List<AthleteResults> results;
	Input input;
	Output output;
	
	
	String in = "C:/input.csv";
	String out = "C:/results.xsl";
	
	@Before
	public void setUp() throws Exception {
		input = new CSVInput(in);
		output = new HTMLOutput(out);
		competition = new DecathlonCompetition(input, output);
	}
	
	
	/**
	 * Tests whether sorting athletes works correctly
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSort() throws Exception {
		results = competition.readResults();
		
		if(results == null)
			return;
		
		competition.calculateResults();
		competition.sortAthletes();
		competition.setAthletePositions();
		competition.writeResults();
		assertEquals(results.get(0).getName(), "Laurent Hernu");
	}

	
	@After
	public void tearDown() throws Exception {
		competition = null;
		input = null;
		output = null;
	}

}
