package net.azib.java.students.t103800.homework.decathlon;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.text.ParseException;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExporterTest {

	private String[] consoleTestAnswers = {
	"1. 7764406, \"Lamba Ajus\", 01.01.2000, SO, 11:06.00, 666.00, 666.00, 666.00, 11:06.00, 11:06.00, 666.00, " +
			"666.00, 666.00, 11:06.00",
	"2. 354528, \"ЖЙЙЮ\", 11.11.2011, IN, 1:14.41, 74.41, 74.41, 74.41, 1:14.41, 1:14.41, 74.41, 74.41, 74.41, 1:14.41",
	"3. 15504, \"Ufo Laev Väljus\", 28.02.1992, EE, 01.00, 1.00, 1.00, 1.00, 01.00, 01.00, 1.00, 1.00, 1.00, 01.00"};

	private String[] csvTestAnswers = {
	"1,7764406,\"Lamba Ajus\",01.01.2000,SO,11:06.00,666.00,666.00,666.00,11:06.00,11:06.00,666.00,666.00,666.00,11:06.00",
	"2,354528,\"ЖЙЙЮ\",11.11.2011,IN,1:14.41,74.41,74.41,74.41,1:14.41,1:14.41,74.41,74.41,74.41,1:14.41",
	"3,15504,\"Ufo Laev Väljus\",28.02.1992,EE,01.00,1.00,1.00,1.00,01.00,01.00,1.00,1.00,1.00,01.00"};

	private Athlete[] results;

	@Before
	public void setup() throws ParseException, CountryCodeException {
		results = new Athlete[3];
		results[0] = new Athlete();
		results[0].setName("Ufo Laev Väljus");
		results[0].setBirthDate("28.02.1992");
		results[0].setCountryCode("ee");
		for(Athlete.Event event : Athlete.Event.values()) results[0].setResult(event, 1.0);

		results[1] = new Athlete();
		results[1].setName("ЖЙЙЮ");
		results[1].setBirthDate("2011-11-11");
		results[1].setCountryCode("in");
		for(Athlete.Event event : Athlete.Event.values()) results[1].setResult(event, 74.4055);

		results[2] = new Athlete();
		results[2].setName("Lamba Ajus");
		results[2].setBirthDate("1.1.2000");
		results[2].setCountryCode("SO");
		for(Athlete.Event event : Athlete.Event.values()) results[2].setResult(event, 666);
	}

	@Test
	public void testExportToConsole() throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		Exporter.getExporter().exportToConsole(results, new PrintStream(outStream));
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new ByteArrayInputStream(outStream.toByteArray())));

		assertEquals(consoleTestAnswers[0], reader.readLine());
		assertEquals(consoleTestAnswers[1], reader.readLine());
		assertEquals(consoleTestAnswers[2], reader.readLine());
	}

	@Test
	public void testExportAsCSV() throws IOException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		Exporter.getExporter().exportToConsole(results, new PrintStream(outStream));
		BufferedReader reader = new BufferedReader(new InputStreamReader
				(new ByteArrayInputStream(outStream.toByteArray())));

		assertEquals(consoleTestAnswers[0], reader.readLine());
		assertEquals(consoleTestAnswers[1], reader.readLine());
		assertEquals(consoleTestAnswers[2], reader.readLine());
	}

	@Test
	public void exportAsXMLTest() throws ExporterException, ParserConfigurationException, IOException, SAXException {
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		Exporter.getExporter().exportAsXML(results, new PrintStream(outStream));
		ByteArrayInputStream inputStream = new ByteArrayInputStream(outStream.toByteArray());
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();

		try {
			builder.parse(new InputSource(inputStream));
		} catch (Exception e) {
			fail("XML is not valid.");
		}
	}

	@Test
	public void exportAsHTMLLTest() throws ExporterException {
	}

}