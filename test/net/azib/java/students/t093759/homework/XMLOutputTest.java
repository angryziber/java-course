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
 *         6/1/118:20 PM
 */
public class XMLOutputTest extends AthleteOutputTest {
	@Test(expected = IllegalArgumentException.class)
	public void exactlyOneAdditionalParamShouldBeProvided() {
		new XMLOutput().output(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void additionalParamShouldBeString() {
		new XMLOutput().output(null, 12);
	}

	@Test
	public void xmlExample() throws IOException, SAXException {
		List<Athlete> athletes = setUpMockedAthletes();
		assertThat(athletes.size(), is(2));
		File tempFile = tempFile();

		new XMLOutput().output(athletes, tempFile.getCanonicalPath());
		assertXMLEqual(someBasicOutputString(), manyLinesTrimmedAndGluedIntoOne(FileUtils.readFileToString(tempFile)));
	}

	@Override
	String someBasicOutputString() {
		try {
			return manyLinesTrimmedAndGluedIntoOne(loadFile(getClass(), "output.xml"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

}
