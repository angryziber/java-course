package net.azib.java.students.t092877.homework;

import net.azib.java.students.t092877.homework.io.CsvFileOutputStrategy;
import net.azib.java.students.t092877.homework.model.Athlete;
import net.azib.java.students.t092877.homework.model.Event;
import net.azib.java.students.t092877.homework.model.Result;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.CharArrayWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 * Units tests for CsvFileOutputStrategy
 * User: Artjom Kruglenkov
 * Date: 24.05.2011
 */
public class CsvFileOutputStrategyTest {

	public static CsvFileOutputStrategy csvFileOutputStrategy;
	public static Athlete athlete;

	@BeforeClass
	public static void beforeClass() {
		csvFileOutputStrategy = new CsvFileOutputStrategy();

		athlete = new Athlete("Erki Nool", "1970-06-25", "EE");

		double[] results = new double[] { 10.62, 807, 16.57, 200, 47.74, 13.80, 45.51, 500, 68.53, 275.13 };
		List<Result> resultsList = new ArrayList<Result>();

		int i = 0;
		for (Event event : Event.values()) {
			resultsList.add(new Result(event, results[i]));
			i++;
		}

		athlete.setResults(resultsList);
		athlete.setPlace("1");
	}

	@Test
	public void testGetAthleteDataAsStr() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		Method method = CsvFileOutputStrategy.class.getDeclaredMethod("getAthleteDataAsStr", Athlete.class);
		method.setAccessible(true);

		String athleteDataAsStr = (String)method.invoke(csvFileOutputStrategy, athlete);
		assertThat(athleteDataAsStr,
				is("1,8902,\"Erki Nool\",25.06.1970,EE,10.62,8.07,16.57,2.0,47.74,13.8,45.51,5.0,68.53,4:35.13" +
						System.getProperty("line.separator")));
	}

	@Test
	public void testWriteToFile() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

		String line = "1,8902,\"Erki Nool\",25.06.1970,EE,10.62,8.07,16.57,2.0,47.74,13.8,45.51,5.0,68.53,4:35.13";

		StringBuilder expectedStr = new StringBuilder(line);

		CharArrayWriter bw = new CharArrayWriter();

		Method method = CsvFileOutputStrategy.class.getDeclaredMethod("writeToFile", Writer.class, String.class);
		method.setAccessible(true);

		method.invoke(csvFileOutputStrategy, bw, line);
		assertEquals(expectedStr.toString(), bw.toString());
	}
}
