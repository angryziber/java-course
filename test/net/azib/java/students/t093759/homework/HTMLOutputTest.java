package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author dionis
 *         6/3/11 2:45 PM
 */
public class HTMLOutputTest extends AthleteOutputTest {
	@Test
	public void htmlExample() throws IOException, SAXException {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		File tempFile = tempFile();

		new HTMLOutput().output(athletes, tempFile.getCanonicalPath());
		assertXMLEqual(someBasicOutputString(), manyLinesTrimmedAndGluedIntoOne(FileUtils.readFileToString(tempFile)));
	}

	@Override
	String someBasicOutputString() {
		try {
			return manyLinesTrimmedAndGluedIntoOne(loadFile(getClass(), "output.html"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
