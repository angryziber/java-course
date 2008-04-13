package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.custommonkey.xmlunit.XMLAssert.assertXMLValid;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;

import java.io.InputStreamReader;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

/**
 * CountryTest
 *
 * @author anton
 */
public class CountryTest {
	
	private Document xml;
	
	@Before
	public void readXMLIntoString() throws Exception {
		this.xml = XMLUnit.buildTestDocument(new InputSource(getClass().getResourceAsStream("country.xml")));
	}
	
	@Test
	public void testXPath() throws Exception {
		assertXpathEvaluatesTo("Estonia", "/country/name", xml);
	}
	
	@Test
	public void testEquals() throws Exception {
		Document expected =
			XMLUnit.buildControlDocument(
			"<country>" +
			"<name>Estonia</name>" +
			"<phone_code>372</phone_code>" +
			"<population>" + 1350000 + "</population>  " +
			"</country>");
		XMLUnit.setIgnoreWhitespace(true);
		assertXMLEqual(expected, xml);
	}

//	@Test
	public void testValid() throws Exception {
		InputStreamReader xmlReader = new InputStreamReader(getClass().getResourceAsStream("country.xml"));
		String xsdPath = getClass().getResource("country.xsd").getPath();
		Validator validator = new Validator(xmlReader, xsdPath);
		validator.useXMLSchema(true);
		assertXMLValid(validator);
	}
}
