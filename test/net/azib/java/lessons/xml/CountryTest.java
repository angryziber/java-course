package net.azib.java.lessons.xml;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.custommonkey.xmlunit.XMLAssert.*;

import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


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
