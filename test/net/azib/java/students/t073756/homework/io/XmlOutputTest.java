package net.azib.java.students.t073756.homework.io;

import net.azib.java.students.t073756.homework.TestHelper;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;

import java.io.File;

import static net.azib.java.students.t073756.homework.TestHelper.createAthleteList;
import static net.azib.java.students.t073756.homework.TestHelper.getFileContent;

public class XmlOutputTest {

	private final String expectedXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n" +
			"<Decathlon>\n" +
			"<athlete>\n" +
			"<place>5</place>\n" +
			"<overall_result>5000</overall_result>\n" +
			"<name>Siim Susi</name>\n" +
			"<birthday>01.01.1976</birthday>\n" +
			"<country>EE</country>\n" +
			"<M_100>12.61</M_100>\n" +
			"<LONG_JUMP>5.00</LONG_JUMP>\n" +
			"<SHOT_PUT>9.22</SHOT_PUT>\n" +
			"<HIGH_JUMP>1.50</HIGH_JUMP>\n" +
			"<M_400>59.39</M_400>\n" +
			"<HURDLES_110>16.43</HURDLES_110>\n" +
			"<DISCUS_THROW>21.60</DISCUS_THROW>\n" +
			"<POLE_VAULT>2.60</POLE_VAULT>\n" +
			"<JAVELIN_THROW>35.81</JAVELIN_THROW>\n" +
			"<M_1500>5:25.72</M_1500>\n" +
			"</athlete>\n" +
			"</Decathlon>";

	@Test
	public void testWriteAthletesToXml() throws Exception {
		File xmlFile = TestHelper.createTempFile();

		new XmlOutput(xmlFile).writeAthletes(createAthleteList());

		XMLAssert.assertXMLEqual(expectedXml, getFileContent(xmlFile));
	}


}
