package net.azib.java.students.t093759.homework;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         6/1/114:10 PM
 */
public class ConsoleOutputTest extends AthleteOutputTest {
	@Test(expected = IllegalArgumentException.class)
	public void exactlyOneAdditionalParamShouldBeProvided() {
		new ConsoleOutput().output(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void additionalParamShouldBeString() {
		new ConsoleOutput().output(null, 12);
	}

	@Test
	public void builtStringExample() {
		ConsoleOutput consoleOutput = new ConsoleOutput();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		consoleOutput.out = new PrintStream(out);
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		consoleOutput.output(athletes);
		assertThat(out.toString(), is(someBasicOutputString()));
	}

	@Test
	public void consoleOutputExample() {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		String result = new ConsoleOutput().buildStringForAllAthletes(athletes);
	}

	String someBasicOutputString() {
		return "1,200.0,\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75"
				+ System.getProperty("line.separator") +
				"2,100.0,\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";
	}
}
