package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Test;
import org.w3c.dom.Document;


/**
 * CountryTest
 *
 * @author anton
 */
public class CountryTest {
	@Test
	public void equality() throws Exception {
		assertXMLEqual("<country/>", "<country></country>");
	}
	
	@Test
	public void extraction() throws Exception {
		Document doc = loadDocument("country.xml");
		assertXpathExists("/countries/country", doc);
		assertXpathEvaluatesTo("EE", "/countries/country[1]/@code", doc);
	}

	private Document loadDocument(String xmlFile) throws Exception {
		InputStream stream = this.getClass().getResourceAsStream("country.xml");
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		return builder.parse(stream);
	}
}
