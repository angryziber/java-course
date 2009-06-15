package net.azib.java.students.t050545.homework.loaders;

import net.azib.java.students.t050545.homework.utils.LoadException;
import net.azib.java.students.t050545.homework.utils.ReadException;

import org.junit.Ignore;
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
public class CSVloadTest {
	
	
	@Test @Ignore
	public void testGetArg() throws LoadException{
		AthleteLoader loader = new CSVLoader();
		Stack<String> stack = new Stack<String>();
		stack.add(CSVloadTest.class.getResource("sport_utf8.txt").getPath());
		loader.init(stack);
		assertEquals("-csv", loader.getArgum());
		loader.close();
	}
	
	@Test  @Ignore
	public void testGetAthlete() throws LoadException, ReadException, ParseException, IOException{
		AthleteLoader loader = new CSVLoader();
		Stack<String> stack = new Stack<String>();

		stack.add(CSVloadTest.class.getResource("sport_utf8.txt").getFile());
		loader.init(stack);
		loader.nextAthleteScore();
		assertEquals("Beata Kana1", loader.nextAthleteScore().getPerson().getName());
		assertEquals("HU", loader.nextAthleteScore().getPerson().getCountry());
		assertEquals("Василий Пупкин1", loader.nextAthleteScore().getPerson().getName());
		loader.close();
	}

}
