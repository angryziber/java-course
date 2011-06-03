package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         5/31/1112:56 AM
 */
public class CSVOutputTest extends AthleteOutputTest {

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

		new CSVOutput().output(athletes, tempFile.getCanonicalPath());
		assertThat(FileUtils.readFileToString(tempFile), equalTo(someBasicOutputString()));
	}

	@Override
	String someBasicOutputString() {
		try {
			return loadFile(getClass(),"output.csv");
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
