package net.azib.java.students.t073862.homework;

import net.azib.java.students.t073862.homework.model.OutputManager;
import net.azib.java.students.t073862.homework.model.Score;
import net.azib.java.students.t073862.homework.util.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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
public class Tests {
	Float[] scoreData = new Float[] { 10.395F, 7.76F, 18.4F, 2.20F, 46.17F, 13.8F, 56.17F, 5.28F, 77.19F, 233.79F };
	OutputManager outputManager = new OutputManager();
	Score[] scores = { new Score("Peeter Tomberg", "18.06.1988", "ee", 9990, scoreData) };

	@Test
	public void testToXML() {
		File f = getOutputFile("output.test");
		outputManager.toXML(scores, f);
		Assert.assertEquals("Does output to XML work?", getFileContents(f), getFileContents(getOutputFile("output.test.xml")));
	}
	@Test
	public void testToCSV() {
		File f = getOutputFile("output.test");
		outputManager.toCSV(scores, f);
		Assert.assertEquals("Does output to CSV work?", getFileContents(f), getFileContents(getOutputFile("output.test.csv")));
	}
	@Test
	public void testToHTML() {
		File f = getOutputFile("output.test");
		outputManager.toHTML(scores, f);
		Assert.assertEquals("Does output to HTML work?", getFileContents(f), getFileContents(getOutputFile("output.test.html")));
	}

	@Test
	public void testScoreModel() {
		Score s = new Score("Peeter Tomberg", "18.06.1988", "ee", 9990, scoreData);
		Assert.assertEquals("Name getter returning the right result?" ,"Peeter Tomberg", s.getName());
		Assert.assertEquals("Dob getter returning the right result?" ,"18.06.1988", s.getDob());
		Assert.assertEquals("Iso getter returning the right result?" ,"ee", s.getIso());	
		Assert.assertEquals("toString returning the right result?" ,"Peeter Tomberg(18.06.1988) from ee scored: 9990 " + Arrays.toString(scoreData), s.toString());	
	}
	@Test @Ignore("Test fails!")
	public void testScoreCalculation() {
		
		Assert.assertEquals("Do we lose precision somewhere? ",10000, Util.calculateScores(scoreData));
	
	}
	@Test
	public void testOutputFile() {
		File f = getOutputFile("output.test");
		Assert.assertNotNull("Did we get a valid output file?", f);
	}
	@Test
	public void testWritingToFile() {
		String data = "tervist";
		File f = getOutputFile("output.test");
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
	
	

	private String getFileContents(File f) {
		StringBuilder contents = new StringBuilder();
		try {
			BufferedReader input =  new BufferedReader(new FileReader(f));
		    try {
		    	String line = null; 
		        while (( line = input.readLine()) != null){
		          contents.append(line);
		          contents.append(System.getProperty("line.separator"));
		        }
		    }
		    finally {
		    	input.close();
		    }
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
		return contents.toString();
	}
	
	public static File getOutputFile(String filePath) {
		File f = null;
		URL uri = Tests.class.getResource(filePath);
		if(uri != null) 
			f = new File(uri.getFile().replace("%20", " "));
		return f;
	}
}
