package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         6/1/114:10 PM
 */
public class ConsoleOutputTest extends AthleteOutputTest {

	@Test
	public void outputExample() {
		ConsoleOutput consoleOutput = new ConsoleOutput();
		consoleOutput.out = new ByteArrayOutputStream();
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		consoleOutput.output(athletes);
		assertThat(consoleOutput.out.toString(), is(someBasicOutputString()));
	}

	@Override
	String someBasicOutputString() {
		try {
			return loadFile(getClass(), "output.console");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
