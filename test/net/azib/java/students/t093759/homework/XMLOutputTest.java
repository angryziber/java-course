package net.azib.java.students.t093759.homework;

import org.apache.commons.io.FileUtils;
import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

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
		assertXMLEqual(someBasicOutputString(),FileUtils.readFileToString(tempFile));
	}

	@Override
	String someBasicOutputString() {
		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?><decathlon><athlete><name>José Mañana Perez</name><countryISO2LetterCode>ES</countryISO2LetterCode><dateOfBirth>3.04.1972</dateOfBirth><oneHundredMeterSprint>13.75</oneHundredMeterSprint><longJump>4.84</longJump><shotPut>10.12</shotPut><highJump>1.50</highJump><fourHundredMeterSprint>1:08.44</fourHundredMeterSprint><oneHundredTenMeterHurdles>19.18</oneHundredTenMeterHurdles><discusThrow>30.85</discusThrow><poleVault>2.80</poleVault><javelinThrow>33.88</javelinThrow><thousandFiveHundredMeterSpring>6:22.75</thousandFiveHundredMeterSpring></athlete><athlete><name>Василий Пупкин</name><countryISO2LetterCode>UA</countryISO2LetterCode><dateOfBirth>21.10.1980</dateOfBirth><oneHundredMeterSprint>13.43</oneHundredMeterSprint><longJump>4.35</longJump><shotPut>8.64</shotPut><highJump>1.50</highJump><fourHundredMeterSprint>1:06.06</fourHundredMeterSprint><oneHundredTenMeterHurdles>19.05</oneHundredTenMeterHurdles><discusThrow>24.89</discusThrow><poleVault>2.20</poleVault><javelinThrow>33.48</javelinThrow><thousandFiveHundredMeterSpring>6:51.01</thousandFiveHundredMeterSpring></athlete></decathlon>";
	}

	private File tempFile() throws IOException {
		File temp = File.createTempFile("temp", ".tmp");
		temp.deleteOnExit();
		return temp;
	}
}
