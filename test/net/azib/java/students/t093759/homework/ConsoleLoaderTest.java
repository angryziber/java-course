package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.io.*;

import static org.apache.commons.io.FileUtils.readFileToString;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         5/29/1110:35 PM
 */
public class ConsoleLoaderTest {
	@Test
	public void consoleLoadingExample() throws IOException, StopLoadingAthletesException, SkipLoadingAthleteException {
		ConsoleLoader loader = new ConsoleLoader();
		loader.in = new ByteArrayInputStream(readFileToString(new File(getClass().getResource("input.console").getFile()), "UTF-8").getBytes("UTF-8"));
		loader.err = new PrintStream(new ByteArrayOutputStream());
		loader.out = loader.err;
		loader.localizedPatternOfDateOfBirth = "dd.MM.yyyy";
		assertThat(loader.load().size(), is(4));
	}
}
