package net.azib.java.students.t050545.homework.writer;

import net.azib.java.students.t050545.homework.loaders.AthleteLoader;
import net.azib.java.students.t050545.homework.loaders.CSVLoader;
import net.azib.java.students.t050545.homework.loaders.CSVloadTest;
import net.azib.java.students.t050545.homework.sport.AthleteScore;
import net.azib.java.students.t050545.homework.sport.Competition;
import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;
import net.azib.java.students.t050545.homework.utils.WriteException;
import net.azib.java.students.t050545.homework.writers.AthleteWriter;
import net.azib.java.students.t050545.homework.writers.CSVWriter;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Stack;

/**
 * CSVWriter
 *
 * @author libricon
 */
public class CSVWriterTest {

	@Test
	public void testPrintResult() throws LoadException, WriteException, ReadException, ParseException, URISyntaxException, IOException{
		AthleteLoader loader = new CSVLoader();
		AthleteWriter writer = new CSVWriter();
		Stack<String> stack = new Stack<String>();
	    stack.add(CSVWriterTest.class.getResource(".").getFile().replace('/', File.separatorChar).substring(1)+"sportout.txt");	
		stack.add(CSVloadTest.class.getResource("sport_utf8.txt").getFile().replace('/', File.separatorChar).substring(1));
		loader.init(stack);
		writer.init(stack);
		AthleteScore sportman = null;
		Competition comp = new Competition();
		
		while ((sportman = loader.nextAthleteScore()) != null) {
			comp.addCompetitor(sportman);
		}
		writer.printResultTable(comp);
		writer.close();
		
		BufferedReader reader = new BufferedReader(new FileReader(new File(CSVWriterTest.class.getResource("sportout.txt").toURI())));
		reader.readLine();
		assertEquals("[1],Василий Пупкин3,UA,10001", reader.readLine());
		reader.readLine();reader.readLine();reader.readLine();reader.readLine();
		assertEquals("[5-7],Szőrös Szűk2,HU,3499", reader.readLine());
		
	}
}
