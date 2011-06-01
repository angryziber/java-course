package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author dionis
 *         5/31/1112:56 AM
 */
public class CSVOutputTest extends AthleteOutputTest{

	@Test(expected = IllegalArgumentException.class)
	public void exactlyOneAdditionalParamShouldBeProvided() {
		new CSVOutput().output(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void additionalParamShouldBeString() {
		new CSVOutput().output(null, 12);
	}

	@Test
	public void csvExample() throws IOException {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		File tempFile = tempFile();

		new CSVOutput().output(athletes,tempFile.getCanonicalPath());
		assertThat(FileUtils.readFileToString(tempFile),equalTo(someBasicOutputString()));
	}

	@Override
	String someBasicOutputString() {
		return "\"José Mañana Perez\",3.04.1972,ES,13.75,4.84,10.12,1.50,1:08.44,19.18,30.85,2.80,33.88,6:22.75"
				+ System.getProperty("line.separator") +
				"\"Василий Пупкин\",21.10.1980,UA,13.43,4.35,8.64,1.50,1:06.06,19.05,24.89,2.20,33.48,6:51.01";
	}

	private File tempFile() throws IOException {
		File temp = File.createTempFile("temp", ".tmp");
		temp.deleteOnExit();
		return temp;
	}
}
