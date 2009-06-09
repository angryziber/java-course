package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Stack;

/**
 * CSVLoaderTest
 *
 * @author libricon
 */
public class CSVLoaderTest {
	
	private AthleteLoader initLoader() throws LoadException{
		AthleteLoader loader = new CSVLoader();
		Stack<String> stack = new Stack<String>();
		stack.add("-csv");
		stack.add(CSVLoaderTest.class.getResource("sportin.txt").getFile().replace('/', File.separatorChar).substring(1));
		loader.init(stack);
		return loader;
	}
	
	
	
	@Test
	public void testGetArg() throws LoadException{
		AthleteLoader loader = initLoader();
		assertEquals("-csv", loader.getArgum());
	}
	
	@Test
	public void testGetAthlete() throws LoadException, ReadException, ParseException, IOException{
		AthleteLoader loader = initLoader();
		loader.nextAthleteScore();
		assertEquals("Beata Kana1", loader.nextAthleteScore().getPerson().getName());
		assertEquals("HU", loader.nextAthleteScore().getPerson().getCountry());
		assertEquals("Василий Пупкин1", loader.nextAthleteScore().getPerson().getName());
	}

}
