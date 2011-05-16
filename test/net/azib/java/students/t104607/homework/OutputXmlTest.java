package net.azib.java.students.t104607.homework;
// @author 104607 IASM

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.ls.LSResourceResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathsEqual;
import static org.custommonkey.xmlunit.XMLUnit.buildTestDocument;

/*
http://xmlunit.sourceforge.net/api/
 */
public class OutputXmlTest {
	private ByteArrayOutputStream outputStream;
	private ByteArrayInputStream inputStream;

	@Before
	public void setUp() throws TransformerException, IOException, SAXException, ParserConfigurationException, ParseException {
		List<Athlete> athletes = new ArrayList<Athlete>();
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		athletes.add(new Athlete("I.Murumüts",dateFormat.parse("19.06.1980"),"EE",
				9.58, 8.95, 23.12, 2.45, 43.18, 12.87, 74.08, 6.14, 98.48, 206.0));
		outputStream = new ByteArrayOutputStream();
		new OutputXml().save(outputStream, athletes);
		inputStream = new ByteArrayInputStream(outputStream.toByteArray());
	}

	@Test
	public void xpathOnActualDocument() throws ParserConfigurationException, IOException, SAXException, XpathException {
		Document doc = buildTestDocument(new InputSource(inputStream));
		assertXpathEvaluatesTo("3:26", "/decathlon/athlete/event[10]/result", doc);
	}

	@Test
	public void validateWithXSD() throws IOException, SAXException {
		// This method takes 25 second !!!
		Validator validator = new Validator(new InputStreamReader(inputStream));
		validator.useXMLSchema(true);
		validator.setJAXP12SchemaSource(OutputXml.class.getResourceAsStream("decathlon.xsd"));
		assertTrue(validator.toString(), validator.isValid());
	}

	@Test
	public void validateWithDTD () throws SAXException {
		Validator validator = new Validator(new InputStreamReader(inputStream),
				OutputXml.class.getResource("decathlon.dtd").toExternalForm(),"decathlon");
		assertTrue(validator.toString(),validator.isValid());
	}
}
