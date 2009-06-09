package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.loaders.CSVLoader;
import net.azib.java.students.t050545.homework.loaders.CSVLoaderTest;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.sport.Places;
import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;
import net.azib.java.students.t050545.homework.utils.WriteException;
import net.azib.java.students.t050545.homework.writers.AthleteWriter;
import net.azib.java.students.t050545.homework.writers.ConsoleWriter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Stack;

/**
 * CSVWriter
 *
 * @author libricon
 */
public class ConsoleWriterTest {

	@Test
	public void testPrintResult() throws LoadException, WriteException, ReadException, ParseException, URISyntaxException, IOException{
		AthleteLoader loader = new CSVLoader();
		AthleteWriter writer = new ConsoleWriter();
		Stack<String> stack = new Stack<String>();
	    stack.add(CSVLoaderTest.class.getResource("sportin.txt").getFile().replace('/', File.separatorChar).substring(1));
		loader.init(stack);
		writer.init(stack);
		AthleteScore sportman = null;
		Competition comp = new Competition();
		
		sportman = loader.nextAthleteScore();
		System.out.println(sportman);
		Places places = new Places("1", sportman);
	    comp.addCompetitor(sportman);
	    System.out.println();
	    
		assertEquals(places.toString(), comp.getPlaces()[0].toString());
		
	}
}
