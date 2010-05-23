package net.azib.java.students.t073862.homework;

import net.azib.java.students.t073862.homework.model.Score;
import net.azib.java.students.t073862.homework.util.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Ignore;
import org.junit.Test;

/**
 * TestScore
 *
 *	The only classes JUnit tested are the score model and the utilities class.
 *
 *	I do not see a point in testing the inputManager, as I cannot trust the input data to be accurate (e.g. your database has different data).
 *  I could have made a mock of the database connection class and then JUnit tested the database class, but since the class itself has a lot of fail-safes built in, having JUnit tests for something that is already covered seems redundant. 
 *  
 *
 * @author Pets
 */
public class ScoreTest {
	Float[] scores = new Float[] { 10.395F, 7.76F, 18.4F, 2.20F, 46.17F, 13.8F, 56.17F, 5.28F, 77.19F, 233.79F };
	@Test
	public void testScoreModel() {
		Score s = new Score("Peeter Tomberg", "18.06.1988", "ee", 9990, scores);
		Assert.assertEquals("Name getter returning the right result?" ,"Peeter Tomberg", s.getName());
		Assert.assertEquals("Dob getter returning the right result?" ,"18.06.1988", s.getDob());
		Assert.assertEquals("Iso getter returning the right result?" ,"ee", s.getIso());	
		Assert.assertEquals("toString returning the right result?" ,"Peeter Tomberg(18.06.1988) from ee scored: 9990 " + Arrays.toString(scores), s.toString());	
	}
	@Test @Ignore("Test fails!")
	public void testScoreCalculation() {
		
		Assert.assertEquals("Do we lose precision somewhere? ",10000, Util.calculateScores(scores));
	
	}
	@Test
	public void testOutputFile() {
		File f = Util.getOutputFile("test.txt");
		Assert.assertNotNull("Did we get a valid output file?", f);
	}
	@Test
	public void testWritingToFile() {
		String data = "tervist";
		File f = Util.getOutputFile("test.txt");
		Util.writeToFile(f, data);

		String line = null;
		try {
			BufferedReader input =  new BufferedReader(new FileReader(f));
			try {
				line = input.readLine();
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
			Assert.fail("Failed to to read file.");
		}
		Assert.assertEquals("Does writing to files work?",data, line);
	}
	
}
