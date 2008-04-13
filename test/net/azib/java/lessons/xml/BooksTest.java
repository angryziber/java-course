package net.azib.java.lessons.xml;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * CountryTest
 *
 * @author anton
 */
public class BooksTest {
	
	private Document xml;
	
	@Before
	public void readXML() throws IOException, ParserConfigurationException, SAXException {
		xml = XMLUnit.buildTestDocument(new InputSource(getClass().getResourceAsStream("books.xml")));
	}

	@Test
	public void testXPath() throws Exception {
		assertXpathExists("//book", xml);
	}
}
