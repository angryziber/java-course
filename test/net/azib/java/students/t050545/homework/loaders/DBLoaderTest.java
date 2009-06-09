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
public class DBLoaderTest {
	
	private AthleteLoader initLoader() throws LoadException{
		AthleteLoader loader = new DBLoader();
		Stack<String> stack = new Stack<String>();
		stack.add("1");
		loader.init(stack);
		return loader;
	}
	
	
	@Test
	public void testGetAthlete() throws LoadException, ReadException, ParseException, IOException{
		AthleteLoader loader = initLoader();
		assertEquals("Erki Nool", loader.nextAthleteScore().getPerson().getName());
	}

}
