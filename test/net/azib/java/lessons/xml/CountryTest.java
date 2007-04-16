package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.custommonkey.xmlunit.Validator;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * CountryTest
 *
 * @author anton
 */
public class CountryTest {
	
	private String xml;
	
	@Before
	public void readXMLIntoString() throws IOException {
		InputStream in = getClass().getResourceAsStream("country.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		StringBuilder xml = new StringBuilder();
		String line;
		while ((line = reader.readLine()) != null) {
			xml.append(line).append('\n');
		}
		this.xml = xml.toString();
		reader.close();
	}

	@Test
	public void testValid() throws Exception {
		InputStreamReader xmlReader = new InputStreamReader(getClass().getResourceAsStream("country.xml"));
		String xsdPath = getClass().getResource("country.xsd").getPath();
		Validator v = new Validator(xmlReader, xsdPath);
		v.useXMLSchema(true);
		v.assertIsValid();
	}
	
	@Test
	public void testXPath() throws Exception {
		assertXpathEvaluatesTo("Estonia", "/country/name", xml);
	}
	
	@Test
	public void testEquals() throws Exception {
		String expected = 
			"<country xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xsi:noNamespaceSchemaLocation='country.xsd'>" +
			"<code>EE</code>" +
			"<name>Estonia</name>" +
			"<population>" + 1350000 + "</population>  " +
			"</country>";
		XMLUnit.setIgnoreWhitespace(true);
		assertXMLEqual(expected, xml);
	}
}
